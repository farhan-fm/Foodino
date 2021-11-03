package com.example.karidmarket.data.repository.datasource.recipes

import com.example.karidmarket.data.api.EndPoints
import com.example.karidmarket.data.api.WebServiceFactory
import com.example.karidmarket.data.entity.recipeinformation.RecipedEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

class CloudRecipeDataSource @Inject constructor(webServiceFactory: WebServiceFactory) :
    RecipeDataSource {

    private val webServiceFactory = webServiceFactory.createService(RecipeWebService::class.java)

    override fun getRecipe(id: Int): Single<RecipedEntity> =
        webServiceFactory.getRecipe(id,"ba8afeeaaab14555b7b26e45f948716d")


    interface RecipeWebService{
        @GET(EndPoints.GetRecipe)
        fun getRecipe(
            @Path("id") id:Int,
            @Query("apiKey") api:String
        ): Single<RecipedEntity>

//        @Query("id") page: Int
    }

}