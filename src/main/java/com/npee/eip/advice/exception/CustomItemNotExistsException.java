package com.npee.eip.advice.exception;

public class CustomItemNotExistsException extends RuntimeException {
    public CustomItemNotExistsException() {
        super();
    }

    public CustomItemNotExistsException(String message) {
        super(message);
    }

    public CustomItemNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
