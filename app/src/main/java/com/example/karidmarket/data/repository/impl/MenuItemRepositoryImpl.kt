package com.example.karidmarket.data.repository.impl

import com.example.karidmarket.data.entity.menuitem.MenuItemResponcesEntity
import com.example.karidmarket.data.mapper.MenuItemEntityDataMapper
import com.example.karidmarket.data.repository.datasource.menuitem.MenuDataSourceFactory
import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import com.example.karidmarket.domain.model.menuitem.MenuItemResponces
import com.example.karidmarket.domain.repository.MenuItemRepository
import io.reactivex.Single
import javax.inject.Inject

class MenuItemRepositoryImpl @Inject constructor(
    private var factory: MenuDataSourceFactory,
    private var mapper: MenuItemEntityDataMapper
) : MenuItemRepository {

    override fun getMenuItem(id: Int): Single<MenuItemResponces> =
        factory.create().getMenuItem(id).map(mapper::transform)

}