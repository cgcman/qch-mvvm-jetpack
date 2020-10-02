package com.grdj.quecomemoshoy.utils.resources

import android.content.Context
import com.grdj.quecomemoshoy.R

class ResourcesProviderImpl (val context: Context) : ResourcesProvider {
    override fun getApiId() = context.resources.getString(R.string.EDAMAM_APP_ID)
    override fun getApiKey() = context.resources.getString(R.string.EDAMAM_API_KEY)
    override fun getNotConnectedMessage() = context.resources.getString(R.string.NOT_CONNECTED_MESSAGE)
    override fun getApiError() = context.resources.getString(R.string.API_ERROR)
}