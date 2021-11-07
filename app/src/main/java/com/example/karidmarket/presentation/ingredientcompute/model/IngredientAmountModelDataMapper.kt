package com.example.karidmarket.presentation.ingredientcompute.model

import com.example.karidmarket.data.entity.ingredientamount.IngredientAmountEntityResponse
import com.example.karidmarket.data.entity.ingredientamount.NutrientEntity
import com.example.karidmarket.data.entity.ingredientamount.NutritionEntity
import com.example.karidmarket.domain.model.ingredientamount.IngredientAmountResponse
import com.example.karidmarket.domain.model.ingredientamount.Nutrient
import com.example.karidmarket.domain.model.ingredientamount.Nutrition

class IngredientAmountModelDataMapper {

    fun transform(ingredientAR: IngredientAmountResponse): IngredientAmountResponseModel =

        ingredientAR.let {
            IngredientAmountResponseModel(
                it.amount,
                it.consistency,
                it.id,
                it.image,
                it.name,
                transformNutritionToNutritionModel(it.nutrition),
                it.original,
                it.originalName
            )
        }

    private fun transformNutritionToNutritionModel(nutrition: Nutrition): NutritionModel =
        transformNutrientToNutrientModel(nutrition.nutrients)


    private fun transformNutrientToNutrientModel(nutrient: ArrayList<Nutrient>): NutritionModel {
        val list = ArrayList<NutrientModel>()

        nutrient.forEach {
            transformNutrientItemToNutrientModelItem(it).let { it1 -> list.add(it1) }
        }

        return NutritionModel(list)

    }

    private fun transformNutrientItemToNutrientModelItem(it: Nutrient): NutrientModel =
        NutrientModel(it.amount, it.name, it.title, it.unit)


}