package com.project.proxy.service;

import com.project.proxy.client.BackendClient;
import com.project.proxy.dto.EventoKafkaDTO;
import com.project.proxy.dto.NotificationStats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class BackendNotificationService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private BackendClient backendClient;

    /**
     * Notifica al backend sobre cambios en eventos
     */
    public void notificarCambioEvento(EventoKafkaDTO cambio) {
        log.info("Notificando cambio de evento {}", cambio.getEventoId());

        try {
            Map<String, Object> body = prepararBody(cambio);

            backendClient.notificarCambioEvento(body)
                    .doOnSuccess(res -> {
                        log.info("Notificación enviada exitosamente");
                        guardarUltimoCambio(cambio);
                    })
                    .doOnError(err -> {
                        log.error("Error notificando al backend: {}", err.getMessage());
                        manejarErrorNotificacion(cambio, err);
                    })
                    .subscribe();

        } catch (Exception e) {
            log.error("Error preparando notificación: {}", e.getMessage());
            manejarErrorNotificacion(cambio, e);
        }
    }

    private Map<String, Object> prepararBody(EventoKafkaDTO cambio) {
        Map<String, Object> body = new HashMap<>();
        body.put("tipo", cambio.getTipoCambio());
        body.put("eventoId", cambio.getEventoId());
        body.put("evento", cambio.getEventoId());
        body.put("timestamp", LocalDateTime.now());
        return body;
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
    private void manejarErrorNotificacion(EventoKafkaDTO cambio, Throwable e) {
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
