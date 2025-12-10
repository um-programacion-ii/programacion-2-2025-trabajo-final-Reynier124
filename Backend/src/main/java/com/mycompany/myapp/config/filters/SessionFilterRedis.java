package com.mycompany.myapp.config.filters;

import com.mycompany.myapp.service.impl.RedisSesionService;
import com.mycompany.myapp.service.impl.SesionServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Service

public class SessionFilterRedis extends OncePerRequestFilter {
    @Autowired
    private SesionServiceImpl sesionService;

    @Autowired
    private RedisSesionService redisSesionService;

    public SessionFilterRedis(RedisSesionService redisSesionService) {
        this.redisSesionService = redisSesionService;
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().equals("/api/authenticate");
    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain) throws IOException, ServletException {

        String token = request.getHeader("X-Session-Token");

        if (token == null || sesionService.renovarActividad(token) == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Sesion expirada o inválida\"}");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
