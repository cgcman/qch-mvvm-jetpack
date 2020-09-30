package com.grdj.quecomemoshoy.api

import com.grdj.quecomemoshoy.api.results.ResultWrapper
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test
import java.io.IOException

class NetworkHelperKtTest{
    private val dispatcher = TestCoroutineDispatcher()

    @Test
    fun `when lambda returns successfully then it should emit the result as success`() {
        runBlockingTest {
            val lambdaResult = true
            val result = apiCall(dispatcher) { lambdaResult }
            assertEquals(ResultWrapper.Success(lambdaResult), result)
        }
    }

    @Test
    fun `when lambda throws IOException then it should emit the result as NetworkError`() {
        runBlockingTest {
            val result = apiCall(dispatcher) { throw IOException() }
            assertEquals(ResultWrapper.NetworkError, result)
        }
    }

    @Test
    fun `when lambda throws unknown exception then it should emit GenericError`() {
        runBlockingTest {
            val result = apiCall(dispatcher) {
                throw IllegalStateException()
            }
            assertEquals(ResultWrapper.GenericError(), result)
        }
    }
}