package com.example.karidmarket.presentation.recipes.di

import com.example.karidmarket.presentation.app.AppComponent
import com.example.karidmarket.presentation.recipes.view.RecipesFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [RecipeModule::class])
interface RecipeComponent {
    fun inject(recipeFragment: RecipesFragment)
}