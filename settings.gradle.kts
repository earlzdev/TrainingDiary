pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TrainingDiary"
include(":androidApp")
include(":shared")
include(":data")
include(":data:networking")
include(":data:networking:networking-utils")
include(":features")
include(":features:trainings-diary")
include(":features:trainings-diary:domain")
include(":data:networking:trainings-diary-api")
include(":data:networking:trainings-diary-api:api")
include(":data:networking:trainings-diary-api:implementation")
include(":features:trainings-diary:data")
include(":core")
include(":core:common")
include(":features:trainings-diary:ui-android")
include(":core:android-design-system")
include(":navigation")
include(":navigation:api")
include(":navigation:impl")
