package com.kozmosz.issues.interactor.service.event;

import com.kozmosz.issues.model.DamageDTO;

import java.util.List;

public class FindDamagesEvent extends BaseDamageEvent {
    private List<DamageDTO> damages;
    private boolean fromDB;

    public void setFromDB(boolean fromDB) {
        this.fromDB = fromDB;
    }

    public FindDamagesEvent() {
    }

    public FindDamagesEvent(int code, List<DamageDTO> damages, Throwable throwable) {
        setCode(code);
        this.damages = damages;
        setThrowable(throwable);
    }

    public List<DamageDTO> getDamages() {
        return damages;
    }

    public void setDamages(List<DamageDTO> damages) {
        this.damages = damages;
    }

    public boolean isFromDB() {
        return fromDB;
    }
}
