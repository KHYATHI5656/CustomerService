package com.alpha.CustomerService.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alpha.CustomerService.dto.TemporaryRideDto;

@Service
public class redisservice {

    private final RedisTemplate<String, Object> redisTemplate;

    public redisservice(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveTemporaryRide(int customerId, TemporaryRideDto ride) {

        String key = "temporaryRide:" + customerId;

        redisTemplate.opsForValue().set(key, ride);
    }

    public TemporaryRideDto getTemporaryRide(int customerId) {

        String key = "temporaryRide:" + customerId;

        return (TemporaryRideDto) redisTemplate.opsForValue().get(key);
    }

    public void deleteTemporaryRide(int customerId) {

        String key = "temporaryRide:" + customerId;

        redisTemplate.delete(key);
    }
    

}