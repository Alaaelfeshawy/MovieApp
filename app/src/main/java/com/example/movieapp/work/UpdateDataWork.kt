package com.example.movieapp.work

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.data.repository.HomeRepository
import com.example.data.source.local.room.AppDatabase
import com.example.data.use_case.home.GetTopRatedMoviesUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import retrofit2.HttpException

@HiltWorker
class UpdateDataWork @AssistedInject  constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val appDatabase: AppDatabase
) : CoroutineWorker(context, workerParams) {

    companion object {
        const val WORK_NAME = "UpdateDataWork"
    }

    override suspend fun doWork(): Result {
        return try {
            appDatabase.movieDao().delete()
            getTopRatedMoviesUseCase.invoke().collect{}
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}
