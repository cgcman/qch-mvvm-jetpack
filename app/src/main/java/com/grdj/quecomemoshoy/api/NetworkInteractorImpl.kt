package com.grdj.quecomemoshoy.api

import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.utils.DefaultDispatcherProvider
import com.grdj.quecomemoshoy.utils.DispatcherProvider
import com.squareup.moshi.Moshi
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class NetworkInteractorImpl(private val dispatcher: DispatcherProvider = DefaultDispatcherProvider()) : NetworkInteractor {

    override suspend fun <T> apiCall(apiCall: suspend () -> T): ResultWrapper<T> {
        return withContext(dispatcher.io()) {
            try {
                ResultWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ResultWrapper.NetworkError
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = convertErrorBody(throwable)
                        ResultWrapper.GenericError(code, errorResponse)
                    }
                    else -> {
                        ResultWrapper.GenericError(null, null)
                    }
                }
            }
        }
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
}