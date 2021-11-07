package com.example.karidmarket.presentation.ingredientcompute.model

data class IngredientAmountResponseModel(
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val name: String,
    val nutritionModel: NutritionModel,
    val original: String,
    val originalName: String
)