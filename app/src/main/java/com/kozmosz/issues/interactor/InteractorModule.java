package com.kozmosz.issues.interactor;

import com.kozmosz.issues.interactor.dao.DamageDaoInteractor;
import com.kozmosz.issues.interactor.dao.DamageRoomDaoInteractor;
import com.kozmosz.issues.interactor.network.NetworkInteractor;
import com.kozmosz.issues.interactor.network.RestInteractor;
import com.kozmosz.issues.interactor.service.MainServiceInteractor;
import com.kozmosz.issues.interactor.service.ServiceInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Singleton
    @Provides
    public NetworkInteractor provideNetworkInteractor() {
        return new RestInteractor();
    }

    @Singleton
    @Provides
    public ServiceInteractor provideServiceInteractor() {
        return new MainServiceInteractor();
    }

    @Singleton
    @Provides
    public DamageDaoInteractor provideDamageDao() {
        return new DamageRoomDaoInteractor();
    }
}
