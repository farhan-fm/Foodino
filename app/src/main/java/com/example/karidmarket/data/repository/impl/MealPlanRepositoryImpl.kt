package com.example.karidmarket.data.repository.impl

import com.example.karidmarket.data.mapper.MealPlanEntityMapper
import com.example.karidmarket.data.repository.datasource.mealplan.MealPlanDataSourceFactory
import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import com.example.karidmarket.domain.repository.MealPlanRepository
import io.reactivex.Single
import javax.inject.Inject

class MealPlanRepositoryImpl @Inject constructor(
    private val factory: MealPlanDataSourceFactory,
    private val mapper: MealPlanEntityMapper
) : MealPlanRepository {
    override fun getMealPlane(timeFrame: String): Single<MealPlanResponse> =
        factory.create().getMealPlan(timeFrame).map(mapper::transform)
}