package com.grdj.quecomemoshoy.model.fullrecipe

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Params (
	@SerializedName("sane") val sane : List<String>,
	@SerializedName("q") val q : List<String>,
	@SerializedName("app_key") val app_app_key : List<String>,
	@SerializedName("app_id") val app_id : List<String>
) : Parcelable