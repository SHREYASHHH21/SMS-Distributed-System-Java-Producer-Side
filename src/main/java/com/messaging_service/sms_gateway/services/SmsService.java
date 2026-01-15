package com.messaging_service.sms_gateway.services;

import com.messaging_service.sms_gateway.dto.SmsEventDto;
import com.messaging_service.sms_gateway.dto.SmsRequestDto;

public interface SmsService {
    SmsEventDto send(SmsRequestDto req);
    void block(SmsRequestDto req);
}
