package com.project.proxy.client;

import com.project.proxy.dto.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component
public class CatedraClient {

    private final WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger(CatedraClient.class);
    private final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyZXluaWVyMTI0IiwiZXhwIjoxNzY3ODIwODExLCJhdXRoIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzY1MjI4ODExfQ.wdfO_1r3YDPZ1ot8jnGxMlw31UP0bfoj9re24g9C64y6_IW_1u0VKERp4YgZgXVEyh-3KuYbrvxOjWVvR3-52g";

    public CatedraClient(WebClient webClient) {
        this.webClient = webClient;
        // Log the WebClient's baseUrl when the client is constructed (if available)
        try {
            String base = webClient.mutate().build().toString();
            logger.info("CatedraClient constructed, WebClient.toString(): {}", base);
        } catch (Exception e) {
            logger.debug("No se pudo obtener representación del WebClient: {}", e.getMessage());
        }
    }

    public RegistrarUsuarioResponse registarUsuario(RegistrarUsuarioRequest request) {
        logger.info("Invocando endpoint POST /agregar_usuario usando WebClient");
        return webClient.post()
                .uri("/v1/agregar_usuario")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(RegistrarUsuarioResponse.class)
                .block();
    }

    public LoginResponse loguearUsuario(LoginRequest request) {
        logger.info("Invocando endpoint POST /authenticate usando WebClient");
        return webClient.post()
                .uri("/authenticate")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(LoginResponse.class)
                .block();
    }

    public List<EventoResumidoResponse> conseguirEventosResumidos() {
        logger.info("Invocando endpoint GET /eventos_resumidos usando WebClient");
        return webClient.get()
                .uri("/endpoints/v1/eventos-resumidos")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EventoResumidoResponse>>() {})
                .block();
    }

    public List<EventoResponse> conseguirEventos() {
        logger.info("Invocando endpoint GET /eventos usando WebClient");
        return webClient.get()
                .uri("/endpoints/v1/eventos")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EventoResponse>>() {})
                .block();
    }

    public EventoResponse conseguirEventosPorId(Long id) {
        logger.info("Invocando endpoint GET /eventos/{id} usando WebClient");
        return webClient.get()
                .uri("/endpoints/v1/evento/{id}", id)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(EventoResponse.class)
                .block();
    }




}
