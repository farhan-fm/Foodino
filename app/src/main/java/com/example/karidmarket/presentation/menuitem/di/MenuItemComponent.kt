package com.example.karidmarket.presentation.menuitem.di

import com.example.karidmarket.presentation.app.AppComponent
import com.example.karidmarket.presentation.menuitem.view.MenuItemFragment
import dagger.Component


@Component(dependencies = [AppComponent::class], modules = [MenuItemBuildModule::class])
interface MenuItemComponent {
    fun inject(menuItemFragment: MenuItemFragment)
}