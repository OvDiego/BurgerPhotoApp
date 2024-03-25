package com.example.burgerphotoapp.vievmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burgerphotoapp.network.BurgerApi
import kotlinx.coroutines.launch
import java.io.IOException

class BurgerViewModel : ViewModel() {
    var burgerUiState by mutableStateOf("")
        private set

    init {
        getBurgerPhotos()
    }

    fun getBurgerPhotos() {
        viewModelScope.launch {
            try {
                val listResult = BurgerApi.retrofitService.getPhotos()
                burgerUiState = listResult.toString()
            // Convertir la lista a String
            } catch (e: IOException) {
                // Manejar la excepción si es necesario
                // Por ejemplo, puedes establecer burgerUiState en un valor de error
                burgerUiState = "Error: ${e.message}"
            }
        }
    }
}
