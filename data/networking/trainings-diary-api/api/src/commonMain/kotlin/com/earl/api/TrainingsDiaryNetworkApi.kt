package com.earl.api

import com.earl.api.models.TrainingSessionApi

interface TrainingsDiaryNetworkApi {

    suspend fun doRequest(): List<TrainingSessionApi>
}