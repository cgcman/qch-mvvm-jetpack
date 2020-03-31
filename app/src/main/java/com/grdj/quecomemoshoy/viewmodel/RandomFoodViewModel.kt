package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import com.grdj.quecomemoshoy.model.RecipeModel

class RandomFoodViewModel (application: Application): BaseViewModel(application) {

    var recipeList = ArrayList<RecipeModel>()
    var foodTypeListNames =  arrayOf("Pizza","Pasta","Carnes","Pollo","Mexicana","Ensaladas","Caliente","Pescado","Hamburguesas")
    var foodTypeImagesNames =  arrayOf("http://www.amomikitchenaid.com/wp-content/uploads/2017/02/BLOG-RECETA-PIZZA-MARGARITA-MAR17-800x600.jpg",
        "http://perudelights.com/wp-content/uploads/2013/04/pasta-huancaina-10.jpg",
        "http://media.healthday.com/Images/icimages/steak33.jpg?resize=800:600",
        "http://www.polloalamostaza.com/wp-content/uploads/2016/03/pollo-relleno-al-horno.jpg",
        "http://perudelights.com/wp-content/uploads/2013/04/taco-de-lomo-saltado.jpg",
        "https://www.budgetbytes.com/wp-content/uploads/2017/03/Super-Fresh-Salad-close-2.jpg",
        "https://www.budgetbytes.com/wp-content/uploads/2014/11/Moroccan-Lentil-and-Vegetable-Stew-bowl.jpg",
        "http://perudelights.com/wp-content/uploads/2013/08/Chaufa-de-pescado.R.-jpg-2.jpg",
        "https://cdn2.salsadesoja.com/wp-content/uploads/2017/10/hamburguesa-con-salsa-de-soja-portada.jpg")


    fun fetchFoodData(){
        for((index, value) in foodTypeListNames.withIndex()){
            val _ftm = RecipeModel(value, foodTypeImagesNames.get(index))
            recipeList.add( _ftm );
        }
    }
}
