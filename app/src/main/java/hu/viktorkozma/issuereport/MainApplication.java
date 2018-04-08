package hu.viktorkozma.issuereport;

import android.app.Application;
import android.util.Log;

import hu.viktorkozma.issuereport.ui.DaggerMainAppComponent;
import hu.viktorkozma.issuereport.ui.MainAppComponent;
import hu.viktorkozma.issuereport.ui.UIModule;


public class MainApplication extends Application {
    public static MainAppComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMainAppComponent.builder().uIModule(new UIModule(this)).build();

        Log.w("dsfdfds", "df");

    }
}
