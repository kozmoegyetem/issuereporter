package com.kozmosz.issues.interactor.exception;

public class NokResponseException extends Exception {

    public NokResponseException(String message) {
        super(message);
    }

    public NokResponseException(int code) {
        super("Nok response! Error code: " + code);
    }

    public NokResponseException(Throwable cause) {
        initCause(cause);
    }
}
