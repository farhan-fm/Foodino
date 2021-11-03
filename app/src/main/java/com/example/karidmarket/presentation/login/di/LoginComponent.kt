package com.example.karidmarket.presentation.login.di

import com.example.karidmarket.presentation.app.AppComponent
import com.example.karidmarket.presentation.app.RoomDbModule
import com.example.karidmarket.presentation.login.view.LoginFragment
import com.example.karidmarket.presentation.recipes.di.RecipeModule
import com.example.karidmarket.presentation.recipes.view.RecipesFragment
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [LoginBuildModule::class, RoomDbModule::class]
)
interface LoginComponent {
    fun inject(loginFragment: LoginFragment)
}