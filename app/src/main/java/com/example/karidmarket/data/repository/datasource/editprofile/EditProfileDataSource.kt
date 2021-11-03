package com.example.karidmarket.data.repository.datasource.editprofile

import com.example.karidmarket.data.entity.UserEntity
import io.reactivex.Single

interface EditProfileDataSource {

    fun editProfile(userEntity: UserEntity) : Single<Int>

}