package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.dto.SesionRedisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisSesionService {

    private static final long TTL_SECONDS = 1800L;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String key(String token) {
        return "sesion:" + token;
    }

    public void guardarEnCache(SesionRedisDTO dto) {
        redisTemplate.opsForValue().set(key(dto.getToken()), dto, TTL_SECONDS, TimeUnit.SECONDS);
    }

    public SesionRedisDTO obtenerDeCache(String token) {
        SesionRedisDTO dto = (SesionRedisDTO) redisTemplate.opsForValue().get(key(token));
        if (dto != null) {
            redisTemplate.expire(key(token), TTL_SECONDS, TimeUnit.SECONDS); // renovar
        }
        return dto;
    }

    public void borrar(String token) {
        redisTemplate.delete(key(token));
    }

    public boolean existe(String token) {
        return redisTemplate.hasKey(key(token));
    }
}
