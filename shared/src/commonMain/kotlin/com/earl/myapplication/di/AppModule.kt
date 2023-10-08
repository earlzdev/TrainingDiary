package com.earl.myapplication.di

import com.earl.myapplication.networking.NetworkClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun appModule() = module {
    singleOf(::NetworkClient)
}