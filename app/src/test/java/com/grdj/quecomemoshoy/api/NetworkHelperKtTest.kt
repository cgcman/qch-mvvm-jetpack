package com.grdj.quecomemoshoy.api

import com.grdj.quecomemoshoy.api.results.ResultWrapper
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import java.io.IOException

class NetworkHelperKtTest{
    val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `When response is successful the it should emit the result as SUCCESS`(){
        runBlockingTest {
            val apiResponse = true
            val response = apiCall(dispatcher){
                apiResponse
            }
            assertEquals(ResultWrapper.Success(apiResponse), response)
        }
    }

    @Test
    fun `when response throws IOException then it should emit the result as NetworkError`() {
        runBlockingTest {
            val response = apiCall(dispatcher){
                throw IOException()
            }
            assertEquals(ResultWrapper.NetworkError, response)
        }
    }

    @Test
    fun `when response throws unknown exception then it should emit GenericError`() {
        runBlockingTest {
            val response = apiCall(dispatcher) {
                throw IllegalStateException()
            }
            assertEquals(ResultWrapper.GenericError(), response)
        }
    }
}