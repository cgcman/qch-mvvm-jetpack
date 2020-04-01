package com.grdj.quecomemoshoy.model.fullrecipe

import com.google.gson.annotations.SerializedName

data class PROCNT (
	@SerializedName("label") val label : String,
	@SerializedName("quantity") val quantity : Double,
	@SerializedName("unit") val unit : String
)