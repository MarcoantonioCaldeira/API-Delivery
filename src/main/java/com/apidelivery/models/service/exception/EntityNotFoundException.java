package com.apidelivery.models.service.exception;

public class EntityNotFoundException extends BussinessExceptioin{

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
