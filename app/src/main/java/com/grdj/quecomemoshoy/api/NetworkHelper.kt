package com.grdj.quecomemoshoy.api

import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

fun apiCall( service: Observable<Response<RecipesResponse>>): ResultWrapper<Response<RecipesResponse>> {
    var result : ResultWrapper<Response<RecipesResponse>> = ResultWrapper.GenericError(null, null)
    val disposable: Disposable =
        service.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                    {value -> result = ResultWrapper.Success(value)},
                    {error -> result = when (error) {
                        is IOException -> ResultWrapper.NetworkError
                        is HttpException -> {
                            val code = error.code()
                            val errorResponse = convertErrorBody(error)
                            ResultWrapper.GenericError(code, errorResponse)
                        }
                        else -> {
                            ResultWrapper.GenericError(null, null)
                        }
                    }}
                )
    disposable.dispose()
    return result
}

private fun convertErrorBody(throwable: HttpException): ResultWrapper.ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ResultWrapper.ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}