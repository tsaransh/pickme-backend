package com.pickme.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ConfigException extends RuntimeException{

    private final String message;
    private final HttpStatus status;

    public ConfigException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
