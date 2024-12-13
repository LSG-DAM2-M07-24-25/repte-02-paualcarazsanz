import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman_paualcaraz_ariadnapascual.R
import com.example.hangman_paualcaraz_ariadnapascual.views.Routes

@Composable
fun LaunchScreen(navController: NavController) {
    // Estado para verificar si se ha presionado el botón
    var isButtonPressed by remember { mutableStateOf(false) }

    // Lanzamos un efecto para navegar cuando se presione el botón
    LaunchedEffect(isButtonPressed) {
        if (isButtonPressed) {
            navController.navigate(Routes.SCREEN1)
        }
    }

    // Diseño de la pantalla de inicio
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Mostrar el logo
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo), // Referencia al logo en drawable
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp) // Tamaño del logo
        )

        Spacer(modifier = Modifier.height(16.dp)) // Separación entre el texto y el botón

        // Mostrar el botón de empezar
        Button(
            onClick = { isButtonPressed = true }, // Cambiamos el estado cuando se presiona
            modifier = Modifier
                .fillMaxWidth(0.6f) // El botón ocupa el 60% del ancho
                .height(48.dp) // Altura del botón
        ) {
            Text(text = "Empezar", fontSize = 16.sp, color = Color.White)
        }
    }
}
