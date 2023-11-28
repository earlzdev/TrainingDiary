import Dependencies.Libraries.Android.androidAppDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.earl.impl"
    compileSdk = Dependencies.AndroidAppConfiguration.compileSdk

    defaultConfig {
        minSdk = Dependencies.AndroidAppConfiguration.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":core:android-design-system"))
    implementation(project(":android-navigation:api"))
    implementation(project(":features:trainings-diary:ui-android"))
    androidAppDependencies()
}