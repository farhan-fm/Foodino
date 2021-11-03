package com.example.karidmarket.presentation.editprofile.di

import com.example.karidmarket.presentation.app.AppComponent
import com.example.karidmarket.presentation.app.RoomDbModule
import com.example.karidmarket.presentation.editprofile.view.EditProfileFragment
import com.example.karidmarket.presentation.login.di.LoginBuildModule
import dagger.Component


@Component(
    dependencies = [AppComponent::class],
    modules = [EditProfileBuildModule::class, RoomDbModule::class]
)
interface EditProfileComponent {
    fun inject(editProfileFragment: EditProfileFragment)
}