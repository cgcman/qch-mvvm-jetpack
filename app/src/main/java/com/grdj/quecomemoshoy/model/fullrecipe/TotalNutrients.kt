package com.grdj.quecomemoshoy.model.fullrecipe

import com.google.gson.annotations.SerializedName

data class TotalNutrients (
	@SerializedName("ENERC_KCAL") val eNERC_KCAL : ENERC_KCAL,
	@SerializedName("FAT") val fAT : FAT,
	@SerializedName("FASAT") val fASAT : FASAT,
	@SerializedName("FATRN") val fATRN : FATRN,
	@SerializedName("FAMS") val fAMS : FAMS,
	@SerializedName("FAPU") val fAPU : FAPU,
	@SerializedName("CHOCDF") val cHOCDF : CHOCDF,
	@SerializedName("FIBTG") val fIBTG : FIBTG,
	@SerializedName("SUGAR") val sUGAR : SUGAR,
	@SerializedName("PROCNT") val pROCNT : PROCNT,
	@SerializedName("CHOLE") val cHOLE : CHOLE,
	@SerializedName("NA") val nA : NA,
	@SerializedName("CA") val cA : CA,
	@SerializedName("MG") val mG : MG,
	@SerializedName("K") val k : K,
	@SerializedName("FE") val fE : FE,
	@SerializedName("ZN") val zN : ZN,
	@SerializedName("P") val p : P,
	@SerializedName("VITA_RAE") val vITA_RAE : VITA_RAE,
	@SerializedName("VITC") val vITC : VITC,
	@SerializedName("THIA") val tHIA : THIA,
	@SerializedName("RIBF") val rIBF : RIBF,
	@SerializedName("NIA") val nIA : NIA,
	@SerializedName("VITB6A") val vITB6A : VITB6A,
	@SerializedName("FOL") val fOL : FOL,
	@SerializedName("VITB12") val vITB12 : VITB12,
	@SerializedName("VITD") val vITD : VITD,
	@SerializedName("TOCPHA") val tOCPHA : TOCPHA,
	@SerializedName("VITK1") val vITK1 : VITK1
)