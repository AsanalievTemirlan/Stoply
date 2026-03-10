package com.example.stoply

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.stoply.presentation.navigation.AppNavHost

@Composable
fun App() {
    MaterialTheme {
        AppNavHost()
    }
}