package com.example.karidmarket.data.entity.ingredientamount

import com.google.gson.annotations.SerializedName

data class NutritionEntity(
    @SerializedName("nutrients")
    val nutrientEntities: ArrayList<NutrientEntity>
)