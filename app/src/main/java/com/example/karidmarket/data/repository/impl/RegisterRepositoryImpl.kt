package com.example.karidmarket.data.repository.impl

import com.example.karidmarket.data.mapper.RegisterEntityMapper
import com.example.karidmarket.data.repository.datasource.signup.RegisterDataSourceFactory
import com.example.karidmarket.domain.model.User
import com.example.karidmarket.domain.repository.RegisterRepository
import io.reactivex.Single

class RegisterRepositoryImpl constructor(
    private val factory: RegisterDataSourceFactory,
    private val mapper: RegisterEntityMapper
) : RegisterRepository {

    override fun registerUser(user: User): Single<Long> =
        factory.create().getRegisterUser(mapper.transformUserToUserEntity(user))


}