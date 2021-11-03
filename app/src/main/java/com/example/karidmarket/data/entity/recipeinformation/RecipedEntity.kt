package com.example.karidmarket.data.entity.recipeinformation

data class RecipedEntity(
    val cheap: Boolean?,
    val extendedIngredientEntities: ArrayList<ExtendedIngredientEntity>? ,
    val glutenFree: Boolean? ,
    val healthScore: Double? ,
    val id: Int? ,
    val image: String? ,
    val instructions: String? ,
    val pricePerServing: Double?,
    val servings: Int? ,
    val title: String? ,
    val vegetarian: Boolean? ,
    val veryHealthy: Boolean? ,
    val veryPopular: Boolean? ,
)