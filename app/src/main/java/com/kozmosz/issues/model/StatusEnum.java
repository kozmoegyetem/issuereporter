package com.kozmosz.issues.model;

import com.google.gson.annotations.SerializedName;

public enum StatusEnum {
    @SerializedName("new")
    NEW("new"),

    @SerializedName("ongoing")
    ONGOING("ongoing"),

    @SerializedName("closed")
    CLOSED("closed");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static StatusEnum fromString(String text) {
        for (StatusEnum s : StatusEnum.values()) {
            if (s.value.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }
}