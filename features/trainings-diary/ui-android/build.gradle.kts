import Dependencies.Libraries.Android.androidAppDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.earl.ui_android"
    compileSdk = Dependencies.AndroidAppConfiguration.compileSdk

    defaultConfig {
        minSdk = Dependencies.AndroidAppConfiguration.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":shared"))
    implementation(project(":core:android-design-system"))
    implementation(project(mapOf("path" to ":features:trainings-diary:domain:api")))
    implementation(project(mapOf("path" to ":core:common")))
    implementation(Dependencies.Libraries.mviCore)
    implementation(Dependencies.Libraries.mviLogging)
    implementation(Dependencies.Libraries.mviCoroutines)
    implementation(Dependencies.Libraries.mviMain)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    androidAppDependencies()
}