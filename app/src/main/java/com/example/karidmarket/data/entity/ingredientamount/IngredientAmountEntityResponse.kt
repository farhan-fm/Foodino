package com.example.karidmarket.data.entity.ingredientamount

import com.google.gson.annotations.SerializedName

data class IngredientAmountEntityResponse(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("consistency")
    val consistency: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nutrition")
    val nutritionEntity: NutritionEntity,
    @SerializedName("original")
    val original: String,
    @SerializedName("originalName")
    val originalName: String
)