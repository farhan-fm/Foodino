package com.example.karidmarket.presentation.ingredientcompute.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karidmarket.domain.usecase.GetIngredientAmountUseCase
import com.example.karidmarket.presentation.ingredientcompute.model.IngredientAmountModelDataMapper
import com.example.karidmarket.presentation.ingredientcompute.model.IngredientAmountResponseModel
import com.example.karidmarket.presentation.recipes.model.RecipedModel
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import io.reactivex.disposables.CompositeDisposable

class IngredientAmountViewModel constructor(
    private val useCase: GetIngredientAmountUseCase,
    private val mapper: IngredientAmountModelDataMapper
) : ViewModel() {

    val ingredientAmountLiveData = MutableLiveData<Result>()
    private val disposables = CompositeDisposable()
    private lateinit var result: Result

    fun getIngredientAmount() {

    }


    data class Result(
        val response: IngredientAmountResponseModel?,
        var state: State,
        var error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        MORE_DATA_LOADED,
        LOAD_ERROR,
        LOAD_MORE_ERROR
    }

}