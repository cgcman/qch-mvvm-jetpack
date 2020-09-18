package com.grdj.quecomemoshoy.di

import com.grdj.quecomemoshoy.api.recipe.RecipeService
import com.grdj.quecomemoshoy.api.recipe.RecipeServiceImpl
import com.grdj.quecomemoshoy.repository.Repository
import com.grdj.quecomemoshoy.repository.RepositoryImpl
import com.grdj.quecomemoshoy.viewmodel.FoodDetailsViewModel
import com.grdj.quecomemoshoy.viewmodel.FoodListViewModel
import com.grdj.quecomemoshoy.viewmodel.MainViewModel
import com.grdj.quecomemoshoy.viewmodel.RandomFoodViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel { MainViewModel(get()) }
    viewModel { RandomFoodViewModel(get()) }
    viewModel { FoodListViewModel(get()) }
    viewModel { FoodDetailsViewModel(get()) }
    single { RecipeServiceImpl() as RecipeService }
    single { RepositoryImpl(RecipeServiceImpl()) as Repository}
}