package com.messaging_service.sms_gateway.producer.impl;

import com.messaging_service.sms_gateway.dto.SmsEventDto;
import com.messaging_service.sms_gateway.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class kafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<String,SmsEventDto> kafkaTemplate;
//  private String key="Sms-Events";

    @Override
    public void publish(SmsEventDto req) {
        try {
            kafkaTemplate.send("Sms-Events",req);
            System.out.println("Message Publised "+req.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
