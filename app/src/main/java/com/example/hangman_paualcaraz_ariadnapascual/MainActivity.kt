package com.example.hangman_paualcaraz_ariadnapascual

import LaunchScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.hangman_paualcaraz_ariadnapascual.views.ResultScreen.WinnerScreen
import com.example.hangman_paualcaraz_ariadnapascual.views.Routes
import com.example.hangman_paualcaraz_ariadnapascual.views.screen1.Screen1
import com.example.hangman_paualcaraz_ariadnapascual.views.screen2.GameScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()


        }
    }
}
