package com.example.karidmarket.presentation.recipes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karidmarket.domain.usecase.GetRecipeInformation
import com.example.karidmarket.presentation.recipes.model.RecipeModelDataMapper
import javax.inject.Inject

class RecipeModelViewFactory @Inject constructor(
    private val useCase : GetRecipeInformation,
    private val mapper: RecipeModelDataMapper
) :ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeModelView::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipeModelView(
                useCase,
                mapper
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}