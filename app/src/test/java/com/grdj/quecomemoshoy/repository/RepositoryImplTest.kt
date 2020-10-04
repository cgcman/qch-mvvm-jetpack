package com.grdj.quecomemoshoy.repository

import com.grdj.quecomemoshoy.api.CoroutineTestRule
import com.grdj.quecomemoshoy.api.NetworkInteractorImpl
import com.grdj.quecomemoshoy.api.recipe.RecipeServiceImpl
import com.grdj.quecomemoshoy.api.results.ResultWrapper
import com.grdj.quecomemoshoy.utils.network.NetworkManagerImpl
import com.grdj.quecomemoshoy.utils.resources.ResourcesProviderImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.spy
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class RepositoryImplTest{
    private lateinit var networkManager: NetworkManagerImpl
    private lateinit var  networkInteractor: NetworkInteractorImpl
    private lateinit var  service: RecipeServiceImpl
    private lateinit var  resourceProvider: ResourcesProviderImpl

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @Before
    fun setup(){
        networkInteractor = mock(NetworkInteractorImpl::class.java)
        networkManager = mock(NetworkManagerImpl::class.java)
        service = mock(RecipeServiceImpl::class.java)
        resourceProvider = mock(ResourcesProviderImpl::class.java)
    }

    @Test
    fun `when getRecipesList is call and there is NO CONNECTION the returns network error`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val repository = getRepositoryImpl()
        val result = ResultWrapper.NetworkError
        repository.getRecipesList("","","")
        `when`(networkManager.isConnected()).thenReturn(false)
        verify(networkManager, times(1)).notConnectedMessage(resourceProvider.getNotConnectedMessage())
        assertEquals(repository.getRecipesList("","",""), result)
    }

    @Test
    fun `when getRecipesList is call and there IS CONNECTION the returns Success`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val repository = getRepositoryImpl()
        val resultSuccess = ResultWrapper.Success(true)
        val SUT = spy(getNetworkInteractor())
        val lambdaResult = true
        val result = SUT.apiCall() { lambdaResult }
        repository.getRecipesList("","","")
        `when`(networkManager.isConnected()).thenReturn(true)
        assertEquals(resultSuccess, result)
    }

    fun getRepositoryImpl() : RepositoryImpl{
        return RepositoryImpl(
            networkManager,
            networkInteractor,
            service,
            resourceProvider
        )
    }

    fun getNetworkInteractor() : NetworkInteractorImpl {
        return NetworkInteractorImpl(coroutinesTestRule.testDispatcherProvider)
    }

}