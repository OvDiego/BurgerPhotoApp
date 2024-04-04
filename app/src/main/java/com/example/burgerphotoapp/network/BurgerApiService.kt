package com.example.burgerphotoapp.network


import com.example.burgerphotoapp.model.BurgerPhoto
//import com.example.burgerphotoapp.model.Result
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.spoonacular.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("aplication/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface BurgerApiService{
    @GET("recipes/complexSearch?apiKey=d3b86ff00a6545158882335cfee84321&query=burger&number=1")
    suspend fun getPhotos():List<BurgerPhoto>
    //suspend fun getPhotos():List<BurgerPhoto>
}

object BurgerApi{
    val retrofitService: BurgerApiService by lazy{
        retrofit.create(BurgerApiService::class.java)
    }
}