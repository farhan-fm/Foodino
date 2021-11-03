package com.example.karidmarket.data.repository.datasource.login

import com.example.karidmarket.data.db.DataBaseDao
import com.example.karidmarket.data.db.Database
import com.example.karidmarket.data.entity.UserEntity
import io.reactivex.Single
import javax.inject.Inject

class RemoteLoginDataSource @Inject constructor(private val room: Database) : LoginDataSource {
    override fun checkAndGetUser(userName: String, password: String): Single<UserEntity> =
        room.getDatabaseDAO()?.loginUser(userName, password)!!

}