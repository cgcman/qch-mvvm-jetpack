package com.grdj.quecomemoshoy.model.fullrecipe

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Digest (
	@SerializedName("label") val label : String,
	@SerializedName("tag") val tag : String,
	@SerializedName("schemaOrgTag") val schemaOrgTag : String,
	@SerializedName("total") val total : Double,
	@SerializedName("hasRDI") val hasRDI : Boolean,
	@SerializedName("daily") val daily : Double,
	@SerializedName("unit") val unit : String,
	@SerializedName("sub") val sub : List<Sub>
) : Parcelable