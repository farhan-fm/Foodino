package com.example.karidmarket.domain.model.ingredientamount

data class IngredientAmountResponse(
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val name: String,
    val nutrition: Nutrition,
    val original: String,
    val originalName: String
)