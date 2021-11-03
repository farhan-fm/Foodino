package com.example.karidmarket.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class User(

    val id: Int?,
    val fullName: String?,
    val userName: String?,
    val password: String?

    )