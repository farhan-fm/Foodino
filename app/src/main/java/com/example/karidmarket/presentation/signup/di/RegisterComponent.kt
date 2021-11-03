package com.example.karidmarket.presentation.signup.di

import com.example.karidmarket.presentation.app.AppComponent
import com.example.karidmarket.presentation.app.RoomDbModule
import com.example.karidmarket.presentation.login.di.LoginBuildModule
import com.example.karidmarket.presentation.signup.view.RegisterFragment
import dagger.Component


@Component(
    dependencies = [AppComponent::class],
    modules = [RegisterBuildModule::class, RoomDbModule::class]
)
interface RegisterComponent {
    fun inject(registerFragment: RegisterFragment)
}