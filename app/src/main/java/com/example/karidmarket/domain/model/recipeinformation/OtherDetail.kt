package com.example.karidmarket.domain.model.recipeinformation

data class OtherDetail(
    val cheap: Boolean? ,
    val glutenFree: Boolean? ,
    val healthScore: Double? ,
    val id: Int? ,
    val image: String? ,
    val instructions: String? ,
    val pricePerServing: Double? ,
    val servings: Int? ,
    val title: String? ,
    val vegetarian: Boolean?,
    val veryHealthy: Boolean? ,
    val veryPopular: Boolean?
)
