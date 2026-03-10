package com.example.stoply.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stoply.App
import com.example.stoply.presentation.screens.main.MainScreen
import com.example.stoply.presentation.screens.map.MapScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreenRoute
    ) {
        composable<MainScreenRoute> {
            MainScreen(navController)
        }
        composable<MapScreenRoute> {
            MapScreen(navController)
        }

    }
}