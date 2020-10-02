package com.grdj.quecomemoshoy.utils.resources

interface ResourcesProvider {
    fun getApiId() : String
    fun getApiKey() : String
    fun getNotConnectedMessage() : String
    fun getApiError() : String
}