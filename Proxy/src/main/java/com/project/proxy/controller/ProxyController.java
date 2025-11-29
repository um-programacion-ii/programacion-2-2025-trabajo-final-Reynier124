package com.project.proxy.controller;

import com.project.proxy.dto.RegistarUsuarioRequest;
import com.project.proxy.dto.RegistarUsuarioResponse;
import com.project.proxy.service.ProxyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class ProxyController {
    private final ProxyService proxyService;

    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @PostMapping("/registrar")
    public RegistarUsuarioResponse registrarUsuario(@RequestBody RegistarUsuarioRequest request) {
        System.out.println("→ ENTRÓ AL CONTROLLER Proxy");
        return proxyService.registarUsuario(request);
    }
}
