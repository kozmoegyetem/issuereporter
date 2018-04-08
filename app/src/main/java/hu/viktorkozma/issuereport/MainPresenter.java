package hu.viktorkozma.issuereport;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import hu.viktorkozma.issuereport.Data.Issue;
import hu.viktorkozma.issuereport.ui.DaggerMainAppComponent;

public class MainPresenter extends Presenter<MainScreen>{

    @Inject
    DBInteractor dbInteractor;

    public void networkconnect(){

        Log.w("Networkconnect","connect");
        dbInteractor.findAll();

        screen.showlist(new ArrayList<Issue>());

    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);

        MainApplication.injector.inject(this);

    }
}
