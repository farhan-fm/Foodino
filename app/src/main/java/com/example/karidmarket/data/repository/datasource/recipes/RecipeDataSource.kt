package com.example.karidmarket.data.repository.datasource.recipes

import android.database.Observable
import com.example.karidmarket.data.entity.recipeinformation.RecipedEntity
import io.reactivex.Single


interface RecipeDataSource {

    fun getRecipe(id:Int) : Single<RecipedEntity>

}