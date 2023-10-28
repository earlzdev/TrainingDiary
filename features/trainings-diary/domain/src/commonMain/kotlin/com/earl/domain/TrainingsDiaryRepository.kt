package com.earl.domain

import kotlinx.coroutines.flow.Flow

interface TrainingsDiaryRepository {

    fun getActualData(): Flow<String>

    suspend fun testFoo(): String
}