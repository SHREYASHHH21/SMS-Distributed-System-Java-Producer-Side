package com.messaging_service.sms_gateway.producer;

import com.messaging_service.sms_gateway.dto.SmsEventDto;

public interface KafkaProducer {
    public void publish(SmsEventDto req);
}
