package org.example.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import org.example.project.viewmodel.LoginViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.viewmodel.LoginUiState

@Composable
fun LoginScreen(viewModel: LoginViewModel = LoginViewModel()) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val state by viewModel.uiState.collectAsState()

    Column(modifier = Modifier
        .padding(16.dp)
        .safeContentPadding()
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") }
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") }
        )

        Button(
            onClick = {
                viewModel.login(username, password)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Iniciar sesión")
        }

        Spacer(Modifier.height(16.dp))

        when (state) {
            is LoginUiState.Loading ->
                CircularProgressIndicator()

            is LoginUiState.Success ->
                Text("Login correcto ✅")

            is LoginUiState.Error ->
                Text(
                    "Error: ${(state as LoginUiState.Error).message}",
                    color = Color.Red
                )

            else -> {}
        }
    }
}