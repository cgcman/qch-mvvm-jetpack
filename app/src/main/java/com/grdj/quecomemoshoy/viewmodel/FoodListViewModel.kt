package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.repository.Repository
import kotlinx.coroutines.launch
import timber.log.Timber

class FoodListViewModel @ViewModelInject constructor(
    application: Application,
    val recipesList: Repository): BaseViewModel(application) {

    var recipes = MutableLiveData<RecipesResponse>()
    var error = MutableLiveData<Boolean>()

    fun getDataFromTo(app_id : String, app_key: String, from : String, to : String, query : String){
        fetchFromRemote(app_id, app_key, from, to, query)
    }

    private fun fetchFromRemote(app_id : String, app_key: String, from : String, to : String, query : String){
        launch {
            val response = recipesList.getRecipesResponse(app_id, app_key, from, to, query)
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
        Toast.makeText(getApplication(), "Error obteniendo los datos", Toast.LENGTH_SHORT).show()
        Timber.d("RESPONSE, NETWORK ERROR")
    }

    private fun showGenericError(response: Any?) {
        error.value = true
        Toast.makeText(getApplication(), "Error obteniendo los datos", Toast.LENGTH_SHORT).show()
        Timber.d("ERROR RESPONSE, "+response)
    }
}