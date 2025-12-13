package com.mycompany.myapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaAsientosRequest {
    private Long eventoId;
    private LocalDateTime fecha;
    private Double precioVenta;
    private List<AsientosVentasDTO> asientos;
}
