package com.kozmosz.issues.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.kozmosz.issues.db.dao.DamageDao;
import com.kozmosz.issues.db.dao.ToolDao;
import com.kozmosz.issues.db.entity.DamageEntity;
import com.kozmosz.issues.db.entity.ToolEntity;

@Database(entities = {DamageEntity.class, ToolEntity.class}, version = 3)
public abstract class DamageDatabase extends RoomDatabase {

    private static DamageDatabase INSTANCE;

    public abstract DamageDao damageDao();

    public abstract ToolDao toolDao();

    public static DamageDatabase getDamageDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), DamageDatabase.class, "user-database")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
