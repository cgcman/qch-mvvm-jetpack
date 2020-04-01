package com.grdj.quecomemoshoy.services

import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import retrofit2.Response

interface RecipeService {
    suspend fun search(app_id: String, app_key: String, from: String, to : String, q: String) : Response<RecipesResponse>
}