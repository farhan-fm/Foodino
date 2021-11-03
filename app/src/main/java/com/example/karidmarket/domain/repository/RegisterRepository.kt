package com.example.karidmarket.domain.repository

import com.example.karidmarket.domain.model.User
import io.reactivex.Single

interface RegisterRepository {
    fun registerUser(user: User) : Single<Long>

}