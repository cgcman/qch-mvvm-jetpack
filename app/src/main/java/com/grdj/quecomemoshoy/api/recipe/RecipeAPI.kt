package com.grdj.quecomemoshoy.api.recipe

import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAPI {
    @GET("/search") fun search(
        @Query("app_id") app_id: String,
        @Query("app_key") app_key: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("q") q: String): Observable<Response<RecipesResponse>>
}