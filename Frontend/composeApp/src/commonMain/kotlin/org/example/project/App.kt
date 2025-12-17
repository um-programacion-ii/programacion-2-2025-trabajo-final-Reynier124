package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import frontend.composeapp.generated.resources.Res
import frontend.composeapp.generated.resources.compose_multiplatform
import org.example.project.navigation.Screen
import org.example.project.navigation.Screen.*
import org.example.project.ui.EventDetailScreen
import org.example.project.ui.EventListScreen
import org.example.project.ui.LoginScreen

@Composable
@Preview
fun App() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }

    when (val screen = currentScreen) {

        Screen.Login -> {
            LoginScreen(
                onLoginSuccess = {
                    currentScreen = Screen.EventList
                }
            )
        }

        Screen.EventList -> {
            EventListScreen(
                onEventClick = { eventId ->
                    currentScreen = EventDetail(eventId)
                }
            )
        }
        /*
        is Screen.EventDetail -> {
            EventDetailScreen(
                eventId = screen.eventId,
                onBack = {
                    currentScreen = Screen.EventList
                }
            )
        }*/
        is Screen.EventDetail -> TODO()
    }
}