package com.example.karidmarket.domain.model.mealplane

import com.google.gson.annotations.SerializedName

data class Meal(
    val id: Int?,
    val imageType: String?,
    val readyInMinutes: Int?,
    val servings: Int?,
    val sourceUrl: String?,
    val title: String?
)