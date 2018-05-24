package com.kozmosz.issues.mock.db;

import com.kozmosz.issues.db.dao.DamageDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockDbModule {

    @Singleton
    @Provides
    public DamageDao provideDamageDatabase() {
        return new MockDamageDao();
    }
}
