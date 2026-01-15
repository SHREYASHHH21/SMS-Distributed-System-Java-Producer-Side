package com.messaging_service.sms_gateway.config;

import com.messaging_service.sms_gateway.dto.SmsEventDto;
//import lombok.Value;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic SmsEvents(@Value("${kafka.topic.sms}") String topic){
        return new NewTopic(topic,3,(short)1);
    }
}
