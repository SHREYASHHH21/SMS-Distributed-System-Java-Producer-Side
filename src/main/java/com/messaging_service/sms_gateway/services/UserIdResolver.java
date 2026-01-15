package com.messaging_service.sms_gateway.services;

public interface UserIdResolver {
    public String resolve(String phoneNumber);
}
