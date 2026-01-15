package com.messaging_service.sms_gateway.services.impl;

import com.messaging_service.sms_gateway.dto.SmsEventDto;
import com.messaging_service.sms_gateway.dto.SmsRequestDto;
import com.messaging_service.sms_gateway.exception.UserBlockedException;
import com.messaging_service.sms_gateway.producer.KafkaProducer;
import com.messaging_service.sms_gateway.services.SmsService;
import com.messaging_service.sms_gateway.services.UserIdResolver;
import com.messaging_service.sms_gateway.services.UserStatus;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final ModelMapper modelMapper;
    private final UserIdResolver userIdResolver;
    private final UserStatus userStatus;
    private final KafkaProducer kafkaProducer;

    @Override
    public SmsEventDto send(SmsRequestDto req) {
        String userId= userIdResolver.resolve(req.getPhoneNumber());
        Boolean blocked=userStatus.check(userId);

        if(blocked){
            throw new UserBlockedException("User is blocked");
        }

        SmsEventDto smsEventDto=modelMapper.map(req,SmsEventDto.class);
        smsEventDto.setUserid(userId);
        smsEventDto.setStatus("Accepted");

        System.out.println(smsEventDto.toString());

        kafkaProducer.publish(smsEventDto);

        System.out.println("Sent DTO to Publisher!!!" + smsEventDto);
        return smsEventDto;
    }

    @Override
    public void block(SmsRequestDto req) {
        String userId= userIdResolver.resolve(req.getPhoneNumber());
        userStatus.blockUser(userId);
        System.out.println("User Blocked:"+userId);
    }
}
