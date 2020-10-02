package com.grdj.quecomemoshoy.repository

import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import retrofit2.Response

interface Repository {
    suspend fun getRecipesList(from : String, to : String, query : String): ResultWrapper<Response<RecipesResponse>>
}