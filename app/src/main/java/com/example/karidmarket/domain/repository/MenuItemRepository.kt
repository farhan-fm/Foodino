package com.example.karidmarket.domain.repository

import com.example.karidmarket.data.entity.menuitem.MenuItemResponcesEntity
import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import com.example.karidmarket.domain.model.menuitem.MenuItemResponces
import io.reactivex.Single

interface MenuItemRepository {
    fun getMenuItem(id : Int) : Single<MenuItemResponces>
}