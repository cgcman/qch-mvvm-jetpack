package com.grdj.quecomemoshoy.model.fullrecipe

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipesResponse (
	@SerializedName("q") val q : String,
	@SerializedName("from") val from : Int,
	@SerializedName("to") val to : Int,
	@SerializedName("params") val params : Params,
	@SerializedName("more") val more : Boolean,
	@SerializedName("count") val count : Int,
	@SerializedName("hits") val hits : ArrayList<Hits>
) : Parcelable