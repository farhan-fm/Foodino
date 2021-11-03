package com.example.karidmarket.data.repository.datasource.mealplan

import androidx.room.Index
import javax.inject.Inject

class MealPlanDataSourceFactory @Inject constructor(private val cloudMealPlanDataSource: CloudMealPlanDataSource) {

    fun create() : MealPlanDataSource = cloudMealPlanDataSource

}