package com.example.karidmarket.domain.model.menuitem

import com.google.gson.annotations.SerializedName

data class MenuItemResponces(
    val id: Int?,
    val images: ArrayList<String>?,
    val price: Double?,
    val restaurantChain: String?,
    val title: String?
)