package com.kozmosz.issues.interactor.service.event;

import com.kozmosz.issues.interactor.exception.NokResponseException;

public class BaseDamageEvent {
    private int code;
    private Throwable throwable;

    public BaseDamageEvent() {
    }

    public BaseDamageEvent(int code, Throwable throwable) {
        this.code = code;
        this.throwable = throwable;
    }

    public void checkResponse() throws NokResponseException {
        if (throwable != null) {
            throw new NokResponseException(throwable);
        }
        if (code != 200) {
            throw new NokResponseException(code);
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
