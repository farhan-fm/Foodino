package com.example.karidmarket.data.repository.datasource.editprofile

import com.example.karidmarket.data.db.Database
import com.example.karidmarket.data.entity.UserEntity
import io.reactivex.Single
import javax.inject.Inject

class RemoteEditProfileDataSource @Inject constructor(private val room: Database) :
    EditProfileDataSource {
    override fun editProfile(userEntity: UserEntity): Single<Int> =
        room.getDatabaseDAO()?.updateUser(userEntity)!!
}