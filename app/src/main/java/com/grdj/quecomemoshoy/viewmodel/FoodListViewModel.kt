package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.repository.Repository
import com.grdj.quecomemoshoy.utils.resources.ResourcesProvider
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import timber.log.Timber

class FoodListViewModel (
    application: Application,
    private val recipesList: Repository,
    private val resourcesProvider: ResourcesProvider) : BaseViewModel(application), KoinComponent {

    var recipes = MutableLiveData<RecipesResponse>()
    var error = MutableLiveData<Boolean>()

    fun getDataFromTo(from : String, to : String, query : String){
        fetchFromRemote(from, to, query)
    }

    private fun fetchFromRemote(from : String, to : String, query : String){
        launch {
            val response = recipesList.getRecipesList(from, to, query)
            when (response) {
                is ResultWrapper.NetworkError -> showNetworkError()
                is ResultWrapper.GenericError -> showGenericError(response)
                is ResultWrapper.Success -> populateUI(response.value.body())
            }
        }
    }

    private fun populateUI(response: RecipesResponse?){
        recipes.value = response
    }

    private fun showNetworkError(){
        error.value = true
        Toast.makeText(getApplication(), resourcesProvider.getApiError(), Toast.LENGTH_SHORT).show()
        Timber.d("RESPONSE, NETWORK ERROR")
    }

    private fun showGenericError(response: Any?) {
        error.value = true
        Toast.makeText(getApplication(), resourcesProvider.getApiError(), Toast.LENGTH_SHORT).show()
        Timber.d("ERROR RESPONSE, $response")
    }
}