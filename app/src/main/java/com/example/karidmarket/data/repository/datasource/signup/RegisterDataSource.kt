package com.example.karidmarket.data.repository.datasource.signup

import com.example.karidmarket.data.entity.UserEntity
import io.reactivex.Single

interface RegisterDataSource {
    fun getRegisterUser(userEntity: UserEntity): Single<Long>

}