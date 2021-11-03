package com.example.karidmarket.presentation.menuitem.di

import com.example.karidmarket.data.mapper.MenuItemEntityDataMapper
import com.example.karidmarket.data.repository.datasource.menuitem.MenuDataSourceFactory
import com.example.karidmarket.data.repository.impl.MenuItemRepositoryImpl
import com.example.karidmarket.domain.repository.MenuItemRepository
import com.example.karidmarket.domain.usecase.GetMenuItemUseCase
import com.example.karidmarket.presentation.menuitem.model.MenuItemResponseModelMapper
import com.example.karidmarket.presentation.menuitem.viewmodel.MenuItemViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MenuItemBuildModule {

    @Provides
    fun providesMenuItemViewModelFactory(
        useCase: GetMenuItemUseCase,
        mapper: MenuItemResponseModelMapper
    ) = MenuItemViewModelFactory(useCase, mapper)

    @Provides
    fun providesMenuItemRepository(
        factory: MenuDataSourceFactory,
        mapper: MenuItemEntityDataMapper
    ): MenuItemRepository = MenuItemRepositoryImpl(factory, mapper)


}