package com.example.karidmarket.presentation.menuitem.model

import com.example.karidmarket.data.entity.menuitem.MenuItemResponcesEntity
import com.example.karidmarket.domain.model.menuitem.MenuItemResponces
import javax.inject.Inject

class MenuItemResponseModelMapper @Inject constructor() {

    fun transform(menuItemResponse: MenuItemResponces) : MenuItemResponcesModel =
        menuItemResponse.let {
            MenuItemResponcesModel(it.id,it.images,it.price,it.restaurantChain,it.title)
        }

}