package com.example.karidmarket.data.mapper

import com.example.karidmarket.data.entity.UserEntity
import com.example.karidmarket.domain.model.User
import javax.inject.Inject

class RegisterEntityMapper @Inject constructor() {

    fun transformer(userEntity: UserEntity?): User? =
        transformUserEntityToUser(userEntity)

    private fun transformUserEntityToUser(userEntity: UserEntity?): User =
        userEntity.let {
            User(
                it?.id,
                it?.fullName,
                it?.userName,
                it?.password
            )
        }

     fun transformUserToUserEntity(user: User): UserEntity =
        UserEntity(
            user.id,
            user.fullName,
            user.userName,
            user.password
        )

}