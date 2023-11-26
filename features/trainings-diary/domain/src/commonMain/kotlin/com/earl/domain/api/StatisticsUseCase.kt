package com.earl.domain.api

import com.earl.domain.api.models.WeeklyStats

interface StatisticsUseCase {

    fun getStats(): WeeklyStats
}