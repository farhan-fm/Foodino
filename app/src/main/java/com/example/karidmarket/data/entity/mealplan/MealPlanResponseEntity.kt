package com.example.karidmarket.data.entity.mealplan

import com.google.gson.annotations.SerializedName

data class MealPlanResponseEntity(
    @SerializedName("meals")
    val meals: ArrayList<MealEntity>,
    @SerializedName("nutrients")
    val nutrients: NutrientsEntity
)