package com.messaging_service.sms_gateway.controllers;

import com.messaging_service.sms_gateway.dto.SmsRequestDto;
import com.messaging_service.sms_gateway.services.SmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService){
        this.smsService=smsService;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody SmsRequestDto req){
        smsService.send(req);
//        System.out.println(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/block")
    public void blockUser(@RequestBody SmsRequestDto req){
        smsService.block(req);
    }
}
