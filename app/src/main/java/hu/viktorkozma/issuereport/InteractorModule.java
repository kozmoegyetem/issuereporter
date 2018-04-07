package hu.viktorkozma.issuereport;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    @Singleton
    public DBInteractor provideDBInteractor() {
        return new MainDBInteractor();
    }

}
