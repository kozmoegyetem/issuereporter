package com.kozmosz.issues.db;

import android.content.Context;

import com.kozmosz.issues.db.dao.DamageDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {
    private Context context;

    public DbModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public DamageDao provideDamageDatabase() {
        return DamageDatabase.getDamageDatabase(context).damageDao();
    }
}
