package com.messaging_service.sms_gateway.services;


public interface UserStatus {
    Boolean check(String userId);
    void blockUser(String userId);
}
