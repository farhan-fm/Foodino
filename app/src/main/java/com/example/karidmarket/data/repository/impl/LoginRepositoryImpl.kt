package com.example.karidmarket.data.repository.impl

import com.example.karidmarket.data.mapper.LoginEntityMapper
import com.example.karidmarket.data.repository.datasource.login.LoginDataSourceFactory
import com.example.karidmarket.domain.model.User
import com.example.karidmarket.domain.repository.LoginRepository
import io.reactivex.Single

class LoginRepositoryImpl constructor(
    private val factory: LoginDataSourceFactory,
    private val mapper: LoginEntityMapper
) : LoginRepository {
    override fun getLogin(email: String, password: String): Single<User> =
        factory.create().checkAndGetUser(email, password).map(mapper::transformer)
}