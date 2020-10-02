package com.grdj.quecomemoshoy.repository

import com.grdj.quecomemoshoy.api.NetworkInteractor
import com.grdj.quecomemoshoy.api.recipe.RecipeService
import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.grdj.quecomemoshoy.utils.network.NetworkManager
import com.grdj.quecomemoshoy.utils.resources.ResourcesProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class RepositoryImpl(
    private val networkManager: NetworkManager,
    private val networkInteractor: NetworkInteractor,
    private val service: RecipeService,
    private val resourceProvider: ResourcesProvider
) : Repository  {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getRecipesList(from : String, to : String, query : String): ResultWrapper<Response<RecipesResponse>> {
        if(networkManager.isConnected()){
            return networkInteractor.apiCall(dispatcher) {
                service.search(from, to, query)
            }
        } else {
            //// WIP -  ROOM PERSISTENS
            networkManager.notConnectedMessage(resourceProvider.getNotConnectedMessage())
            return ResultWrapper.NetworkError
        }
    }
}