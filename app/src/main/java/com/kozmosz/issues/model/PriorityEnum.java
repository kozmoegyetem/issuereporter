package com.kozmosz.issues.model;

import com.google.gson.annotations.SerializedName;

public enum PriorityEnum {
    @SerializedName("general")
    GENERAL("general"),

    @SerializedName("urgent")
    URGENT("urgent");

    private String value;

    PriorityEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static PriorityEnum fromString(String text) {
        for (PriorityEnum s : PriorityEnum.values()) {
            if (s.value.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }
}