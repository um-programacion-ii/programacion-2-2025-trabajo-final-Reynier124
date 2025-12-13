package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CatedraService;
import com.mycompany.myapp.service.dto.*;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
@PermitAll
public class CatedraController {
    private final CatedraService catedraService;

    public CatedraController(CatedraService catedraService) {
        this.catedraService = catedraService;
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody String body) {
        return catedraService.registrar(body);
    }

    @GetMapping("/eventos/{id}")
    public EventoDTO getEvento(@PathVariable Long id) {
        return catedraService.getEventoPorId(id.toString());
    }

    @GetMapping("/eventos")
    public List<EventoDTO> getEventos() {
        return catedraService.getEventos();
    }

    @GetMapping("/eventos-resumidos")
    public List<EventoResumidoDTO> getEventosResumidos() {
        return catedraService.getEventosResumidos();
    }

    @PostMapping("/bloqueo-asientos")
    public BloqueoAsientosResponse bloqueoAsientos(@RequestBody BloqueoAsientosRequest body) {
        return catedraService.bloqueoAsiento(body);
    }

    @PostMapping("/realizar-venta")
    public VentaAsientosResponse realizarVenta(@RequestBody VentaAsientosRequest body) {
        return catedraService.realizarVenta(body);
    }

    @GetMapping("/listar-ventas")
    public List<VentaAsientosResponse> listarVentas() {
        return catedraService.listarVentas();
    }

    @GetMapping("/listar-ventas/{id}")
    public VentaAsientosResponse listarVentaPorId(@PathVariable Long id) {
        return catedraService.listarVentaPorId(id);
    }
}
