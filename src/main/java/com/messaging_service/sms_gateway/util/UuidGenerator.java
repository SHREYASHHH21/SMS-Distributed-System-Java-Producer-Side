package com.messaging_service.sms_gateway.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {
    @Bean
    public String generate(){
        return UUID.randomUUID().toString();
    }
}
