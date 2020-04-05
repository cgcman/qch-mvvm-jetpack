package com.grdj.quecomemoshoy.model.fullrecipe

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VITA_RAE (
	@SerializedName("label") val label : String,
	@SerializedName("quantity") val quantity : Double,
	@SerializedName("unit") val unit : String
) : Parcelable