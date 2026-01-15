package com.messaging_service.sms_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequestDto {
    private String phoneNumber;
    private String message;
}
