package com.messaging_service.sms_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsEventDto {
    private String userid;
    private String phoneNumber;
    private String message;
    private String status;
}
