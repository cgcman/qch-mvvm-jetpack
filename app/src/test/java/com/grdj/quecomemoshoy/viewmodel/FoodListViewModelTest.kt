package com.grdj.quecomemoshoy.viewmodel

import android.app.Application
import com.grdj.quecomemoshoy.model.fullrecipe.RecipesResponse
import com.grdj.quecomemoshoy.repository.Repository
import io.reactivex.Observable
import io.reactivex.subscribers.TestSubscriber
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.spy
import retrofit2.Response
import java.io.IOException

class FoodListViewModelTest {
    private lateinit var repository: Repository
    private lateinit var application: Application

    @Before
    fun setup(){
        repository = Mockito.mock(Repository::class.java)
        application = Mockito.mock(Application::class.java)
    }

    @Test
    fun `When fetchdata is call and an error exist then return error`(){
        val error: IOException = throw IOException()
        val testsubscriber : TestSubscriber<Response<RecipesResponse>> = TestSubscriber()
        val response : Observable<Response<RecipesResponse>>  = repository.getRecipesResponse("","","","","")
        val viewmodel = getFoodListViewModel()
        `when`( viewmodel.fetchData("","","","","") ).thenReturn(Unit)
    }

    private fun getFoodListViewModel() : FoodListViewModel{
        return FoodListViewModel(
            application,
            repository
        )
    }
}