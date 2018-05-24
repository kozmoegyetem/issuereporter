package com.kozmosz.issues.interactor.service.event;

import com.kozmosz.issues.model.DamageDTO;

public class FindDamageEvent {
    private int code;
    private DamageDTO damage;
    private Throwable throwable;

    public FindDamageEvent() {
    }

    public FindDamageEvent(int code, DamageDTO damage, Throwable throwable) {
        this.code = code;
        this.damage = damage;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DamageDTO getDamage() {
        return damage;
    }

    public void setDamage(DamageDTO damage) {
        this.damage = damage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
