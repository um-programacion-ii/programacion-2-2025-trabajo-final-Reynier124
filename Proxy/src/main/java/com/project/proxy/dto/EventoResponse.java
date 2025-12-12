package com.project.proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoResponse {
    private String titulo;
    private String resumen;
    private String descripcion;
    private LocalDateTime fecha;
    private String direccion;
    private String imagen;
    private Integer filaAsientos;
    private Integer columnAsientos;
    private Double precioEntrada;
    private EventoTipo eventoTipo;
    private List<Integrantes> integrantes;
    private Long id;
}
