package org.example.project.dto

data class EventoResponse {
    val id: Long,
    val titulo: String,
    val fecha: String,
    val descripcion: String,
    val precioEntrada: Double,
    val eventoTipo: EventoTipoDTO,
}