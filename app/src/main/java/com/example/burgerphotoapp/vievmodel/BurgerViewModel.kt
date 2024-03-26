package com.example.burgerphotoapp.vievmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burgerphotoapp.network.BurgerApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BurgerUiState{
    data class Success(val photos:String) : BurgerUiState
    object Error: BurgerUiState
    object Loading:BurgerUiState
}



class BurgerViewModel : ViewModel() {
    var burgerUiState:BurgerUiState by mutableStateOf(BurgerUiState.Loading)
        private set

    init {
        getBurgerPhotos()
    }


    private  fun getBurgerPhotos(){
        viewModelScope.launch {
            burgerUiState = try {
                val listResult = BurgerApi.retrofitService.getPhotos()
                BurgerUiState.Success("Número de fotos de hamburgesas es ${listResult.size}")
            } catch (e: IOException){
                BurgerUiState.Error
            }
        }
    }
}
