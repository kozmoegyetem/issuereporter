package com.kozmosz.issues.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.kozmosz.issues.db.entity.DamageEntity;

import java.util.List;

@Dao
public interface DamageDao {

    @Insert
    void insert(DamageEntity... damageEntities);

    @Update
    void update(DamageEntity... damageEntities);

    @Delete
    void delete(DamageEntity... damageEntities);

    @Query("Select * from damage")
    List<DamageEntity> findAll();

    @Query("Select * from damage where id = :id")
    DamageEntity findById(long id);
}
