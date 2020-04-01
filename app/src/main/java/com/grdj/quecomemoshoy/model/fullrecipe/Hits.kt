package com.grdj.quecomemoshoy.model.fullrecipe

import com.google.gson.annotations.SerializedName

data class Hits (
	@SerializedName("recipe") val recipe : Recipe,
	@SerializedName("bookmarked") val bookmarked : Boolean,
	@SerializedName("bought") val bought : Boolean
)