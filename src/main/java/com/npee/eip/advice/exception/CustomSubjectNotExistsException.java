package com.npee.eip.advice.exception;

public class CustomSubjectNotExistsException extends RuntimeException {
    public CustomSubjectNotExistsException() {
        super();
    }

    public CustomSubjectNotExistsException(String message) {
        super(message);
    }

    public CustomSubjectNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
