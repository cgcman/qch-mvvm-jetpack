package com.grdj.quecomemoshoy.model.fullrecipe

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.grdj.quecomemoshoy.model.FoodTypeModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hits (
	@SerializedName("recipe") val recipe : Recipe,
	@SerializedName("bookmarked") val bookmarked : Boolean,
	@SerializedName("bought") val bought : Boolean,
	@SerializedName("foodType") val foodType : FoodTypeModel
): Parcelable