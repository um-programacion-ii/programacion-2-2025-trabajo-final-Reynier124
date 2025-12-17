package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Asientos;
import com.mycompany.myapp.repository.AsientosRepository;
import com.mycompany.myapp.service.CatedraService;
import com.mycompany.myapp.service.dto.AsientosDisponiblesDTO;
import com.mycompany.myapp.service.dto.AsientosRedisDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DisponibilidadAsientosService {

    private final AsientosRepository asientosRepository;
    private final CatedraService catedraServices;

    public DisponibilidadAsientosService(
        AsientosRepository asientosRepository,
        CatedraService catedraServices) {

        this.asientosRepository = asientosRepository;
        this.catedraServices = catedraServices;
    }

    public List<AsientosDisponiblesDTO> obtenerAsientosDisponibles(Long eventoId) {

        // 1. Todos los asientos del evento (BD)
        List<Asientos> asientosBD =
            asientosRepository.findByEventoId(eventoId);

        // 2. Asientos NO disponibles (Redis externo)
        AsientosRedisDTO redisDTO =
            catedraServices.getAsientos(eventoId);

        Set<String> noDisponibles = redisDTO.getAsientos().stream()
            .filter(a ->
                "Bloqueado".equalsIgnoreCase(a.getEstado()) ||
                    "Vendido".equalsIgnoreCase(a.getEstado())
            )
            .map(a -> a.getFila() + "-" + a.getColumna())
            .collect(Collectors.toSet());

        // 3. Filtrar disponibles
        return asientosBD.stream()
            .filter(a ->
                !noDisponibles.contains(
                    a.getFila() + "-" + a.getColumna()
                )
            )
            .map(a ->
                new AsientosDisponiblesDTO(
                    a.getFila(),
                    a.getColumna()
                )
            )
            .toList();
    }
}
