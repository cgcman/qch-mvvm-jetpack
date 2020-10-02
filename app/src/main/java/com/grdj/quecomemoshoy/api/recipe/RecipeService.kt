package com.grdj.quecomemoshoy.api.recipe

import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import retrofit2.Response

interface RecipeService {
    suspend fun search(from: String, to : String, q: String) : Response<RecipesResponse>
}