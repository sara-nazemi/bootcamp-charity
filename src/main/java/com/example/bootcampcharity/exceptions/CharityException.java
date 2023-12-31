package com.example.bootcampcharity.exceptions;

public class CharityException extends RuntimeException{
    public CharityException() {
    }

    public CharityException(String message) {
        super(message);
    }

    public CharityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CharityException(Throwable cause) {
        super(cause);
    }

    public CharityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
