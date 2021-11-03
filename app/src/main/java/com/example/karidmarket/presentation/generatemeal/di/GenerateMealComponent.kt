package com.example.karidmarket.presentation.generatemeal.di

import com.example.karidmarket.presentation.app.AppComponent
import com.example.karidmarket.presentation.generatemeal.view.GenerateMealFragment
import com.example.karidmarket.presentation.recipes.view.RecipesFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [GenerateMealBuildModule::class])
interface GenerateMealComponent {
    fun inject(generateMealFragment: GenerateMealFragment)
}