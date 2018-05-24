package com.kozmosz.issues.mock.network;

import com.kozmosz.issues.network.DamagesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {
    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create());
    }

    @Singleton
    @Provides
    public DamagesApi provideDamagesApi(Retrofit.Builder retrofitBuilder) {
        return new MockDamagesApi();
    }
}
