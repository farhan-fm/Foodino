package com.example.karidmarket.data.api

class EndPoints {
    companion object{
        const val GetRecipe : String = "recipes/{id}/information"
        const val GetGenerateMealPlane = "mealplanner/generate"
        const val GetMenuItem = "food/menuItems/{id}"
    }
}