package com.example.karidmarket.presentation.menuitem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karidmarket.domain.usecase.GetMenuItemUseCase
import com.example.karidmarket.presentation.menuitem.model.MenuItemResponseModelMapper
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import javax.inject.Inject

class MenuItemViewModelFactory @Inject constructor(
    private val usecase: GetMenuItemUseCase,
    private val mapper: MenuItemResponseModelMapper
) :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MenuItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MenuItemViewModel(
                usecase,
                mapper
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}