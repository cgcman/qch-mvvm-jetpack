package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.model.FoodTypeModel
import androidx.hilt.lifecycle.ViewModelInject

class MainViewModel @ViewModelInject constructor(application: Application): BaseViewModel(application){

    val foodTypeList :ArrayList<FoodTypeModel> = ArrayList()
    val foodTypeListNames =  arrayOf("Pizza","Pasta","Carnes","Pollo","Mexicana","Ensaladas","Guisantes","Pescado","Hamburguesas")
    val foodTypeListImgages =  arrayOf(
        R.drawable.ic_001_pizza,
        R.drawable.ic_002_espaguetis,
        R.drawable.ic_003_ternera,
        R.drawable.ic_004_pierna_de_pollo,
        R.drawable.ic_005_taco,
        R.drawable.ic_006_ensalada,
        R.drawable.ic_007_cocina,
        R.drawable.ic_008_pescado,
        R.drawable.ic_burger)


    fun fetchFoodTypeData(){
        foodTypeList.clear()
        for((index, value) in foodTypeListNames.withIndex()){
            val _ftm = FoodTypeModel(value, foodTypeListImgages.get(index))
            foodTypeList.add( _ftm );
        }
    }

}