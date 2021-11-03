package com.example.karidmarket.data.entity.menuitem

import com.google.gson.annotations.SerializedName

data class MenuItemResponcesEntity(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("images")
    val images: ArrayList<String>,
    @SerializedName("price")
    val price: Double,
    @SerializedName("restaurantChain")
    val restaurantChain: String,
    @SerializedName("title")
    val title: String?
)