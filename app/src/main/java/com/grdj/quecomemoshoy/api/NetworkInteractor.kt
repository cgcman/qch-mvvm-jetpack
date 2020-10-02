package com.grdj.quecomemoshoy.api

import com.grdj.quecomemoshoy.api.results.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher

interface NetworkInteractor {
    suspend fun <T> apiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): ResultWrapper<T>
}