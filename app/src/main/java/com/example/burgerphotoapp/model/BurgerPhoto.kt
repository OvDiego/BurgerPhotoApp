package com.example.burgerphotoapp.model

import kotlinx.serialization.Serializable

@Serializable
data class BurgerPhoto(
    val results: List<BurgerResult>,
    val offset: Int,
    val number: Int,
    val totalResults: Int
)

@Serializable
data class BurgerResult(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
    val nutrition: BurgerNutrition
)

@Serializable
data class BurgerNutrition(
    val nutrients: List<BurgerNutrient>
)

@Serializable
data class BurgerNutrient(
    val name: String,
    val amount: Double,
    val unit: String
)
