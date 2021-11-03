package com.example.karidmarket.data.mapper

import com.example.karidmarket.data.entity.recipeinformation.ExtendedIngredientEntity
import com.example.karidmarket.data.entity.recipeinformation.RecipedEntity
import com.example.karidmarket.domain.model.recipeinformation.ExtendedIngredient
import com.example.karidmarket.domain.model.recipeinformation.OtherDetail
import com.example.karidmarket.domain.model.recipeinformation.Reciped
import javax.inject.Inject

class RecipeEntityDataMapper @Inject constructor() {

    fun transformRecipe(recipeEntity: RecipedEntity?): Reciped? =
        recipeEntity?.let {
            Reciped(
                transformRecipeEntityToRecipe(recipeEntity.extendedIngredientEntities),
                transformOtherRecipeInfoToRecipe(
                    recipeEntity.cheap,
                    recipeEntity.glutenFree,
                    recipeEntity.id,
                    recipeEntity.image,
                    recipeEntity.instructions,
                    recipeEntity.pricePerServing,
                    recipeEntity.servings,
                    recipeEntity.title,
                    recipeEntity.vegetarian,
                    recipeEntity.veryHealthy,
                    recipeEntity.veryPopular,
                    recipeEntity.healthScore
                )

            )
        }

    private fun transformOtherRecipeInfoToRecipe(
        cheap: Boolean?,
        glutenFree: Boolean?,
        id: Int?,
        image: String?,
        instructions: String?,
        pricePerServing: Double?,
        servings: Int?,
        title: String?,
        vegetarian: Boolean?,
        veryHealthy: Boolean?,
        veryPopular: Boolean?,
        healtyScore: Double?
    ): OtherDetail? =
        cheap.let {
            glutenFree.let {
                id.let {
                    image.let {
                        instructions.let {
                            pricePerServing.let {
                                servings.let {
                                    title.let {
                                        vegetarian.let {
                                            veryHealthy.let {
                                                veryPopular.let {
                                                    OtherDetail(
                                                        cheap = cheap,
                                                        glutenFree = glutenFree,
                                                        id = id,
                                                        image = image,
                                                        instructions = instructions,
                                                        pricePerServing = pricePerServing,
                                                        servings = servings,
                                                        title = title,
                                                        vegetarian = vegetarian,
                                                        veryHealthy = veryHealthy,
                                                        veryPopular = veryPopular,
                                                        healthScore = healtyScore
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    private fun transformRecipeEntityToRecipe(extendedIngredientEntities: ArrayList<ExtendedIngredientEntity>?): ArrayList<ExtendedIngredient>? {
        val list = ArrayList<ExtendedIngredient>()

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

    private fun transformExtendedIngredientEntityToExtendedIngredient(extendedIngredientEntity: ExtendedIngredientEntity): ExtendedIngredient =
        extendedIngredientEntity.let {
            ExtendedIngredient(it.amount, it.id, it.image, it.name, it.originalName)
        }


}