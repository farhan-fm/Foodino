package com.example.karidmarket.domain.model.mealplane

data class MealPlanResponse(
    val meals: ArrayList<Meal>,
    val nutrients: Nutrients
)