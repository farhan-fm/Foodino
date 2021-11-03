package com.example.karidmarket.domain.model.mealplane

import com.google.gson.annotations.SerializedName

data class Nutrients(
    val calories: Double?,
    val carbohydrates: Double?,
    val fat: Double?,
    val protein: Double?
)