package com.project.proxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        System.out.println("DATA REDIS = " + key + " : " + value);
    }

    public String get(String key) {
        System.out.println("GET DATA REDIS KEY = " + key);
        return redisTemplate.opsForValue().get(key).toString();
    }
}
