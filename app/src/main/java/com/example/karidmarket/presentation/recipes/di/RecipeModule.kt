package com.example.karidmarket.presentation.recipes.di

import com.example.karidmarket.data.mapper.RecipeEntityDataMapper
import com.example.karidmarket.data.repository.datasource.recipes.RecipeDataSourceFactory
import com.example.karidmarket.data.repository.impl.RecipeRepositoryImpl
import com.example.karidmarket.domain.repository.RecipeRepository
import com.example.karidmarket.domain.usecase.GetRecipeInformation
import com.example.karidmarket.presentation.recipes.model.RecipeModelDataMapper
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelViewFactory
import dagger.Module
import dagger.Provides

@Module
class RecipeModule {

    @Provides
    internal fun provideRecipeViewModelFactory(
        useCase: GetRecipeInformation,
        mapper: RecipeModelDataMapper
    ) = RecipeModelViewFactory(
        useCase, mapper
    )

    @Provides
    internal fun provideRecipeRepository(
        sourceFactory: RecipeDataSourceFactory,
        cryptoMapper: RecipeEntityDataMapper
    ): RecipeRepository = RecipeRepositoryImpl(
        sourceFactory, cryptoMapper
    )
}