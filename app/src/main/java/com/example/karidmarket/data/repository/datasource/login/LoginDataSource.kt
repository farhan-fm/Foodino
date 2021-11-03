package com.example.karidmarket.data.repository.datasource.login

import com.example.karidmarket.data.entity.UserEntity
import io.reactivex.Single

interface LoginDataSource {

    fun checkAndGetUser(userName: String, password: String): Single<UserEntity>

}