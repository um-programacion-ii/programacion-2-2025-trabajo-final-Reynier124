package com.project.proxy.controller;

import com.project.proxy.dto.*;
import com.project.proxy.service.ProxyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proxy")
public class ProxyController {
    private final ProxyService proxyService;

    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @PostMapping("/registrar")
    public RegistrarUsuarioResponse registrarUsuario(@RequestBody RegistrarUsuarioRequest request) {
        System.out.println("→ ENTRÓ AL CONTROLLER Proxy");
        return proxyService.registarUsuario(request);
    }

    @PostMapping("/authenticate")
    public LoginResponse loguearUsuario(@RequestBody LoginRequest request) {
        return proxyService.loguearUsuario(request);
    }

    @GetMapping("/eventos-resumidos")
    public List<EventoResumidoResponse> conseguirEventosResumidos() {
        return proxyService.conseguirEventosResumidos();
    }

    @GetMapping("/eventos")
    public List<EventoResponse> conseguirEventos() {
        return proxyService.conseguirEventos();
    }

    @GetMapping("/eventos/{id}")
    public EventoResponse conseguirEventosPorId(@PathVariable Long id) {
        return proxyService.conseguirEventosPorId(id);
    }

    @PostMapping("/bloquear-asientos")
    public BloqueoAsientosResponse bloquearAsientos(@RequestBody BloqueoAsientosRequest request) {
        return proxyService.bloquearAsientos(request);
    }
}
