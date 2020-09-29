package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.grdj.quecomemoshoy.api.convertErrorBody
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.grdj.quecomemoshoy.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class FoodListViewModel @ViewModelInject public constructor(
    application: Application,
    private val repository: Repository): BaseViewModel(application) {

    var recipes = MutableLiveData<RecipesResponse>()
    var error = MutableLiveData<Boolean>()
    val compositeDisposable = CompositeDisposable()

    fun fetchData(app_id : String, app_key: String, from : String, to : String, query : String){
        val recipeResponse = repository.getRecipesResponse(app_id, app_key, from, to, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {value -> recipes.value = value.body() },
                {error -> when (error) {
                    is IOException -> showNetworkError()
                    is HttpException -> {
                        val code = error.code()
                        val errorResponse = convertErrorBody(error)
                        showGenericError(code, errorResponse)
                    }
                    else -> {
                        showGenericError(400, null)
                    }
                }}
            )
        compositeDisposable.add(recipeResponse)
    }

    private fun showNetworkError(){
        error.value = true
        Toast.makeText(getApplication(), "Error obteniendo los datos", Toast.LENGTH_SHORT).show()
        Timber.d("RESPONSE, NETWORK ERROR")
    }

    private fun showGenericError(code: Int, response: Any?) {
        error.value = true
        Toast.makeText(getApplication(), "Error obteniendo los datos", Toast.LENGTH_SHORT).show()
        Timber.d("ERROR RESPONSE, " + code + "-" +response)
    }

    override fun onCleared(){
        compositeDisposable.dispose()
    }
}