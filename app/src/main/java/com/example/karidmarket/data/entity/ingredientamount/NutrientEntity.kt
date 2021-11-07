package com.example.karidmarket.data.entity.ingredientamount

import com.google.gson.annotations.SerializedName

data class NutrientEntity(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("unit")
    val unit: String
)