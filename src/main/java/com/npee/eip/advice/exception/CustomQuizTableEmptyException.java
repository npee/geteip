package com.npee.eip.advice.exception;

public class CustomQuizTableEmptyException extends RuntimeException {
    public CustomQuizTableEmptyException() {
        super();
    }

    public CustomQuizTableEmptyException(String message) {
        super(message);
    }

    public CustomQuizTableEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
