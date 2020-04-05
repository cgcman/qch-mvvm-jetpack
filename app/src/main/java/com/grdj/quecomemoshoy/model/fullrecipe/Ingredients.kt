package com.grdj.quecomemoshoy.model.fullrecipe

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ingredients (
	@SerializedName("text") val text : String,
	@SerializedName("weight") val weight : Double
) : Parcelable