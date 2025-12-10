package com.project.proxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisService {
    /*
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final ObjectMapper objectMapper;

    public RedisService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }
    */
}
