package com.example.karidmarket.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advertising_tb")
data class AdvertisingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val image: String?
)