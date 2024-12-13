package com.example.hangman_paualcaraz_ariadnapascual.views.screen2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman_paualcaraz_ariadnapascual.views.Routes
import com.example.hangman_paualcaraz_ariadnapascual.R

@Composable
fun GameScreen(navController: NavController, userName: String, selectedImage: String) {

    val isGameOver = true

    // Si el juego termina, navega a la pantalla de ganador
    if (isGameOver) {
        navController.navigate(Routes.WINNER_SCREEN + "/$userName/$selectedImage")
    }

    // Contenido del juego aquí
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Game Screen", fontSize = 24.sp, color = Color.Black)
        Text("User: $userName", fontSize = 18.sp, color = Color.Gray)
        Text("Selected Character: $selectedImage", fontSize = 18.sp, color = Color.Gray)

        // Aquí iría la lógica de juego

    }
}

