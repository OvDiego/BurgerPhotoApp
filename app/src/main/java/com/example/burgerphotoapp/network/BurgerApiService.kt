package com.example.burgerphotoapp.network


import com.example.burgerphotoapp.model.BurgerResult
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.spoonacular.com/recipes/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("aplication/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface BurgerApiService{
    @GET("complexSearch?apiKey=d3b86ff00a6545158882335cfee84321&query=burger&maxFat=25&number=10")
    suspend fun getPhotos():List<BurgerResult>
    //suspend fun getPhotos():List<BurgerPhoto>
}

object BurgerApi{
    val retrofitService: BurgerApiService by lazy{
        retrofit.create(BurgerApiService::class.java)
    }
}