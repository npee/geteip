package com.npee.eip.advice.exception;

public class CustomQuizNotExistsException extends RuntimeException {
    public CustomQuizNotExistsException() {
        super();
    }

    public CustomQuizNotExistsException(String message) {
        super(message);
    }

    public CustomQuizNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
