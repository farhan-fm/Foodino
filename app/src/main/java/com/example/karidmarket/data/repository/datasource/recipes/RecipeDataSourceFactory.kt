package com.example.karidmarket.data.repository.datasource.recipes

import javax.inject.Inject

class RecipeDataSourceFactory  @Inject constructor(private val cloudRecipeDataStore: CloudRecipeDataSource) {
    fun create(): RecipeDataSource = cloudRecipeDataStore
}