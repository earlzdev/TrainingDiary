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
include(":android-core")
include(":android-core:design-system")
include(":features")
include(":features:trainings-diary")
include(":features:trainings-diary:ui")
include(":features:trainings-diary:domain")
include(":data:networking:trainings-diary-api")
include(":data:networking:trainings-diary-api:api")
include(":data:networking:trainings-diary-api:implementation")
include(":features:trainings-diary:data")
