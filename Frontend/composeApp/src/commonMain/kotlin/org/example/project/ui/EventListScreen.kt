package org.example.project.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun EventListScreen(
    events: List<Event>,
    onEventClick: (Event) -> Unit
) {
    LazyColumn {
        items(events) { event ->
            EventItem(event = event, onClick = { onEventClick(event) })
        }
    }
}