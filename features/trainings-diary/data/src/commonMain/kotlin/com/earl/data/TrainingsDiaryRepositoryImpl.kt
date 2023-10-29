package com.earl.data

import com.earl.api.TrainingsDiaryNetworkApi
import com.earl.domain.TrainingsDiaryRepository
import com.earl.domain.models.TrainingSession

class TrainingsDiaryRepositoryImpl(
    private val networkApi: TrainingsDiaryNetworkApi
): TrainingsDiaryRepository {

    override suspend fun getTrainings(): List<TrainingSession> {
        return networkApi.doRequest().map {
            TrainingSession(
                it.id,
                it.dateTime,
                it.title,
                it.type,
                it.distance,
                it.description
            )
        }
    }
}