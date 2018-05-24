package com.kozmosz.issues.ui;

import android.content.Context;

import com.kozmosz.issues.ui.damage.detail.DamageDetailPresenter;
import com.kozmosz.issues.ui.damage.list.DamageListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {

    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public DamageDetailPresenter provideDamageDetailPresenter() {
        return new DamageDetailPresenter();
    }

    @Singleton
    @Provides
    public DamageListPresenter provideDamageListPresenter() {
        return new DamageListPresenter();
    }

}
