package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import com.grdj.quecomemoshoy.model.FoodTypeModel
import com.grdj.quecomemoshoy.utils.Constants.FOOD_TYPE_IMAGES
import com.grdj.quecomemoshoy.utils.Constants.FOOD_TYPE_NAMES

class MainViewModel(application: Application): BaseViewModel(application){

    val foodTypeList :ArrayList<FoodTypeModel> = ArrayList()
    val foodTypeListNames =  FOOD_TYPE_NAMES
    val foodTypeListImgages =  FOOD_TYPE_IMAGES

    fun fetchFoodTypeData(){
        foodTypeList.clear()
        for((index, value) in foodTypeListNames.withIndex()){
            val _ftm = FoodTypeModel(value, foodTypeListImgages.get(index))
            foodTypeList.add( _ftm );
        }
    }
}