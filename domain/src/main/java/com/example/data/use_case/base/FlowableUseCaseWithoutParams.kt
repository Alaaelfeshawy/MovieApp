package com.example.data.use_case.base

import com.example.data.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

abstract class FlowableUseCaseWithoutParams<T : Any> {

    abstract suspend fun  run(): Flow<ApiResult<T>>

    suspend fun invoke() =
        flow {
            emit(ResponseResult.IsLoading(true))
            run().map {
                when (it) {
                    is ApiSuccess -> ResponseResult.Success(it.data)
                    is ApiError -> ResponseResult.Error(it.code,it.message , it.errorStatus)
                }
            }.collect {
                emit(it)
            }
            emit(ResponseResult.IsLoading(false))
        }.flowOn(Dispatchers.IO)

}