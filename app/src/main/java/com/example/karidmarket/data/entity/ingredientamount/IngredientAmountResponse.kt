package com.example.karidmarket.data.entity.ingredientamount

data class IngredientAmountResponse(
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val name: String,
    val nutrition: Nutrition,
    val original: String,
    val originalName: String,
    val possibleUnits: List<String>
)