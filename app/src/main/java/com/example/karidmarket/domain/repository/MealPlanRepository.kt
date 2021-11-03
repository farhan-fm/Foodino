package com.example.karidmarket.domain.repository

import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import io.reactivex.Single

interface MealPlanRepository {
    fun getMealPlane(timeFrame : String) : Single<MealPlanResponse>
}