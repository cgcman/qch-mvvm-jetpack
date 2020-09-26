package com.grdj.quecomemoshoy.repository

import io.reactivex.Observable
import com.grdj.quecomemoshoy.api.recipe.RecipeService
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import retrofit2.Response

class RepositoryImpl(private val service: RecipeService) : Repository  {

    override fun getRecipesResponse(app_id : String,
                                            app_key: String,
                                            from : String,
                                            to : String,
                                            query : String): Observable<Response<RecipesResponse>> {
        return service.search(app_id, app_key, from, to, query)
    }
}