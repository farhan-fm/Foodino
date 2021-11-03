package com.example.karidmarket.data.repository.datasource.editprofile

import javax.inject.Inject

class EditProfileDataSourceFactory @Inject constructor(
    private val remoteEditProfileDataSource: RemoteEditProfileDataSource
) {
    fun execute(): EditProfileDataSource = remoteEditProfileDataSource

}