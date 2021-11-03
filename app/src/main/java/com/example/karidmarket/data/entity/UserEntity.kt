package com.example.karidmarket.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_tb")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val fullName: String?,
    val userName: String?,
    val password: String?

    )