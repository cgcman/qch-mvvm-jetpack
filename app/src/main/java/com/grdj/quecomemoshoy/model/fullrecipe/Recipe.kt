package com.grdj.quecomemoshoy.model.fullrecipe

import com.google.gson.annotations.SerializedName

data class Recipe (
	@SerializedName("uri") val uri : String,
	@SerializedName("label") val label : String,
	@SerializedName("image") val image : String,
	@SerializedName("source") val source : String,
	@SerializedName("url") val url : String,
	@SerializedName("shareAs") val shareAs : String,
	@SerializedName("yield") val yield : Int,
	@SerializedName("dietLabels") val dietLabels : List<String>,
	@SerializedName("healthLabels") val healthLabels : List<String>,
	@SerializedName("cautions") val cautions : List<String>,
	@SerializedName("ingredientLines") val ingredientLines : List<String>,
	@SerializedName("ingredients") val ingredients : List<Ingredients>,
	@SerializedName("calories") val calories : Double,
	@SerializedName("totalWeight") val totalWeight : Double,
	@SerializedName("totalNutrients") val totalNutrients : TotalNutrients,
	@SerializedName("totalDaily") val totalDaily : TotalDaily,
	@SerializedName("digest") val digest : List<Digest>
)