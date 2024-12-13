package com.example.hangman_paualcaraz_ariadnapascual.views.ResultScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman_paualcaraz_ariadnapascual.R
import com.example.hangman_paualcaraz_ariadnapascual.views.Routes

@Composable
fun WinnerScreen(navController: NavController, userName: String, selectedImage: String) {
    val imageResource = when (selectedImage) {
        "goku" -> R.drawable.goku
        "gomah" -> R.drawable.gomah
        "masked_majin" -> R.drawable.masked_majin
        "piccolo" -> R.drawable.piccolo
        "supreme" -> R.drawable.supreme
        "vegeta" -> R.drawable.vegeta
        else -> R.drawable.goku // Default image if something goes wrong
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Congratulations, $userName!", fontSize = 36.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar la imagen seleccionada
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "User selected image",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para volver a jugar
        Button(onClick = { navController.navigate(Routes.GAME_SCREEN) }) {
            Text("Play again")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para volver al menú (redirige a Screen1)
        Button(onClick = { navController.navigate(Routes.SCREEN1) }) {
            Text("Menu")
        }
    }
}
