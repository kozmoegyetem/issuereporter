package com.kozmosz.issues.db.converter;

import android.arch.persistence.room.TypeConverter;

import com.kozmosz.issues.model.PriorityEnum;

public class PriorityEnumConverter {
    @TypeConverter
    public static PriorityEnum toStatusEnum(String value) {
        return value == null ? null : PriorityEnum.fromString(value);
    }

    @TypeConverter
    public static String toString(PriorityEnum value) {
        return value == null ? null : value.toString();
    }
}
