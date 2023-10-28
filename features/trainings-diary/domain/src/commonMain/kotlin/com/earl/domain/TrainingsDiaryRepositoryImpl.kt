package com.earl.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrainingsDiaryRepositoryImpl(

): TrainingsDiaryRepository {

    override fun getActualData(): Flow<String> {
        return flow {
            emit("Start emit")
            delay(1000)
            emit("After 1 second emitted")
            delay(4000)
            emit("After 5 second emitted")
            delay(9000)
            emit("After 10 seconds emitted")
        }
    }

    override suspend fun testFoo(): String {
        delay(5000)
        return "TestFoo result after 5s"
    }
}