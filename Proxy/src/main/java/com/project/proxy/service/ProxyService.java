package com.project.proxy.service;

import com.project.proxy.client.CatedraClient;
import com.project.proxy.dto.RegistarUsuarioRequest;
import com.project.proxy.dto.RegistarUsuarioResponse;
import org.springframework.stereotype.Service;

@Service
public class ProxyService {

    private final CatedraClient catedraClient;

    public ProxyService(CatedraClient catedraClient) {
        this.catedraClient = catedraClient;
    }

    public RegistarUsuarioResponse registarUsuario(RegistarUsuarioRequest request) {
        return catedraClient.registarUsuario(request);
    }
}
