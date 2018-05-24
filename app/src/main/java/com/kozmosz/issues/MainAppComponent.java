package com.kozmosz.issues;

import com.kozmosz.issues.db.DbModule;
import com.kozmosz.issues.interactor.InteractorModule;
import com.kozmosz.issues.interactor.dao.DamageRoomDaoInteractor;
import com.kozmosz.issues.interactor.network.RestInteractor;
import com.kozmosz.issues.interactor.service.MainServiceInteractor;
import com.kozmosz.issues.network.NetworkModule;
import com.kozmosz.issues.ui.UIModule;
import com.kozmosz.issues.ui.damage.detail.DamageDetailActivity;
import com.kozmosz.issues.ui.damage.detail.DamageDetailPresenter;
import com.kozmosz.issues.ui.damage.list.DamageListActivity;
import com.kozmosz.issues.ui.damage.list.DamageListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, NetworkModule.class, DbModule.class})
public interface MainAppComponent {
    void inject(DamageDetailActivity damageDetailActivity);

    void inject(DamageDetailPresenter damageDetailPresenter);

    void inject(MainServiceInteractor mainServiceInteractor);

    void inject(DamageListActivity damageListActivity);

    void inject(DamageListPresenter damageListPresenter);

    void inject(RestInteractor restInteractor);

    void inject(DamageRoomDaoInteractor damageRoomDaoInteractor);
}
