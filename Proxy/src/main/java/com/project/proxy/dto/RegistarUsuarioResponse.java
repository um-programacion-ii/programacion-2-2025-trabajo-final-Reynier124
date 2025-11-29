package com.project.proxy.dto;

import lombok.Data;

@Data
public class RegistarUsuarioResponse {

    private boolean creado;
    private String resultado;
    private String token;
}
