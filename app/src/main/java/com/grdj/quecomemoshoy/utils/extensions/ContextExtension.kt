package com.grdj.quecomemoshoy.utils.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import androidx.annotation.RequiresPermission
import androidx.annotation.StringRes

@SuppressLint("MissingPermission")
@RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
fun Context.isConnected(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnected == true
}

fun Context.showToast(@StringRes resInt: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resInt, length).show()
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}