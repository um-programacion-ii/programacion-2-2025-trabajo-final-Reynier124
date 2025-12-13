package com.mycompany.myapp.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import static tech.jhipster.config.JHipsterDefaults.Security.Authentication.Jwt.base64Secret;

@Component
@Slf4j
public class JwtUtils {

    @Value("${jhipster.security.authentication.jwt.base64-secret}")
    private String base64Secret;

    @Value("${jhipster.security.authentication.jwt.token-validity-in-seconds}")
    private long jwtValiditySeconds;

    private Key key;

    @PostConstruct
    public void init() {
        if (base64Secret == null || base64Secret.trim().isEmpty()) {
            log.error("ERROR: La propiedad 'jhipster.security.authentication.jwt.base64-secret' no está configurada");
            throw new IllegalStateException(
                "La propiedad 'jhipster.security.authentication.jwt.base64-secret' debe estar configurada en application.yml"
            );
        }

        try {
            log.info("Inicializando JwtUtils con secreto Base64");
            key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(base64Secret));
            log.info("JwtUtils inicializado correctamente");
        } catch (IllegalArgumentException e) {
            log.error("ERROR: El secreto Base64 no es válido: {}", e.getMessage());
            throw new IllegalStateException("El secreto Base64 proporcionado no es válido", e);
        }
    }

    public String generateServiceToken() {
        Instant now = Instant.now();

        return Jwts.builder()
            .setSubject("backend-service")
            .claim("role", "ROLE_SERVICE")
            .setIssuedAt(Date.from(now))
            .setExpiration(Date.from(now.plusSeconds(jwtValiditySeconds)))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token);
    }
}
