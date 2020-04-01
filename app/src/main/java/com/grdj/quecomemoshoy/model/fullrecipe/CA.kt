package com.grdj.quecomemoshoy.model.fullrecipe

import com.google.gson.annotations.SerializedName

data class CA (

	@SerializedName("label") val label : String,
	@SerializedName("quantity") val quantity : Double,
	@SerializedName("unit") val unit : String
)