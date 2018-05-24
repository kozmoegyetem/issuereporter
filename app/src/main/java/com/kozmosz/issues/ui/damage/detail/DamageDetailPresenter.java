package com.kozmosz.issues.ui.damage.detail;

import android.util.Log;

import com.kozmosz.issues.DamageReporterApplication;
import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.interactor.service.ServiceInteractor;
import com.kozmosz.issues.interactor.service.event.BaseDamageEvent;
import com.kozmosz.issues.interactor.service.event.FindDamageEvent;
import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.model.MessageDTO;
import com.kozmosz.issues.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import static com.kozmosz.issues.config.MainConfig.LOG_TAG;

public class DamageDetailPresenter extends Presenter<DamageDetailScreen> {

    @Inject
    ServiceInteractor serviceInteractor;

    private Executor serviceExecutor = Executors.newFixedThreadPool(1);

    @Override
    public void attachScreen(DamageDetailScreen screen) {
        super.attachScreen(screen);
        Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamagerDetailPresenter attachScreen");
        DamageReporterApplication.injector.inject(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
            Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamageDetailPresenter registered eventbus");
        }
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        Log.d(MainConfig.LOG_TAG_LIFECYCLE, "DamagerDetailPresenter detachScreen");
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void saveDamage(final DamageDTO damageDTO) {
        Log.d(LOG_TAG, "addDamage called");
        serviceExecutor.execute(new Runnable() {
            @Override
            public void run() {
                serviceInteractor.addDamage(damageDTO);
            }
        });
    }

    public void modDamage(final DamageDTO damageDTO) {
        Log.d(LOG_TAG, "modDamage called");
        serviceExecutor.execute(new Runnable() {
            @Override
            public void run() {
                serviceInteractor.modDamage(damageDTO);
            }
        });
    }

    public void deleteDamage(long id) {
        Log.d(LOG_TAG, "deleteDamage called");
        final DamageDTO damageDTO = new DamageDTO();
        damageDTO.setId(id);
        serviceExecutor.execute(new Runnable() {
            @Override
            public void run() {
                serviceInteractor.deleteDamage(damageDTO);
            }
        });
    }

    public void findDamageById(final Long id) {
        Log.d(LOG_TAG, "findDamageById called for id: " + id);
        serviceExecutor.execute(new Runnable() {
            @Override
            public void run() {
                serviceInteractor.findDamageById(id);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final FindDamageEvent event) {
        if (event.getThrowable() != null) {
            if (screen != null) {
                screen.showMessage(new MessageDTO(event.getThrowable().getMessage()));
            }
        } else {
            if (screen != null) {
                screen.showDamageDetails(event.getDamage());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final BaseDamageEvent event) {
        if (event.getThrowable() != null) {
            if (screen != null) {
                screen.showMessage(new MessageDTO(event.getThrowable().getMessage()));
            }
        } else {
            if (screen != null) {
                screen.navigateToDamageListScreen();
            }
        }
    }
}
