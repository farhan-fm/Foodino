package com.example.karidmarket.data.repository.datasource.mealplan

import com.example.karidmarket.data.entity.mealplan.MealPlanResponseEntity
import io.reactivex.Single

interface MealPlanDataSource {

    fun getMealPlan(timeFrame : String) : Single<MealPlanResponseEntity>

}