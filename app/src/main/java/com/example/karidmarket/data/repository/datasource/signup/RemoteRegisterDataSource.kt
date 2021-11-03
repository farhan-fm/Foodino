package com.example.karidmarket.data.repository.datasource.signup

import com.example.karidmarket.data.db.Database
import com.example.karidmarket.data.entity.UserEntity
import io.reactivex.Single
import javax.inject.Inject

class RemoteRegisterDataSource @Inject constructor(private val room: Database) :
    RegisterDataSource {
    override fun getRegisterUser(userEntity: UserEntity): Single<Long> =
        room.getDatabaseDAO()?.addUser(userEntity)!!
}