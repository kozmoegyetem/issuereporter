package com.kozmosz.issues.interactor.network;

import android.util.Log;

import com.kozmosz.issues.DamageReporterApplication;
import com.kozmosz.issues.interactor.exception.InvalidRequestException;
import com.kozmosz.issues.interactor.exception.NokResponseException;
import com.kozmosz.issues.interactor.service.event.EventType;
import com.kozmosz.issues.interactor.service.event.FindDamagesEvent;
import com.kozmosz.issues.interactor.service.event.InfoEvent;
import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.network.DamagesApi;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

import static com.kozmosz.issues.config.MainConfig.LOG_TAG;

public class RestInteractor implements NetworkInteractor {

    @Inject
    DamagesApi damagesApi;

    public RestInteractor() {
        DamageReporterApplication.injector.inject(this);
    }

    @Override
    public void addDamage(DamageDTO damageDTO) {
        Log.d(LOG_TAG, "addDamage sent via Rest");
        InfoEvent addEvent = new InfoEvent(EventType.ADD);

        try {
            Response response = damagesApi.addDamage(damageDTO).execute();
            if (response.code() != 200) {
                throw new NokResponseException("NOK response");
            }
            addEvent.setCode(response.code());
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            addEvent.setThrowable(e);
        }
        EventBus.getDefault().post(addEvent);
    }

    @Override
    public void modDamage(DamageDTO damageDTO) {
        Log.d(LOG_TAG, "modDamage sent via Rest");
        InfoEvent modDamageEvent = new InfoEvent(EventType.MOD);
        if (damageDTO.getId() == null) {
            modDamageEvent.setThrowable(new InvalidRequestException("Damage id is null!"));
            EventBus.getDefault().post(modDamageEvent);
            return;
        }

        try {
            Response response = damagesApi.modDamage(damageDTO).execute();
            if (response.code() != 200) {
                modDamageEvent.setCode(response.code());
                throw new NokResponseException("NOK response");
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            modDamageEvent.setThrowable(e);
        }
        EventBus.getDefault().post(modDamageEvent);
    }

    @Override
    public void deleteDamage(DamageDTO damageDTO) {
        Log.d(LOG_TAG, "deleteDamage sent via Rest");
        InfoEvent deleteDamageEvent = new InfoEvent(EventType.DEL);
        if (damageDTO.getId() == null) {
            deleteDamageEvent.setThrowable(new InvalidRequestException("Damage id is null!"));
            EventBus.getDefault().post(deleteDamageEvent);
            return;
        }

        try {
            Response response = damagesApi.deleteDamage(damageDTO.getId()).execute();
            if (response.code() != 200) {
                throw new NokResponseException("NOK response");
            }
            deleteDamageEvent.setCode(response.code());
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            deleteDamageEvent.setThrowable(e);
        }
        EventBus.getDefault().post(deleteDamageEvent);
    }

    @Override
    public FindDamagesEvent findAllDamages() {
        Log.d(LOG_TAG, "findAllDamages sent via Rest");
        FindDamagesEvent findDamagesEvent = new FindDamagesEvent();
        try {
            Response<List<DamageDTO>> response = damagesApi.getAllDamage().execute();
            if (response.code() != 200) {
                throw new Exception("NOK response");
            }
            findDamagesEvent.setCode(response.code());
            findDamagesEvent.setDamages(response.body());
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            findDamagesEvent.setThrowable(e);
        }
        return findDamagesEvent;
    }

    @Override
    public DamageDTO findDamageById(long id) {
        Log.d(LOG_TAG, "findDamageById sent via Rest");
        return null;
    }
}
