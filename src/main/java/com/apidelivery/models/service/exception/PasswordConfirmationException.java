package com.apidelivery.models.service.exception;

public class PasswordConfirmationException extends BussinessExceptioin{

    public PasswordConfirmationException(String message) {
        super(message);
    }

    public PasswordConfirmationException(String message, Throwable cause) {
        super(message, cause);
    }
}
