package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import com.grdj.quecomemoshoy.model.RecipeModel
import com.grdj.quecomemoshoy.utils.Constants.FOOD_TYPE_NAMES
import com.grdj.quecomemoshoy.utils.Constants.FOOD_TYPE_URLS

class RandomFoodViewModel (application: Application): BaseViewModel(application) {

    var recipeList = ArrayList<RecipeModel>()
    var foodTypeListNames =  FOOD_TYPE_NAMES
    var foodTypeImagesNames =  FOOD_TYPE_URLS

    fun fetchFoodData(){
        for((index, value) in foodTypeListNames.withIndex()){
            val _ftm = RecipeModel(value, foodTypeImagesNames.get(index))
            recipeList.add( _ftm );
        }
    }
}
