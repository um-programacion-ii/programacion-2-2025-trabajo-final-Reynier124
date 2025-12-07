package com.mycompany.myapp.service.client;

import com.mycompany.myapp.service.dto.EventoDTO;
import com.mycompany.myapp.service.dto.EventoResumidoDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProxyClient {
    private final WebClient proxyWebClient;

    public ProxyClient(WebClient proxyWebClient) {
        this.proxyWebClient = proxyWebClient;
    }

    public String registrar(String body) {
        return proxyWebClient.post()
            .uri("/proxy/registrar")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }

    public EventoDTO getEventobyId(String id) {
        return proxyWebClient.get()
            .uri("/proxy/eventos/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(EventoDTO.class)
            .block();
    }

    public List<EventoDTO> getEventos() {
        return proxyWebClient.get()
            .uri("/proxy/eventos")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(EventoDTO.class)
            .collectList()
            .block();
    }

    public List<EventoResumidoDTO> getEventosResumidos() {
        return proxyWebClient.get()
            .uri("/proxy/eventos-resumidos")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(EventoResumidoDTO.class)
            .collectList()
            .block();
    }


}
