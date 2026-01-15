package com.messaging_service.sms_gateway.services.impl;

import com.messaging_service.sms_gateway.services.UserIdResolver;
import com.messaging_service.sms_gateway.util.UuidGenerator;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserIdResolverImpl implements UserIdResolver {

    private UuidGenerator uuidGenerator;
    private StringRedisTemplate redisTemplate;

    @Override
    public String resolve(String phoneNumber) {
        String key="user:" + phoneNumber;
        String existingUserId=redisTemplate.opsForValue().get(key);
        if(existingUserId!=null){
            return existingUserId;
        }
        String newUserId= uuidGenerator.generate();
        redisTemplate.opsForValue().set(key, newUserId);
        return newUserId;
    }
}
