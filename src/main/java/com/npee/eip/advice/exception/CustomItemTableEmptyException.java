package com.npee.eip.advice.exception;

public class CustomItemTableEmptyException extends RuntimeException {
    public CustomItemTableEmptyException() {
        super();
    }

    public CustomItemTableEmptyException(String message) {
        super(message);
    }

    public CustomItemTableEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
