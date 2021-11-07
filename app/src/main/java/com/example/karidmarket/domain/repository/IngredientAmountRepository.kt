package com.example.karidmarket.domain.repository

import com.example.karidmarket.domain.model.ingredientamount.IngredientAmountResponse
import io.reactivex.Single

interface IngredientAmountRepository {

    fun getIngredientAmount(id: Int, amount: Int): Single<IngredientAmountResponse>

}