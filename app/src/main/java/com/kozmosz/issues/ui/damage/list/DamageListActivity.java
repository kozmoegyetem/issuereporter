package com.kozmosz.issues.ui.damage.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.kozmosz.issues.DamageReporterApplication;
import com.kozmosz.issues.R;
import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.model.MessageDTO;
import com.kozmosz.issues.ui.damage.detail.DamageDetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DamageListActivity extends AppCompatActivity implements DamageListScreen {

    @Inject
    DamageListPresenter damageListPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<DamageDTO> myDataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Damage reports");
        Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamageListActivity.onCreate");
        setContentView(R.layout.activity_damage_list);
        DamageReporterApplication.injector.inject(this);

        FloatingActionButton newDamageBtn = findViewById(R.id.newDamageBtn);
        newDamageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DamageListActivity.this, DamageDetailActivity.class);
                startActivity(intent);
            }
        });

        final Button refreshBtn = findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                damageListPresenter.refreshDamages();
            }
        });

        mRecyclerView = findViewById(R.id.damageListRV);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        Tracker t = ((DamageReporterApplication) getApplication()).getDefaultTracker();
        t.setScreenName("AndroidDamageReporter DamageListActivity");
        t.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamageListActivity.onStart");
        damageListPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        damageListPresenter.refreshDamages();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamageListActivity.onStop");
        damageListPresenter.detachScreen();
    }

    @Override
    public void navigateToDamageDetail(long damageId) {
        Intent intent = new Intent(this, DamageDetailActivity.class);
        intent.putExtra(MainConfig.I_EXTRA_DAMAGE_ID, damageId);
        intent.putExtra(MainConfig.I_EXTRA_DAMAGE_EDIT, false);
        damageListPresenter.detachScreen();
        startActivity(intent);
    }

    @Override
    public void showDamages(List<DamageDTO> damageDTOList) {
        Log.d(MainConfig.LOG_TAG, "showDamages");
        for (DamageDTO damageDTO : damageDTOList) {
            Log.i(MainConfig.LOG_TAG, damageDTO.toString());
        }
        myDataset.clear();
        myDataset.addAll(damageDTOList);
        mAdapter.notifyDataSetChanged();
        showMessage(new MessageDTO("Damage reports reloaded!"));
    }

    @Override
    public void showMessage(MessageDTO messageDTO) {
    }
}
