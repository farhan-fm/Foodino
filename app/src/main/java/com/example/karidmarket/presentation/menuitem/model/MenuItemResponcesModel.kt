package com.example.karidmarket.presentation.menuitem.model

import com.google.gson.annotations.SerializedName

data class MenuItemResponcesModel(
    val id: Int?,
    val images: ArrayList<String>?,
    val price: Double?,
    val restaurantChain: String?,
    val title: String?
)