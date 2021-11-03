package com.example.karidmarket.data.repository.datasource.menuitem

import javax.inject.Inject

class MenuDataSourceFactory @Inject constructor(private val cloudMenuItemDataSource: CloudMenuItemDataSource) {

    fun create() : MenuItemDataSource = cloudMenuItemDataSource

}