package com.example.karidmarket.data.repository.datasource.mealplan

import com.example.karidmarket.data.api.EndPoints
import com.example.karidmarket.data.api.WebServiceFactory
import com.example.karidmarket.data.entity.mealplan.MealPlanResponseEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class CloudMealPlanDataSource @Inject constructor(webServiceFactory: WebServiceFactory) : MealPlanDataSource {

    private val webServiceFactory = webServiceFactory.createService(MealPlanWebService::class.java)

    override fun getMealPlan(timeFrame: String): Single<MealPlanResponseEntity> =
        webServiceFactory.getMealPlan(timeFrame,"ba8afeeaaab14555b7b26e45f948716d")

    interface MealPlanWebService {
        @GET(EndPoints.GetGenerateMealPlane)
        fun getMealPlan(
            @Query("timeFrame") timeFrame:String,
            @Query("apiKey") api:String
        ): Single<MealPlanResponseEntity>

    }



}