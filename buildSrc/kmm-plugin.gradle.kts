plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
    val iosTarget = getIosTarget()
    iosTarget("ios") {}
}

android {

    defaultConfig {
        applicationId = "com.earl.myapplication.android"
        minSdk = Dependencies.AndroidAppConfiguration.minSdk
        targetSdk = Dependencies.AndroidAppConfiguration.targetSdk
        versionCode = Dependencies.AndroidAppConfiguration.versionCode
        versionName = Dependencies.AndroidAppConfiguration.versionName
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

object Utils {

    fun KotlinMultiPlatformExtension().getIosTarget(): (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
    when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }
}