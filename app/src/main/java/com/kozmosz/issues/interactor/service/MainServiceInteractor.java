package com.kozmosz.issues.interactor.service;

import android.util.Log;

import com.kozmosz.issues.DamageReporterApplication;
import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.interactor.dao.DamageDaoInteractor;
import com.kozmosz.issues.interactor.exception.NokResponseException;
import com.kozmosz.issues.interactor.network.NetworkInteractor;
import com.kozmosz.issues.interactor.service.event.EventType;
import com.kozmosz.issues.interactor.service.event.FindDamageEvent;
import com.kozmosz.issues.interactor.service.event.FindDamagesEvent;
import com.kozmosz.issues.interactor.service.event.InfoEvent;
import com.kozmosz.issues.model.DamageDTO;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

public class MainServiceInteractor implements ServiceInteractor {

    @Inject
    NetworkInteractor networkInteractor;

    @Inject
    DamageDaoInteractor damageDaoInteractor;

    // will come from a broadcast reciever
    private boolean networkAvailable = false;

    public MainServiceInteractor() {
        DamageReporterApplication.injector.inject(this);
    }

    @Override
    public void addDamage(DamageDTO damageDTO) {
        InfoEvent event = new InfoEvent(EventType.ADD);
        try {
            if (networkAvailable) {
                networkInteractor.addDamage(damageDTO);
            } else {
                damageDaoInteractor.addDamage(damageDTO);
            }
        } catch (Exception e) {
            event.setThrowable(e);
        }
        EventBus.getDefault().post(event);
    }

    @Override
    public void modDamage(DamageDTO damageDTO) {
        InfoEvent event = new InfoEvent(EventType.MOD);
        try {
            if (networkAvailable) {
                networkInteractor.modDamage(damageDTO);
            } else {
                damageDaoInteractor.modDamage(damageDTO);
            }
        } catch (Exception e) {
            event.setThrowable(e);
        }
        EventBus.getDefault().post(event);
    }

    @Override
    public void deleteDamage(DamageDTO damageDTO) {
        InfoEvent event = new InfoEvent(EventType.DEL);
        try {
            if (networkAvailable) {
                networkInteractor.deleteDamage(damageDTO);
            } else {
                damageDaoInteractor.deleteDamage(damageDTO);
            }
        } catch (Exception e) {
            event.setThrowable(e);
        }
        EventBus.getDefault().post(event);
    }

    @Override
    public void findAllDamages() {
        FindDamagesEvent event;
        if (networkAvailable) {
            event = networkInteractor.findAllDamages();
        } else {
            event = damageDaoInteractor.findAllDamages();
        }
        EventBus.getDefault().post(event);
    }

    @Override
    public void findDamageById(long id) {
        FindDamageEvent event = new FindDamageEvent();
        try {
            if (networkAvailable) {
                event.setDamage(networkInteractor.findDamageById(id));
            } else {
                event.setDamage(damageDaoInteractor.findDamageById(id));
            }
        } catch (Exception e) {
            event.setThrowable(e);
        }
        EventBus.getDefault().post(event);
    }

    @Override
    public void sync() {
        Log.d(MainConfig.LOG_TAG, "syncing....");
        FindDamagesEvent networkEvent = networkInteractor.findAllDamages();
        FindDamagesEvent dbEvent = damageDaoInteractor.findAllDamages();
        try {
            networkEvent.checkResponse();
            dbEvent.checkResponse();
        } catch (NokResponseException e) {
            FindDamagesEvent nokEvent = new FindDamagesEvent();
            nokEvent.setThrowable(e);
            EventBus.getDefault().post(nokEvent);
        }
        mergeLocalData(dbEvent.getDamages(), networkEvent.getDamages());
        findAllDamages();
    }

    private void mergeLocalData(List<DamageDTO> localData, List<DamageDTO> remoteData) {
        // Do some comparison and send final data to remote
    }
}
