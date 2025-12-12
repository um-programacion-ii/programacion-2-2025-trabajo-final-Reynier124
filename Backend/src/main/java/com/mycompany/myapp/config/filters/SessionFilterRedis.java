package com.mycompany.myapp.config.filters;

import com.mycompany.myapp.service.impl.RedisSesionService;
import com.mycompany.myapp.service.impl.SesionServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SessionFilterRedis extends OncePerRequestFilter {

    private final SesionServiceImpl sesionService;

    private final RedisSesionService redisSesionService;

    public SessionFilterRedis(SesionServiceImpl sesionService, RedisSesionService redisSesionService) {
        this.sesionService = sesionService;
        this.redisSesionService = redisSesionService;
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().equals("/api/authenticate");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("X-SESSION-TOKEN");

        if (token != null) {
            sesionService.renovarActividad(token);
        }

        filterChain.doFilter(request, response);
    }
}
