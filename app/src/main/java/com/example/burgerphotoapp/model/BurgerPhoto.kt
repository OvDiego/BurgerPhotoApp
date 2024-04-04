package com.example.burgerphotoapp.model

import kotlinx.serialization.Serializable
@Serializable
data class BurgerPhoto(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)
@Serializable
data class ApiResponse(
    val results: List<BurgerPhoto>,
    val offset: Int,
    val number: Int,
    val totalResults: Int
)
/*@Serializable
data class BurgerPhoto(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)
@Serializable
data class Result(
    val id: Int,
    val image: String,
    val imageType: String,
    val nutrition: Nutrition,
    val title: String
)

@Serializable
data class Nutrition(
    val nutrients: List<Nutrient>
)
@Serializable
data class Nutrient(
    val amount: Double,
    val name: String,
    val unit: String
)
*/