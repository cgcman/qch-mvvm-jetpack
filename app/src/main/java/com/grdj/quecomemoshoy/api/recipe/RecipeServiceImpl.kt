package com.grdj.quecomemoshoy.api.recipe

import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.grdj.quecomemoshoy.utils.resources.ResourcesProvider
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeServiceImpl(private val resourceProvider: ResourcesProvider) : RecipeService {
    private val base_url = "https://api.edamam.com/"
    private val api = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RecipeAPI::class.java)

    override suspend fun search(from: String, to : String, q: String) : Response<RecipesResponse> = api.search(resourceProvider.getApiId(), resourceProvider.getApiKey(), from, to, q)
}