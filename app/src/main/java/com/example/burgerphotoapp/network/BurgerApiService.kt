package com.example.burgerphotoapp.network


import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.spoonacular.com/recipes/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface BurgerApiService{
    @GET("complexSearch?apiKey=d3b86ff00a6545158882335cfee84321&query=burger&maxFat=25&number=1")
    suspend fun getPhotos():String
}

object BurgerApi{
    val retrofitService: BurgerApiService by lazy{
        retrofit.create(BurgerApiService::class.java)
    }
}