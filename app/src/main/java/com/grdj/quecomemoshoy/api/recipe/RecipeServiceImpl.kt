package com.grdj.quecomemoshoy.api.recipe

import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeServiceImpl: RecipeService {
    private val base_url = "https://api.edamam.com/"
    private val api = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RecipeAPI::class.java)

    override suspend fun search(app_id: String, app_key: String, from: String, to : String, q: String) : Response<RecipesResponse> = api.search(app_id, app_key, from, to, q)
}