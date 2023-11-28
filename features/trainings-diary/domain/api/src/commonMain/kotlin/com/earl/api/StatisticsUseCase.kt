package com.earl.api

import com.earl.api.models.WeeklyStats

interface StatisticsUseCase {

    fun getStats(): WeeklyStats
}