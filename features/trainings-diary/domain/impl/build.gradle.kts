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
            baseName = "impl"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(mapOf("path" to ":core:common")))
                implementation(project(mapOf("path" to ":features:trainings-diary:domain:api")))
                implementation(Dependencies.Libraries.coroutines)
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
    namespace = "com.earl.impl"
    compileSdk = Dependencies.AndroidAppConfiguration.compileSdk
    defaultConfig {
        minSdk = Dependencies.AndroidAppConfiguration.minSdk
    }
}