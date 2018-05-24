package com.kozmosz.issues.ui.damage.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kozmosz.issues.DamageReporterApplication;
import com.kozmosz.issues.R;
import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.model.MessageDTO;
import com.kozmosz.issues.model.PriorityEnum;
import com.kozmosz.issues.model.StatusEnum;

import java.util.Date;

import javax.inject.Inject;

public class DamageDetailActivity extends AppCompatActivity implements DamageDetailScreen {

    private EditText nameTv;
    private EditText roomValueTv;
    private TextView statusValueTv;
    private EditText categoryValueTv;
    private EditText descriptionValueTv;

    private DamageDTO damageDTO = new DamageDTO();


    @Inject
    DamageDetailPresenter damageDetailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DamageReporterApplication.injector.inject(this);

        setContentView(R.layout.activity_damage_detail);
        setTitle("Damage detail");

        nameTv = findViewById(R.id.nameTv);
        roomValueTv = findViewById(R.id.roomValueTv);
        statusValueTv = findViewById(R.id.statusValueTv);
        descriptionValueTv = findViewById(R.id.descriptionValueTv);
        categoryValueTv = findViewById(R.id.categoryValueTv);
        Button saveBtn = findViewById(R.id.saveBtn);
        Button cancelBtn = findViewById(R.id.cancelBtn);
        View separator2 = findViewById(R.id.separator2);
        TextView commentsTv = findViewById(R.id.comments);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDamageFromUI();
                if (damageDTO.getId() != null) {
                    damageDetailPresenter.modDamage(damageDTO);
                } else {
                    damageDTO.setStatus(StatusEnum.NEW);
                    damageDTO.setReportDate(new Date().getTime());
                    damageDetailPresenter.saveDamage(damageDTO);
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        damageDetailPresenter.attachScreen(this);
        Long damageId = getIntent().getLongExtra(MainConfig.I_EXTRA_DAMAGE_ID, -1L);
        if (damageId != -1)
            damageDetailPresenter.findDamageById(getIntent().getLongExtra(MainConfig.I_EXTRA_DAMAGE_ID, -1L));
        else
            setTitle("New Damage");
    }

    @Override
    protected void onStop() {
        super.onStop();
        damageDetailPresenter.detachScreen();
    }

    @Override
    public void navigateToDamageListScreen() {
        damageDetailPresenter.detachScreen();
        finish();
    }

    @Override
    public void showDamageDetails(DamageDTO damageDTO) {
        Log.d(MainConfig.LOG_TAG, "showDamageDetails");
        this.damageDTO = damageDTO;
        nameTv.setText(damageDTO.getTitle());
        roomValueTv.setText(String.valueOf(damageDTO.getRoomNumber()));
        if (damageDTO.getStatus() != null)
            statusValueTv.setText(damageDTO.getStatus().toString());
        if (damageDTO.getPriority() != null)
            categoryValueTv.setText(damageDTO.getPriority().toString());
        descriptionValueTv.setText(damageDTO.getDescription());
    }

    @Override
    public void showMessage(MessageDTO messageDTO) {
    }

    private void setDamageFromUI() {
        damageDTO.setRoomNumber(Integer.parseInt(roomValueTv.getText().toString()));
        damageDTO.setTitle(nameTv.getText().toString());
        damageDTO.setDescription(descriptionValueTv.getText().toString());
        damageDTO.setPriority(PriorityEnum.fromString(categoryValueTv.getText().toString()));
    }
}
