package com.example.karidmarket.domain.repository

import android.database.Observable
import com.example.karidmarket.domain.model.recipeinformation.Reciped
import io.reactivex.Single

interface RecipeRepository {

    fun getRecipe(id : Int) : Single<Reciped>

}