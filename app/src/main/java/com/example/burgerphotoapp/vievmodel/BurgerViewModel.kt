package com.example.burgerphotoapp.vievmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burgerphotoapp.model.BurgerResult
import com.example.burgerphotoapp.network.BurgerApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BurgerUiState{
    data class Success(val photos: BurgerResult) : BurgerUiState
    object Error: BurgerUiState
    object Loading:BurgerUiState
}



class BurgerViewModel : ViewModel() {
    var burgerUiState: BurgerUiState by mutableStateOf(BurgerUiState.Loading)
        private set

    init {
        getBurgerPhotos()
    }


    private  fun getBurgerPhotos(){
        viewModelScope.launch {
            burgerUiState = try {
                //val listResult = BurgerApi.retrofitService.getPhotos()
                val listResult = BurgerApi.retrofitService.getPhotos()
                BurgerUiState.Success(listResult[0])
            } catch (e: IOException){
                BurgerUiState.Error
            }
        }
    }
}