package com.example.karidmarket.data.repository.datasource.signup

import javax.inject.Inject

class RegisterDataSourceFactory @Inject constructor(
    private val remoteRegisterDataSource: RemoteRegisterDataSource
) {

    fun create(): RegisterDataSource = remoteRegisterDataSource

}