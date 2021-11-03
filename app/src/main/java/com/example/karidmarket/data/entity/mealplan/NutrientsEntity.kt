package com.example.karidmarket.data.entity.mealplan

import com.google.gson.annotations.SerializedName

data class NutrientsEntity(
    @SerializedName("calories")
    val calories: Double?,
    @SerializedName("carbohydrates")
    val carbohydrates: Double?,
    @SerializedName("fat")
    val fat: Double?,
    @SerializedName("protein")
    val protein: Double?
)