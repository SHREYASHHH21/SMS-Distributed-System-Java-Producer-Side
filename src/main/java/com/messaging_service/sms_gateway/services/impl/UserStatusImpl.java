package com.messaging_service.sms_gateway.services.impl;

import com.messaging_service.sms_gateway.services.UserStatus;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserStatusImpl implements UserStatus {

    private final StringRedisTemplate redisTemplate;

    public UserStatusImpl(StringRedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }

    @Override
    public Boolean check(String userId) {
        String key = "blocked user:" + userId;
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    @Override
    public void blockUser(String userId) {
        String key = "blocked user:" + userId;
        redisTemplate.opsForValue().set(key, "BLOCKED",60, TimeUnit.SECONDS);
    }
}
