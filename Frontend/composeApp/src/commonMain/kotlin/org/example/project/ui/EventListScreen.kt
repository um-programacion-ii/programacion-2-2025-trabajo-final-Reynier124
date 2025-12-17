package org.example.project.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import org.example.project.dto.EventoResponse
import org.example.project.viewmodel.EventViewModel

@Composable
fun EventListScreen(
    onEventClick: (Long) -> Unit
) {
    val viewModel = remember { EventViewModel() }

    LaunchedEffect(Unit) {
        viewModel.loadEvents()
    }

    if (viewModel.loading) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(viewModel.events) { event ->
                EventItem(event) {
                    onEventClick(event.id)
                }
            }
        }
    }
}