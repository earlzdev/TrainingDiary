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
    id("dev.icerock.mobile.multiplatform-resources")
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
            baseName = "shared"
            export("dev.icerock.moko:resources:0.23.0")
            export("dev.icerock.moko:graphics:0.9.0")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("dev.icerock.moko:resources:0.23.0")
                implementation(project(mapOf("path" to ":data:networking:networking-utils")))
                implementation(project(mapOf("path" to ":data:networking:trainings-diary-api:api")))
                implementation(project(mapOf("path" to ":data:networking:trainings-diary-api:implementation")))
                implementation(project(mapOf("path" to ":features:trainings-diary:domain:api")))
                implementation(project(mapOf("path" to ":features:trainings-diary:domain:impl")))
                implementation(project(mapOf("path" to ":features:trainings-diary:data")))
                implementation(project(mapOf("path" to ":core:common")))
                implementation(ktorCore)
                implementation(ktorLogging)
                implementation(ktorSerialization)
                implementation(ktorSerializationJson)
                implementation(coroutines)
                implementation(kotlinXDateTime)
                implementation(contentNegotiation)
                api(koinCore)

                implementation(Dependencies.Libraries.mviCore)
                implementation(Dependencies.Libraries.mviLogging)
                implementation(Dependencies.Libraries.mviCoroutines)
                implementation(Dependencies.Libraries.mviMain)
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
    namespace = "com.earl.myapplication"
    compileSdk = Dependencies.AndroidAppConfiguration.compileSdk
    defaultConfig {
        minSdk = Dependencies.AndroidAppConfiguration.minSdk
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.earl.shared_resources"
    multiplatformResourcesClassName = "SharedResources"
}