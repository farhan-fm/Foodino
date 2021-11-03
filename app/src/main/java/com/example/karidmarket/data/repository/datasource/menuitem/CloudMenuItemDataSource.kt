package com.example.karidmarket.data.repository.datasource.menuitem

import com.example.karidmarket.data.api.EndPoints
import com.example.karidmarket.data.api.WebServiceFactory
import com.example.karidmarket.data.entity.menuitem.MenuItemResponcesEntity
import com.example.karidmarket.data.entity.recipeinformation.RecipedEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

class CloudMenuItemDataSource @Inject constructor(webServiceFactory: WebServiceFactory) :
    MenuItemDataSource {

    private var webServiceFactory = webServiceFactory.createService(MenuItemWebService::class.java)

    override fun getMenuItem(id: Int): Single<MenuItemResponcesEntity> =
        webServiceFactory.getMenuItem(id, "ba8afeeaaab14555b7b26e45f948716d")

    interface MenuItemWebService {
        @GET(EndPoints.GetMenuItem)
        fun getMenuItem(
            @Path("id") id: Int,
            @Query("apiKey") api: String
        ): Single<MenuItemResponcesEntity>

    }
}