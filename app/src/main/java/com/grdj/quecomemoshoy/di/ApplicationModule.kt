package com.grdj.quecomemoshoy.di

import com.grdj.quecomemoshoy.api.recipe.RecipeService
import com.grdj.quecomemoshoy.api.recipe.RecipeServiceImpl
import com.grdj.quecomemoshoy.repository.Repository
import com.grdj.quecomemoshoy.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {
    @Singleton
    @Provides
    fun provideRecipeServices() : RecipeService = RecipeServiceImpl()

    @Singleton
    @Provides
    fun provideRepository() : Repository = RepositoryImpl(RecipeServiceImpl())
}