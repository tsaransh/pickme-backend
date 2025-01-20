package com.pickme.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    public UserException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
