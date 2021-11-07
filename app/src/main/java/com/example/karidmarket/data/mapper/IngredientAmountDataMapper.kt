package com.example.karidmarket.data.mapper

import com.example.karidmarket.data.entity.ingredientamount.IngredientAmountEntityResponse
import com.example.karidmarket.data.entity.ingredientamount.NutrientEntity
import com.example.karidmarket.data.entity.ingredientamount.NutritionEntity
import com.example.karidmarket.domain.model.ingredientamount.IngredientAmountResponse
import com.example.karidmarket.domain.model.ingredientamount.Nutrient
import com.example.karidmarket.domain.model.ingredientamount.Nutrition
import com.example.karidmarket.domain.model.mealplane.Meal

class IngredientAmountDataMapper {

    fun transform(ingredientAER: IngredientAmountEntityResponse): IngredientAmountResponse =

        ingredientAER.let {
            IngredientAmountResponse(
                it.amount,
                it.consistency,
                it.id,
                it.image,
                it.name,
                transformNutritionEntityToNutrition(it.nutritionEntity),
                it.original,
                it.originalName
            )
        }

    private fun transformNutritionEntityToNutrition(nutritionEntity: NutritionEntity): Nutrition =
        transformNutrientEntityToNutrient(nutritionEntity.nutrientEntities)


    private fun transformNutrientEntityToNutrient(nutrientEntities: ArrayList<NutrientEntity>): Nutrition {
        val list = ArrayList<Nutrient>()

        nutrientEntities.forEach {
            transformNutrientEntityItemToNutrientItem(it).let { it1 -> list.add(it1) }
        }

        return Nutrition(list)

    }

    private fun transformNutrientEntityItemToNutrientItem(it: NutrientEntity): Nutrient =
        Nutrient(it.amount, it.name, it.title, it.unit)


}