package com.example.karidmarket.presentation.login.model

import com.example.karidmarket.data.entity.UserEntity
import com.example.karidmarket.domain.model.User
import javax.inject.Inject

class UserModelMapper @Inject constructor() {

    fun transformer(user: User?): UserModel? =
        transformUserEntityToUser(user)

    private fun transformUserEntityToUser(user: User?): UserModel =
        user.let {
            UserModel(
                it?.id,
                it?.fullName,
                it?.userName,
                it?.password
            )
        }

    private fun transformUserToUserEntity(userModel: UserModel): User =
        User(
            userModel.id,
            userModel.fullName,
            userModel.userName,
            userModel.password
        )

}