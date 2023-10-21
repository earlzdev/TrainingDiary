package com.earl.api

import com.earl.api.models.TrainingSessionApi

interface TrainingSessionsNetworkApi {

    suspend fun doRequest(): List<TrainingSessionApi>
}