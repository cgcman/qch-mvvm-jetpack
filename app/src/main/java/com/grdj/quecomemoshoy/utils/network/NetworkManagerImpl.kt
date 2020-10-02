package com.grdj.quecomemoshoy.utils.network

import android.content.Context
import com.grdj.quecomemoshoy.utils.extensions.isConnected
import com.grdj.quecomemoshoy.utils.extensions.showToast

class NetworkManagerImpl(val context: Context): NetworkManager {
    override fun isConnected() = context.isConnected()
    override fun notConnectedMessage(message : String) = context.showToast(message , message.length)
}