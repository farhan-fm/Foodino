package com.example.karidmarket.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advertising_tb")
data class Advertising(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val image: ByteArray?
)