package com.example.karidmarket.presentation.generatemeal.model

import com.example.karidmarket.domain.model.mealplane.Meal
import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import com.example.karidmarket.domain.model.mealplane.Nutrients
import java.util.ArrayList
import javax.inject.Inject

class MealPlanModelDataMapper @Inject constructor() {

    fun transform(mealPlanResponse: MealPlanResponse): MealPlanResponseModel =
        mealPlanResponse.let {
            MealPlanResponseModel(
                transformMealToMealModel(it.meals),
                transformNutrientsToNutrientsModel(it.nutrients)
            )
        }

    private fun transformNutrientsToNutrientsModel(nutrients: Nutrients): NutrientsModel =
        nutrients.let {
            NutrientsModel(it.calories, it.carbohydrates, it.fat, it.protein)
        }


    private fun transformMealToMealModel(meal: ArrayList<Meal>): ArrayList<MealModel> {
        val list = ArrayList<MealModel>()

        meal.forEach {
            transformMealItemToMealModelItem(it).let { it1 -> list.add(it1) }
        }

        return list
    }

    private fun transformMealItemToMealModelItem(it: Meal): MealModel =
        MealModel(it.id, it.imageType, it.readyInMinutes, it.servings, it.sourceUrl, it.title)


}