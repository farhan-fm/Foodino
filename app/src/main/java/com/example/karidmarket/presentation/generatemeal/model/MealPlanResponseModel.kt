package com.example.karidmarket.presentation.generatemeal.model

data class MealPlanResponseModel(
    val mealModels: ArrayList<MealModel>,
    val nutrientsModel: NutrientsModel
)