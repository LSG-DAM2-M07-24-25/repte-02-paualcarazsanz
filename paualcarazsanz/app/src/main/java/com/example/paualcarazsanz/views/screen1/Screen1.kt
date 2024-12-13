package com.example.hangman_paualcaraz_ariadnapascual.views.screen1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman_paualcaraz_ariadnapascual.R
import com.example.hangman_paualcaraz_ariadnapascual.views.Routes

@Composable
fun Screen1(navController: NavController) {
    val selectedImage = remember { mutableStateOf<String?>(null) }
    val userName = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo en la parte superior
            Image(
                painter = painterResource(id = R.drawable.dragonball_daima_logo),
                contentDescription = "Dragon Ball Daima Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 32.dp),
                contentScale = ContentScale.Fit
            )

            // Fila con las imágenes
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ImageButton(
                        imageRes = R.drawable.goku,
                        contentDescription = "Goku Image",
                        selectedImage = selectedImage,
                        imageName = "goku"
                    )
                    ImageButton(
                        imageRes = R.drawable.gomah,
                        contentDescription = "Gomah Image",
                        selectedImage = selectedImage,
                        imageName = "gomah"
                    )
                    ImageButton(
                        imageRes = R.drawable.masked_majin,
                        contentDescription = "Masked Majin Image",
                        selectedImage = selectedImage,
                        imageName = "masked_majin"
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ImageButton(
                        imageRes = R.drawable.piccolo,
                        contentDescription = "Piccolo Image",
                        selectedImage = selectedImage,
                        imageName = "piccolo"
                    )
                    ImageButton(
                        imageRes = R.drawable.supreme,
                        contentDescription = "Supreme Image",
                        selectedImage = selectedImage,
                        imageName = "supreme"
                    )
                    ImageButton(
                        imageRes = R.drawable.vegeta,
                        contentDescription = "Vegeta Image",
                        selectedImage = selectedImage,
                        imageName = "vegeta"
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón continuar
            Button(
                onClick = {
                    if (selectedImage.value != null && userName.value.isNotEmpty()) {
                        navController.navigate(
                            Routes.GAME_SCREEN.replace("{selectedImage}", selectedImage.value!!)
                        )
                    }
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(4.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2196F3), contentColor = Color.White)
            ) {
                Text(text = "Continuar", fontSize = 18.sp, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun ImageButton(imageRes: Int, contentDescription: String, selectedImage: MutableState<String?>, imageName: String) {
    val isSelected = selectedImage.value == imageName

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(
                color = if (isSelected) Color.Gray else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(4.dp)
            .clickable {
                selectedImage.value = if (isSelected) null else imageName
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}

