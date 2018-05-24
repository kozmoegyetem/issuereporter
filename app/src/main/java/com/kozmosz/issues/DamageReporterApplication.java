package com.kozmosz.issues;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.kozmosz.issues.db.DbModule;
import com.kozmosz.issues.ui.UIModule;

public class DamageReporterApplication extends Application {

    public static MainAppComponent injector;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMainAppComponent.builder().
                uIModule(new UIModule(this)).
                dbModule(new DbModule(this)).build();
        sAnalytics = GoogleAnalytics.getInstance(this);
    }

    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
}
