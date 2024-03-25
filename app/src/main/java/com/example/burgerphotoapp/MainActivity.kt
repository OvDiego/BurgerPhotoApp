package com.example.burgerphotoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.burgerphotoapp.ui.theme.BurgerApp
import com.example.burgerphotoapp.ui.theme.theme.BurgerPhotoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BurgerPhotoAppTheme {
                // App de hamburguesas inicial sin Model con un solo link de salida
                BurgerApp()
            }
        }
    }
}