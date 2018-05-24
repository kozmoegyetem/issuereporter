package com.kozmosz.issues.interactor.dao;

import android.util.Log;

import com.kozmosz.issues.DamageReporterApplication;
import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.db.dao.DamageDao;
import com.kozmosz.issues.db.entity.DamageEntity;
import com.kozmosz.issues.interactor.service.event.EventType;
import com.kozmosz.issues.interactor.service.event.FindDamagesEvent;
import com.kozmosz.issues.interactor.service.event.InfoEvent;
import com.kozmosz.issues.model.DamageDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DamageRoomDaoInteractor implements DamageDaoInteractor {

    @Inject
    DamageDao damageDao;

    public DamageRoomDaoInteractor() {
        DamageReporterApplication.injector.inject(this);
    }

    @Override
    public InfoEvent addDamage(DamageDTO damageDTO) {
        Log.d(MainConfig.LOG_TAG, "addDamage to db");
        InfoEvent addEvent = new InfoEvent(EventType.ADD);
        try {
//            damageDTO.setId();
            damageDao.insert(new DamageEntity(damageDTO));
            addEvent.setCode(200);
        } catch (Exception e) {
            addEvent.setThrowable(e);
        }
        return addEvent;
    }

    @Override
    public InfoEvent modDamage(DamageDTO damageDTO) {
        Log.d(MainConfig.LOG_TAG, "modDamage to db");
        InfoEvent modEvent = new InfoEvent(EventType.MOD);
        try {
            damageDao.update(new DamageEntity(damageDTO));
            modEvent.setCode(200);
        } catch (Exception e) {
            modEvent.setThrowable(e);
        }
        return modEvent;
    }

    @Override
    public InfoEvent deleteDamage(DamageDTO damageDTO) {
        Log.d(MainConfig.LOG_TAG, "deleteDamage from db");
        InfoEvent deleteEvent = new InfoEvent(EventType.DEL);
        try {
            damageDao.delete(new DamageEntity(damageDTO));
            deleteEvent.setCode(200);
        } catch (Exception e) {
            deleteEvent.setThrowable(e);
        }
        return deleteEvent;
    }

    @Override
    public FindDamagesEvent findAllDamages() {
        Log.d(MainConfig.LOG_TAG, "refreshDamages from db");
        FindDamagesEvent findDamagesEvent = new FindDamagesEvent();
        findDamagesEvent.setDamages(mapDamageEntities(damageDao.findAll()));
        return findDamagesEvent;
    }

    @Override
    public DamageDTO findDamageById(long id) {
        Log.d(MainConfig.LOG_TAG, "findDamageById from db");
        return new DamageDTO(damageDao.findById(id));
    }

    private List<DamageDTO> mapDamageEntities(List<DamageEntity> entityList) {
        Log.d(MainConfig.LOG_TAG, "mapDamageEntities: " + entityList);
        List<DamageDTO> damageDTOS = new ArrayList<>();
        for (DamageEntity entity : entityList) {
            damageDTOS.add(new DamageDTO(entity));
        }
        return damageDTOS;
    }
}
