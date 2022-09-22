package com.example.data.util

import com.example.data.util.AppConstants.NO_CONNECTION_CODE
import com.example.data.util.AppConstants.TIME_OUT_CODE
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

sealed class ResponseResult<out T : Any> {

    object Idle:ResponseResult<Nothing>()

    data class IsLoading(val isLoading: Boolean) : ResponseResult<Nothing>()

    data class Success<out T : Any>(val data: T) : ResponseResult<T>()

    data class Error(val code: Int?, val message: String? , val errorStatus: ErrorStatus?=null) : ResponseResult<Nothing>()
}

sealed interface ApiResult<T : Any>
class ApiSuccess<T : Any>(val data: T) : ApiResult<T>
class ApiError<T : Any>(val code: Int?, val message: String? , val errorStatus: ErrorStatus?=null) : ApiResult<T>

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): ApiResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            ApiSuccess(body)
        } else {
            ApiError(code = response.code(), message = response.message())
        }
    } catch (throwable: HttpException) {
        ApiError(code = throwable.code(), message = throwable.message())
    } catch (e: Throwable) {
        ApiError(code = null , message = e.message , errorStatus = ErrorStatus.UNKNOWN_ERROR)
    } catch (s: SocketTimeoutException) {
        ApiError(code =TIME_OUT_CODE, message = s.message , errorStatus = ErrorStatus.TIMEOUT)
    }catch (io:IOException){
        ApiError(code = NO_CONNECTION_CODE, message = io.message , errorStatus = ErrorStatus.NO_CONNECTION)
    }
}

enum class ErrorStatus {
    TIMEOUT,
    NO_CONNECTION,
    UNKNOWN_ERROR
}
