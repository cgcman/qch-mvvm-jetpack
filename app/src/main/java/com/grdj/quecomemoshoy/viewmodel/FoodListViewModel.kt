package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.grdj.quecomemoshoy.services.RecipeService
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class FoodListViewModel (application: Application): BaseViewModel(application), KoinComponent {

    val recipeService by inject<RecipeService>()
    var recipes = MutableLiveData<RecipesResponse>()
    val loading = MutableLiveData<Boolean>()

    fun getDataFromTo(app_id : String, app_key: String, from : String, to : String, query : String){
        fetchFromRemote(app_id, app_key, from, to, query)
    }

    private fun fetchFromRemote(app_id : String, app_key: String, from : String, to : String, query : String){
        loading.value = true
        Log.e("DATA",query)
        launch {
            try {
                val response = recipeService.search(app_id, app_key, from, to, query)
                if(response.isSuccessful){
                    recipes.value = response.body()
                    loading.value = false
                } else{
                    Log.e("EXC", "ERROR: "+response)
                    responseError()
                }
            } catch (e: Exception){
                Log.e("EXC", ""+e)
                responseError()
            }
        }
    }

    private fun responseError(){
        Toast.makeText(getApplication(), "Error obteniendo los datos", Toast.LENGTH_SHORT).show()
        loading.value = false
    }
}