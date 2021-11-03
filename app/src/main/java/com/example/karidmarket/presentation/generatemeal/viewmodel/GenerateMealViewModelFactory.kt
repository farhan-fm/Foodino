package com.example.karidmarket.presentation.generatemeal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karidmarket.domain.usecase.GetMealPlanUseCase
import com.example.karidmarket.presentation.generatemeal.model.MealPlanModelDataMapper
import javax.inject.Inject

class GenerateMealViewModelFactory @Inject constructor(
    private var mapper: MealPlanModelDataMapper,
    private var useCase: GetMealPlanUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GenerateMealViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GenerateMealViewModel(
                mapper,
                useCase
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}