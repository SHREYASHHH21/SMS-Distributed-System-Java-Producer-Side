package com.messaging_service.sms_gateway.exception;

public class UserBlockedException extends RuntimeException{
    public UserBlockedException(String message) {
        super(message);
    }
}
