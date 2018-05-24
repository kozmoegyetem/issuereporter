package com.kozmosz.issues.db.converter;

import android.arch.persistence.room.TypeConverter;

import com.kozmosz.issues.model.StatusEnum;

public class StatusEnumConverter {
    @TypeConverter
    public static StatusEnum toStatusEnum(String value) {
        StatusEnum statusEnum = value == null ? null : StatusEnum.fromString(value);
        return value == null ? null : StatusEnum.fromString(value);
    }

    @TypeConverter
    public static String toString(StatusEnum value) {
        String v = value == null ? null : value.toString();
        return value == null ? null : value.toString();
    }
}
