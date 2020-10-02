package com.grdj.quecomemoshoy.di

import com.grdj.quecomemoshoy.api.NetworkInteractor
import com.grdj.quecomemoshoy.api.NetworkInteractorImpl
import com.grdj.quecomemoshoy.api.recipe.RecipeService
import com.grdj.quecomemoshoy.api.recipe.RecipeServiceImpl
import com.grdj.quecomemoshoy.repository.Repository
import com.grdj.quecomemoshoy.repository.RepositoryImpl
import com.grdj.quecomemoshoy.utils.resources.ResourcesProvider
import com.grdj.quecomemoshoy.utils.resources.ResourcesProviderImpl
import com.grdj.quecomemoshoy.utils.network.NetworkManager
import com.grdj.quecomemoshoy.utils.network.NetworkManagerImpl
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
    single { ResourcesProviderImpl(get()) as ResourcesProvider }
    single { RecipeServiceImpl(ResourcesProviderImpl(get())) as RecipeService }
    single { NetworkInteractorImpl() as NetworkInteractor }
    single { NetworkManagerImpl(get()) as NetworkManager }
    single { RepositoryImpl(
                NetworkManagerImpl(get()),
                NetworkInteractorImpl(),
                RecipeServiceImpl(ResourcesProviderImpl(get())),
                ResourcesProviderImpl(get())
            ) as Repository}
}