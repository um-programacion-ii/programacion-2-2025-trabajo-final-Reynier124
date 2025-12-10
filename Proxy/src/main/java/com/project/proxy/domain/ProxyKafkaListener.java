package com.project.proxy.domain;

import com.project.proxy.dto.EventoKafkaDTO;
import com.project.proxy.enumeration.Changes;
import com.project.proxy.service.BackendNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class ProxyKafkaListener {
    @Autowired
    private BackendNotificationService backendNotificationService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.eventos}", groupId = "${kafka.consumer.group-id}")
    public void consumirEventoActualizado(String mensaje) {
        try {
            log.info("Mensaje recibido de Kafka: {}", mensaje);

            // Parsear el mensaje JSON
            EventoKafkaDTO cambio = objectMapper.readValue(mensaje, EventoKafkaDTO.class);

            // Procesar según el tipo de cambio
            procesarCambioEvento(cambio);

            // Notificar al backend
            backendNotificationService.notificarCambioEvento(cambio);

        } catch (Exception e) {
            log.error("Error procesando mensaje de Kafka: {}", e.getMessage(), e);
        }
    }

    private void procesarCambioEvento(EventoKafkaDTO cambio) {
        switch (cambio.getTipoCambio()) {
            case Changes.NUEVO_EVENTO:
                log.info("Nuevo evento creado: {}", cambio.getEventoId());
                break;
            case Changes.EVENTO_MODIFICADO:
                log.info("Evento modificado: {}", cambio.getEventoId());
                break;
            case Changes.EVENTO_CANCELADO:
                log.info("Evento cancelado: {}", cambio.getEventoId());
                break;
            case Changes.EVENTO_EXPIRADO:
                log.info("Evento expirado: {}", cambio.getEventoId());
                break;
            default:
                log.warn("Tipo de cambio desconocido: {}", cambio.getTipoCambio());
        }
    }
}
