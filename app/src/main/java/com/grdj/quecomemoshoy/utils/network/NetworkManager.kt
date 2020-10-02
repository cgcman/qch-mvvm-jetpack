package com.grdj.quecomemoshoy.utils.network

interface NetworkManager {
    fun isConnected(): Boolean
    fun notConnectedMessage(message: String)
}