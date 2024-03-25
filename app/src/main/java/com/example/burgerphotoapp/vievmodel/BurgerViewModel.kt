package com.example.burgerphotoapp.vievmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burgerphotoapp.network.BurgerApi
import kotlinx.coroutines.launch

class BurgerViewModel : ViewModel() {
    var burgerUiState by mutableStateOf("")
        private set

    init {
        getBurgerPhotos()
    }

    private fun getBurgerPhotos() {
        viewModelScope.launch {
            val listResult = BurgerApi.retrofitService.getPhotos()
            burgerUiState = listResult
        }
    }
}
