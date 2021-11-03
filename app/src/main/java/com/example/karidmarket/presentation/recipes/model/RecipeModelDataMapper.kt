package com.example.karidmarket.presentation.recipes.model

import com.example.karidmarket.data.entity.recipeinformation.ExtendedIngredientEntity
import com.example.karidmarket.data.entity.recipeinformation.RecipedEntity
import com.example.karidmarket.domain.model.recipeinformation.ExtendedIngredient
import com.example.karidmarket.domain.model.recipeinformation.OtherDetail
import com.example.karidmarket.domain.model.recipeinformation.Reciped
import javax.inject.Inject

class RecipeModelDataMapper @Inject constructor() {

    fun transformRecipe(recipe: Reciped?): RecipedModel? =
        recipe?.let {
            RecipedModel(
                transformRecipeEntityToRecipe(recipe.extendedIngredientEntities),
                transformOtherRecipeInfoToRecipe(recipe.otherDetail)
            )
        }

    private fun transformOtherRecipeInfoToRecipe(otherDetail: OtherDetail?): OtherDetailModel? =
        otherDetail.let {
            OtherDetailModel(
                it?.cheap,
                it?.glutenFree,
                it?.healthScore,
                it?.id,
                it?.image,
                it?.instructions,
                it?.pricePerServing,
                it?.servings,
                it?.title,
                it?.vegetarian,
                it?.veryHealthy,
                it?.veryPopular
            )
        }


    private fun transformRecipeEntityToRecipe(extendedIngredientEntities: ArrayList<ExtendedIngredient>?): ArrayList<ExtendedIngredientModel>? {
        val list = ArrayList<ExtendedIngredientModel>()

        extendedIngredientEntities?.let { it ->
            it.forEach { item ->
                transformExtendedIngredientEntityToExtendedIngredient(item)?.let { it1 ->
                    list.add(
                        it1
                    )
                }
            }
        }
        return list
    }


    private fun transformExtendedIngredientEntityToExtendedIngredient(extendedIngredient: ExtendedIngredient): ExtendedIngredientModel =
        extendedIngredient.let {
            ExtendedIngredientModel(it.amount, it.id, it.image, it.name, it.originalName)
        }


}