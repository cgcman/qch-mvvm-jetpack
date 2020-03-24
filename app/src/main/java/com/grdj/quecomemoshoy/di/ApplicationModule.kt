package com.grdj.quecomemoshoy.di

import com.grdj.quecomemoshoy.viewmodel.MainViewModel
import com.grdj.quecomemoshoy.viewmodel.RandomFoodViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel { MainViewModel(get()) }
    viewModel { RandomFoodViewModel(get()) }
}