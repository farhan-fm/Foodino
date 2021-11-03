package com.example.karidmarket.presentation.generatemeal.model

import com.google.gson.annotations.SerializedName

data class MealModel(
    val id: Int?,
    val imageType: String?,
    val readyInMinutes: Int?,
    val servings: Int?,
    val sourceUrl: String?,
    val title: String?
)