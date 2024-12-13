package com.example.hangman_paualcaraz_ariadnapascual

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hangman_paualcaraz_ariadnapascual.views.ResultScreen.WinnerScreen
import com.example.hangman_paualcaraz_ariadnapascual.views.screen2.GameScreen
import com.example.hangman_paualcaraz_ariadnapascual.views.Routes
import com.example.hangman_paualcaraz_ariadnapascual.views.screen1.Screen1

@Composable
fun MainActivity() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SCREEN1) {
        composable(Routes.SCREEN1) { Screen1(navController) }

        // Navegación con parámetros para GameScreen
        composable(
            Routes.GAME_SCREEN,
            arguments = listOf(
                navArgument("userName") { type = NavType.StringType },
                navArgument("selectedImage") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "Unknown"
            val selectedImage = backStackEntry.arguments?.getString("selectedImage") ?: "goku"
            GameScreen(navController, userName, selectedImage)
        }

        composable(
            Routes.WINNER_SCREEN,
            arguments = listOf(
                navArgument("userName") { type = NavType.StringType },
                navArgument("selectedImage") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "Unknown"
            val selectedImage = backStackEntry.arguments?.getString("selectedImage") ?: "goku"
            WinnerScreen(navController, userName, selectedImage)
        }
    }
}
