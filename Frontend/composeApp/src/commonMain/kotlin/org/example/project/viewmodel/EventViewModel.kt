package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.dto.EventoResponse
import org.example.project.network.ApiClient

class EventViewModel {

    var events by mutableStateOf<List<EventoResponse>>(emptyList())
        private set

    var loading by mutableStateOf(true)
        private set

    suspend fun loadEvents() {
        events = ApiClient.getEvents()
        loading = false
    }
}