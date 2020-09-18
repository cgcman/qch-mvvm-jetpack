package com.grdj.quecomemoshoy.repository

import com.grdj.quecomemoshoy.api.apiCall
import com.grdj.quecomemoshoy.api.recipe.RecipeService
import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class RepositoryImpl(private val service: RecipeService,
                     private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : Repository  {

    override suspend fun getRecipesResponse(app_id : String,
                                            app_key: String,
                                            from : String,
                                            to : String,
                                            query : String): ResultWrapper<Response<RecipesResponse>> {
        return apiCall(dispatcher) { service.search(app_id, app_key, from, to, query)}
    }
}