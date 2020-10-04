package com.grdj.quecomemoshoy.api

import com.grdj.quecomemoshoy.api.results.ResultWrapper

interface NetworkInteractor {
    suspend fun <T> apiCall(apiCall: suspend () -> T): ResultWrapper<T>
}