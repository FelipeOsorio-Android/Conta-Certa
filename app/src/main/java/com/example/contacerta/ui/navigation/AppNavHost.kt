package com.example.contacerta.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contacerta.ui.screens.CustomSplashScreen
import com.example.contacerta.ui.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {

    @Serializable
    data object CustomSplashScreen : Screens()

    @Serializable
    data object HomeScreen : Screens()

}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Screens.CustomSplashScreen) {
        composable<Screens.CustomSplashScreen> {
            CustomSplashScreen(
                Modifier.fillMaxSize(),
                onFinishedAnimation = {
                    navController.popBackStack()
                    navController.navigate(Screens.HomeScreen)
                }
            )
        }

        composable<Screens.HomeScreen> {
            HomeScreen()
        }
    }
}