package com.mycompany.myapp.service.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class EventoTipoDTO implements Serializable {
    private String eventoTipoNombre;
    private String eventoTipoDescripcion;

}
