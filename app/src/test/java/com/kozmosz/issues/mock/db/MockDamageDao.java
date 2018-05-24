package com.kozmosz.issues.mock.db;

import android.util.Log;

import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.db.dao.DamageDao;
import com.kozmosz.issues.db.entity.DamageEntity;
import com.kozmosz.issues.model.PriorityEnum;
import com.kozmosz.issues.model.StatusEnum;

import java.util.ArrayList;
import java.util.List;

public class MockDamageDao implements DamageDao {
    @Override
    public void insert(DamageEntity... damageEntities) {
        Log.d(MainConfig.LOG_TAG, "mock insert");
    }

    @Override
    public void update(DamageEntity... damageEntities) {
        Log.d(MainConfig.LOG_TAG, "mock update");
    }

    @Override
    public void delete(DamageEntity... damageEntities) {
        Log.d(MainConfig.LOG_TAG, "mock delete");
    }

    @Override
    public List<DamageEntity> findAll() {
        DamageEntity damageEntity0 = new DamageEntity();
        damageEntity0.setId(0L);
        damageEntity0.setTitle("mock 0");
        DamageEntity damageEntity1 = new DamageEntity();
        damageEntity1.setId(1L);
        damageEntity1.setTitle("mock 1");
        List<DamageEntity> damageEntities = new ArrayList<>();
        damageEntities.add(damageEntity0);
        damageEntities.add(damageEntity1);
        return damageEntities;
    }

    @Override
    public DamageEntity findById(long id) {
        Log.d(MainConfig.LOG_TAG, "mock delete");
        DamageEntity damageEntity = new DamageEntity();
        damageEntity.setId(id);
        damageEntity.setTitle("mock 1");
        damageEntity.setRoomNumber(704);
        damageEntity.setDescription("Sample description");
        damageEntity.setStatus(StatusEnum.NEW);
        damageEntity.setPriority(PriorityEnum.URGENT);
        return damageEntity;
    }
}
