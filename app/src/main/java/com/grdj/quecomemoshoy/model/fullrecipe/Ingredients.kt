package com.grdj.quecomemoshoy.model.fullrecipe

import com.google.gson.annotations.SerializedName

data class Ingredients (
	@SerializedName("text") val text : String,
	@SerializedName("weight") val weight : Double
)