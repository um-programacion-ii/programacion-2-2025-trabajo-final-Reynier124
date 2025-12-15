package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Evento;
import com.mycompany.myapp.repository.EventoRepository;
import com.mycompany.myapp.service.client.ProxyClient;
import com.mycompany.myapp.service.dto.EventoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class EventoSyncService {
    @Autowired
    private ProxyClient proxyClient;
    @Autowired
    private EventoRepository eventoRepository;

    /**
     * Sincroniza todos los eventos desde la cátedra
     * Se ejecuta de forma asíncrona para no bloquear la respuesta
     */
    @Async
    @Transactional
    public void sincronizarEventos() {
        log.info("Iniciando sincronización de eventos...");

        try {
            // Obtener todos los eventos desde la cátedra
            List<EventoDTO> eventosActualizados = proxyClient.getEventos();

            log.info("Se obtuvieron {} eventos de la cátedra", eventosActualizados.size());

            // Actualizar o crear eventos en la BD local
            for (EventoDTO eventoDTO : eventosActualizados) {
                sincronizarEvento(eventoDTO);
            }

            // Marcar como eliminados los eventos que ya no existen en la cátedra
            marcarEventosEliminados(eventosActualizados);

            log.info("Sincronización de eventos completada exitosamente");

        } catch (Exception e) {
            log.error("Error sincronizando eventos: {}", e.getMessage(), e);
        }
    }

    /**
     * Sincroniza un evento individual
     */
    private void sincronizarEvento(EventoDTO eventoDTO) {
        try {
            Evento evento = eventoRepository.findById(eventoDTO.getId())
                .orElse(new Evento());

            // Mapear datos del DTO a la entidad
            evento.setId(eventoDTO.getId()); //Fijarse de agregar el setCatedraId si es necesario
            evento.setTitulo(eventoDTO.getTitulo());
            evento.setDescripcion(eventoDTO.getDescripcion());
            evento.setFecha(eventoDTO.getFecha().toLocalDate());
            evento.setFilaAsientos(eventoDTO.getFilaAsientos());
            evento.setColumnaAsientos(eventoDTO.getColumnAsientos());
            evento.setPrecioEntrada(eventoDTO.getPrecioEntrada());
            evento.setEstado("Activo");

            eventoRepository.save(evento);
            log.debug("Evento {} sincronizado", evento.getTitulo());

        } catch (Exception e) {
            log.error("Error sincronizando evento {}: {}", eventoDTO.getId(), e.getMessage());
        }
    }

    /**
     * Marca como eliminados los eventos que ya no existen en la cátedra
     */
    private void marcarEventosEliminados(List<EventoDTO> eventosActualizados) {
        try {
            List<Long> idsActualizados = eventosActualizados.stream()
                .map(EventoDTO::getId)
                .toList();

            List<Evento> eventosLocales = eventoRepository.findByEstado("Activo");

            for (Evento evento : eventosLocales) {
                if (!idsActualizados.contains(evento.getId())) {
                    evento.setEstado("Inactivo");
                    eventoRepository.save(evento);
                    log.info("Evento {} marcado como inactivo", evento.getTitulo());
                }
            }

        } catch (Exception e) {
            log.error("Error marcando eventos eliminados: {}", e.getMessage());
        }
    }
}
