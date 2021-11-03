package com.example.karidmarket.data.mapper

import com.example.karidmarket.data.entity.mealplan.MealEntity
import com.example.karidmarket.data.entity.mealplan.MealPlanResponseEntity
import com.example.karidmarket.data.entity.mealplan.NutrientsEntity
import com.example.karidmarket.domain.model.mealplane.Meal
import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import com.example.karidmarket.domain.model.mealplane.Nutrients
import java.util.ArrayList
import javax.inject.Inject

class MealPlanEntityMapper @Inject constructor() {

    fun transform(mealPlanResponseEntity: MealPlanResponseEntity): MealPlanResponse =
        mealPlanResponseEntity.let {
            MealPlanResponse(
                transformMealEntityToMeal(it.meals),
                transformNutrientsEntityToNutrients(it.nutrients)
            )
        }

    private fun transformNutrientsEntityToNutrients(nutrientsEntity: NutrientsEntity): Nutrients =
        nutrientsEntity.let {
            Nutrients(it.calories, it.carbohydrates, it.fat, it.protein)
        }


    private fun transformMealEntityToMeal(mealEntities: ArrayList<MealEntity>): ArrayList<Meal> {
        val list = ArrayList<Meal>()

        mealEntities.forEach {
            transformMealEntityItemToMealItem(it).let { it1 -> list.add(it1) }
        }

        return list
    }

    private fun transformMealEntityItemToMealItem(it: MealEntity): Meal =
        Meal(it.id, it.imageType, it.readyInMinutes, it.servings, it.sourceUrl, it.title)


}