package com.grdj.quecomemoshoy.di

import com.grdj.quecomemoshoy.services.RecipeService
import com.grdj.quecomemoshoy.services.RecipeServiceImpl
import com.grdj.quecomemoshoy.viewmodel.FoodListViewModel
import com.grdj.quecomemoshoy.viewmodel.MainViewModel
import com.grdj.quecomemoshoy.viewmodel.RandomFoodViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel { MainViewModel(get()) }
    viewModel { RandomFoodViewModel(get()) }
    viewModel { FoodListViewModel(get()) }
    single { RecipeServiceImpl() as RecipeService }
}