package com.apidelivery.models.service.exception;

import java.io.Serial;

public class BussinessExceptioin extends RuntimeException {

    public BussinessExceptioin(String message) {
        super(message);
    }

    public BussinessExceptioin(String message, Throwable cause) {
        super(message, cause);
    }
}
