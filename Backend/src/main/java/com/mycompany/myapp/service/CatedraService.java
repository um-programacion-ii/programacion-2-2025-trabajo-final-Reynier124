package com.mycompany.myapp.service;

import com.mycompany.myapp.service.client.ProxyClient;
import com.mycompany.myapp.service.dto.BloqueoAsientosRequest;
import com.mycompany.myapp.service.dto.BloqueoAsientosResponse;
import com.mycompany.myapp.service.dto.EventoDTO;
import com.mycompany.myapp.service.dto.EventoResumidoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatedraService {

    private final ProxyClient proxyClient;

    public CatedraService(ProxyClient proxyClient) {
        this.proxyClient = proxyClient;
    }

    public String registrar(String body) {
        return proxyClient.registrar(body);
    }

    public EventoDTO getEventoPorId(String id) {
        return proxyClient.getEventobyId(id);
    }

    public List<EventoDTO> getEventos() {
        return proxyClient.getEventos();
    }

    public List<EventoResumidoDTO> getEventosResumidos() {
        return proxyClient.getEventosResumidos();
    }

    public BloqueoAsientosResponse bloqueoAsiento(BloqueoAsientosRequest request){
        return proxyClient.bloqueoAsiento(request);
    }
}
