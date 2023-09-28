package com.apidelivery.models.service.exception;

public class EmailAlreadyExistsException extends BussinessExceptioin{

    public EmailAlreadyExistsException(String message) {
        super(message);
    }

    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
