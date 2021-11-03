package com.example.karidmarket.data.repository.datasource.login

import javax.inject.Inject

class LoginDataSourceFactory @Inject constructor(private val remoteLoginDataSource: RemoteLoginDataSource) {

    fun create(): LoginDataSource = remoteLoginDataSource

}