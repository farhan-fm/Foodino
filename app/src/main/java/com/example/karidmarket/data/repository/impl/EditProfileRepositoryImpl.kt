package com.example.karidmarket.data.repository.impl

import com.example.karidmarket.data.mapper.RegisterEntityMapper
import com.example.karidmarket.data.repository.datasource.editprofile.EditProfileDataSourceFactory
import com.example.karidmarket.data.repository.datasource.signup.RegisterDataSourceFactory
import com.example.karidmarket.domain.model.User
import com.example.karidmarket.domain.repository.EditProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class EditProfileRepositoryImpl @Inject constructor(
    private val factory: EditProfileDataSourceFactory,
    private val mapper: RegisterEntityMapper
) : EditProfileRepository {
    override fun editUser(user: User): Single<Int> =
        factory.execute().editProfile(mapper.transformUserToUserEntity(user))
}