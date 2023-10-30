import Dependencies.Libraries.contentNegotiation
import Dependencies.Libraries.coroutines
import Dependencies.Libraries.koinCore
import Dependencies.Libraries.kotlinXDateTime
import Dependencies.Libraries.ktorCore
import Dependencies.Libraries.ktorLogging
import Dependencies.Libraries.ktorSerialization
import Dependencies.Libraries.ktorSerializationJson

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "implementation"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(mapOf("path" to ":data:networking:trainings-diary-api:api")))
                implementation(project(mapOf("path" to ":data:networking:networking-utils")))
                implementation(project(mapOf("path" to ":core:common")))
                implementation(ktorCore)
                implementation(ktorLogging)
                implementation(ktorSerialization)
                implementation(ktorSerializationJson)
                implementation(coroutines)
                implementation(kotlinXDateTime)
                implementation(contentNegotiation)
                api(koinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.earl.implementation"
    compileSdk = Dependencies.AndroidAppConfiguration.compileSdk
    defaultConfig {
        minSdk = Dependencies.AndroidAppConfiguration.minSdk
    }
}