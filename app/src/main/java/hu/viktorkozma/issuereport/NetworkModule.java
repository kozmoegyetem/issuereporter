package hu.viktorkozma.issuereport;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {

        @Singleton
        @Provides
        public Retrofit.Builder provideRetrofitBuilder() {
            return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create());
        }

        @Singleton
        @Provides
        public IssuesApi provideDamagesApi(Retrofit.Builder retrofitBuilder) {
            return retrofitBuilder.baseUrl(NetworkConfig.ENDPOINT_ADDRESS).build().create(IssuesApi.class);
        }
    }

