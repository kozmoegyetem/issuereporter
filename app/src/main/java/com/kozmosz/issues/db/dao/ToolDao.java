package com.kozmosz.issues.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.kozmosz.issues.db.entity.DamageEntity;
import com.kozmosz.issues.db.entity.ToolEntity;

import java.util.List;

@Dao
public interface ToolDao {

    @Insert
    void insert(ToolEntity... toolEntities);

    @Update
    void update(ToolEntity... toolEntities);

    @Delete
    void delete(ToolEntity... toolEntities);

    @Query("SELECT * FROM tool WHERE damageId=:damageId")
    List<DamageEntity> findToolsForDamage(final int damageId);
}