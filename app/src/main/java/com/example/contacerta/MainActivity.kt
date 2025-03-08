package com.example.contacerta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.contacerta.ui.navigation.AppNavHost
import com.example.contacerta.ui.theme.ContaCertaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContaCertaTheme {
                val navController = rememberNavController()

                AppNavHost(navController = navController)
            }
        }
    }
}