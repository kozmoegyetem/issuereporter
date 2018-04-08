package hu.viktorkozma.issuereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import hu.viktorkozma.issuereport.Data.Issue;


public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.w("injektor","injektroelott");
        MainApplication.injector.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        mainPresenter.attachScreen(this);
        mainPresenter.networkconnect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showlist(List<Issue> list) {
        Log.w("Showlist","showlist");
    }

    @Override
    public void navigatetoselect(long id) {
        Log.w("navigatetoselect","id");
    }



}
