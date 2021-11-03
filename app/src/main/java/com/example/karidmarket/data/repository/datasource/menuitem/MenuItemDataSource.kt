package com.example.karidmarket.data.repository.datasource.menuitem

import com.example.karidmarket.data.entity.menuitem.MenuItemResponcesEntity
import com.example.karidmarket.data.entity.recipeinformation.RecipedEntity
import io.reactivex.Single

interface MenuItemDataSource {

    fun getMenuItem(id:Int) : Single<MenuItemResponcesEntity>

}