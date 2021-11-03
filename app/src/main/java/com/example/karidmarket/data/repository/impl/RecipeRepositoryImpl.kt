package com.example.karidmarket.data.repository.impl

import com.example.karidmarket.data.mapper.RecipeEntityDataMapper
import com.example.karidmarket.data.repository.datasource.recipes.RecipeDataSourceFactory
import com.example.karidmarket.domain.model.recipeinformation.Reciped
import com.example.karidmarket.domain.repository.RecipeRepository
import io.reactivex.Single

class RecipeRepositoryImpl constructor(
    private val recipeDataSourceFactory: RecipeDataSourceFactory,
    private val recipeEntityDataMapper: RecipeEntityDataMapper
) : RecipeRepository {
    override fun getRecipe(id: Int): Single<Reciped> =
        recipeDataSourceFactory.create().getRecipe(id).map(recipeEntityDataMapper::transformRecipe)

}



