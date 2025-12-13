package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CatedraService;
import com.mycompany.myapp.service.dto.BloqueoAsientosRequest;
import com.mycompany.myapp.service.dto.BloqueoAsientosResponse;
import com.mycompany.myapp.service.dto.EventoDTO;
import com.mycompany.myapp.service.dto.EventoResumidoDTO;
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
}
