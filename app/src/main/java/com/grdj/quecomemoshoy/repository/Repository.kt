package com.grdj.quecomemoshoy.repository

import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import io.reactivex.Observable
import retrofit2.Response

interface Repository {
    fun getRecipesResponse(app_id : String,
                           app_key: String,
                           from : String,
                           to : String,
                           query : String): Observable<Response<RecipesResponse>>
}