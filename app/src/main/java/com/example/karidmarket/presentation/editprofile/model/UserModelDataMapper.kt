package com.example.karidmarket.presentation.editprofile.model

import com.example.karidmarket.data.entity.UserEntity
import com.example.karidmarket.domain.model.User
import javax.inject.Inject

class UserModelDataMapper @Inject constructor() {

    fun transformer(user: User?): UserModel? =
        transformUserToUserModel(user)

    private fun transformUserToUserModel(user: User?): UserModel =
        user.let {
            UserModel(
                it?.id,
                it?.fullName,
                it?.userName,
                it?.password
            )
        }

    fun transformUserModelToUser(userModel: UserModel): User =
        User(
            userModel.id,
            userModel.fullName,
            userModel.userName,
            userModel.password
        )

}