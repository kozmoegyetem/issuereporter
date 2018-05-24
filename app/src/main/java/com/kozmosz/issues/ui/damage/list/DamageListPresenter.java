package com.kozmosz.issues.ui.damage.list;

import android.util.Log;

import com.kozmosz.issues.DamageReporterApplication;
import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.interactor.service.ServiceInteractor;
import com.kozmosz.issues.interactor.service.event.FindDamagesEvent;
import com.kozmosz.issues.interactor.service.event.InfoEvent;
import com.kozmosz.issues.model.MessageDTO;
import com.kozmosz.issues.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class DamageListPresenter extends Presenter<DamageListScreen> {

    @Inject
    ServiceInteractor serviceInteractor;

    private Executor serviceExecutor = Executors.newFixedThreadPool(1);

    @Override
    public void attachScreen(DamageListScreen screen) {
        super.attachScreen(screen);
        Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamageListPresenter.attachScreen");
        DamageReporterApplication.injector.inject(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamageListPresenter.detachScreen");
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void refreshDamages() {
        Log.d(MainConfig.LOG_TAG, "damageListPresenter refreshDamages called");
        serviceExecutor.execute(new Runnable() {
            @Override
            public void run() {
                serviceInteractor.findAllDamages();
            }
        });
    }

    public void sync() {
        serviceExecutor.execute(new Runnable() {
            @Override
            public void run() {
                serviceInteractor.sync();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final FindDamagesEvent event) {
        if (event.getThrowable() != null) {
            if (screen != null) {
                screen.showMessage(new MessageDTO(event.getThrowable().getMessage()));
            }
        } else {
            if (screen != null) {
                screen.showDamages(event.getDamages());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final InfoEvent event) {
        Log.d(MainConfig.LOG_TAG, "infoEvent came");
        if (event.getThrowable() != null) {
            if (screen != null) {
                screen.showMessage(new MessageDTO(event.getThrowable().getMessage()));
            }
        } else {
            if (screen != null) {
                switch (event.getEventType()) {
                    case DEL:
                        screen.showMessage(new MessageDTO("Successful delete!"));
                        break;
                    case ADD:
                        screen.showMessage(new MessageDTO("Successful add!"));
                        break;
                    case MOD:
                        screen.showMessage(new MessageDTO("Successful modify!"));
                        break;
                }
            }
        }
    }
}
