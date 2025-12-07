package com.project.proxy.service;

import com.project.proxy.dto.EventoKafkaDTO;
import com.project.proxy.dto.NotificationStats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class BackendNotificationService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // Canales de Redis para diferentes tipos de notificaciones
    private static final String CHANNEL_EVENTOS_CAMBIOS = "eventos:cambios";
    private static final String CHANNEL_ASIENTOS_CAMBIOS = "asientos:cambios";

    /**
     * Notifica al backend sobre cambios en eventos
     */
    public void notificarCambioEvento(EventoKafkaDTO cambio) {
        try {
            log.info("Publicando cambio de evento {} en Redis channel: {}",
                    cambio.getEventoId(), CHANNEL_EVENTOS_CAMBIOS);

            // Publicar el mensaje en el canal
            redisTemplate.convertAndSend(CHANNEL_EVENTOS_CAMBIOS, cambio);

            log.info("Notificación enviada exitosamente al backend");

            // Opcional: Guardar en Redis también para consulta posterior
            guardarUltimoCambio(cambio);

        } catch (Exception e) {
            log.error("Error publicando notificación en Redis: {}", e.getMessage(), e);
            // Implementar estrategia de fallback
            manejarErrorNotificacion(cambio, e);
        }
    }

    /**
     * Guarda el último cambio en Redis para que el backend pueda consultarlo
     * si perdió la notificación por Pub/Sub
     */
    private void guardarUltimoCambio(EventoKafkaDTO cambio) {
        try {
            String key = "evento:ultimo-cambio:" + cambio.getEventoId();
            redisTemplate.opsForValue().set(key, cambio);
            // Expira en 1 hora
            redisTemplate.expire(key, 3600, java.util.concurrent.TimeUnit.SECONDS);

            log.debug("Último cambio guardado en Redis con key: {}", key);
        } catch (Exception e) {
            log.warn("No se pudo guardar último cambio: {}", e.getMessage());
        }
    }

    /**
     * Maneja errores cuando no se puede notificar
     */
    private void manejarErrorNotificacion(EventoKafkaDTO cambio, Exception e) {
        // Opción 1: Guardar en una cola de reintentos
        try {
            String retryKey = "eventos:retry-queue";
            redisTemplate.opsForList().rightPush(retryKey, cambio);
            log.info("Cambio agregado a cola de reintentos");
        } catch (Exception ex) {
            log.error("Error crítico: no se pudo notificar ni guardar en cola de reintentos");
        }
    }

    /**
     * Obtiene estadísticas de notificaciones enviadas
     */
    public NotificationStats obtenerEstadisticas() {
        NotificationStats stats = new NotificationStats();

        try {
            // Contar elementos en cola de reintentos
            Long pendientes = redisTemplate.opsForList().size("eventos:retry-queue");
            stats.setNotificacionesPendientes(pendientes != null ? pendientes : 0);

        } catch (Exception e) {
            log.error("Error obteniendo estadísticas: {}", e.getMessage());
        }

        return stats;
    }

}
