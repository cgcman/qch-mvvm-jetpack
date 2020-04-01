package com.grdj.quecomemoshoy.model.fullrecipe

import com.google.gson.annotations.SerializedName

data class Sub (
	@SerializedName("label") val label : String,
	@SerializedName("tag") val tag : String,
	@SerializedName("schemaOrgTag") val schemaOrgTag : String,
	@SerializedName("total") val total : Double,
	@SerializedName("hasRDI") val hasRDI : Boolean,
	@SerializedName("daily") val daily : Double,
	@SerializedName("unit") val unit : String
)