package com.example.karidmarket.data.mapper

import com.example.karidmarket.data.entity.menuitem.MenuItemResponcesEntity
import com.example.karidmarket.domain.model.menuitem.MenuItemResponces
import javax.inject.Inject

class MenuItemEntityDataMapper @Inject constructor() {

    fun transform(menuItemResponcesEntity: MenuItemResponcesEntity) : MenuItemResponces =
        menuItemResponcesEntity.let {
            MenuItemResponces(it.id!!,it.images!!,it.price!!,it.restaurantChain!!,it.title!!)
        }

}