package com.grdj.quecomemoshoy.api

import com.grdj.quecomemoshoy.api.results.ResultWrapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class NetworkHelperKtTest{

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @Test
    fun `when results returns successfully then it should emit the result as success`() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            val SUT = getNetworkInteractor()
            val lambdaResult = true
            val result = SUT.apiCall() { lambdaResult }
            assertEquals(ResultWrapper.Success(lambdaResult), result)
        }
    }

    @Test
    fun `when results throws IOException then it should emit the result as NetworkError`() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            val SUT = getNetworkInteractor()
            val result = SUT.apiCall() { throw IOException() }
            assertEquals(ResultWrapper.NetworkError, result)
        }
    }

    @Test
    fun `when results throws unknown exception then it should emit GenericError`() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            val SUT = getNetworkInteractor()
            val result = SUT.apiCall() {
                throw IllegalStateException()
            }
            assertEquals(ResultWrapper.GenericError(), result)
        }
    }

    fun getNetworkInteractor() : NetworkInteractorImpl {
        return NetworkInteractorImpl(coroutinesTestRule.testDispatcherProvider)
    }
}