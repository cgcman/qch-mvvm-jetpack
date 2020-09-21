package com.grdj.quecomemoshoy.api.recipe

import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import io.reactivex.Observable
import retrofit2.Response

interface RecipeService {
    fun search(app_id: String, app_key: String, from: String, to : String, q: String) : Observable<Response<RecipesResponse>>
}