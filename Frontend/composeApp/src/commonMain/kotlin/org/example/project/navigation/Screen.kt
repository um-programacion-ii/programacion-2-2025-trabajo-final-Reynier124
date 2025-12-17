package org.example.project.navigation

sealed class Screen{
    object Login : Screen()
    object EventList : Screen()
    data class EventDetail(val eventId: Long) : Screen()
}
