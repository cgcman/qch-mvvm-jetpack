package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import com.grdj.quecomemoshoy.model.RecipeModel

class RandomFoodViewModel (application: Application): BaseViewModel(application) {

    var recipeList = ArrayList<RecipeModel>()
    var foodTypeListNames =  arrayOf("Pizza","Pasta","Carnes","Pollo","Mexicana","Ensaladas","Caliente","Pescado","Hamburguesas")
    var foodTypeImagesNames =  arrayOf("https://www.laespanolaaceites.com/wp-content/uploads/2019/06/pizza-con-tomate-albahaca-y-mozzarella-1080x671.jpg",
        "https://www.brocolipasion.com/wp-content/uploads/2018/09/pasta-con-calabaza-y-jamon.jpg",
        "https://asadacho.com/wp-content/uploads/2014/11/carne-conservacion.jpg",
        "https://www.laespanolaaceites.com/wp-content/uploads/2019/06/pollo-relleno-al-horno-1080x671.jpg",
        "https://www.comedera.com/wp-content/uploads/2017/06/cocina-mexicana.jpg",
        "https://www.budgetbytes.com/wp-content/uploads/2017/03/Super-Fresh-Salad-close-2.jpg",
        "https://www.budgetbytes.com/wp-content/uploads/2014/11/Moroccan-Lentil-and-Vegetable-Stew-bowl.jpg",
        "https://bonduelle.es/media/zoo/images/dorada_horno_6ce7bd0c30fd260e3028fba4b55cd71d.jpg",
        "https://cdn2.salsadesoja.com/wp-content/uploads/2017/10/hamburguesa-con-salsa-de-soja-portada.jpg")


    fun fetchFoodData(){
        for((index, value) in foodTypeListNames.withIndex()){
            val _ftm = RecipeModel(value, foodTypeImagesNames.get(index))
            recipeList.add( _ftm );
        }
    }
}
