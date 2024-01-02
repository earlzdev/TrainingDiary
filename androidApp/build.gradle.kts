import Dependencies.Libraries.Android.androidAppDependencies

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.earl.myapplication.android"
    compileSdk = Dependencies.AndroidAppConfiguration.compileSdk
    defaultConfig {
        applicationId = "com.earl.myapplication.android"
        minSdk = Dependencies.AndroidAppConfiguration.minSdk
        targetSdk = Dependencies.AndroidAppConfiguration.targetSdk
        versionCode = Dependencies.AndroidAppConfiguration.versionCode
        versionName = Dependencies.AndroidAppConfiguration.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":features:trainings-diary:ui-android"))
    implementation(project(":core:android-design-system"))
    implementation(project(":android-navigation"))
    androidAppDependencies()
}