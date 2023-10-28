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
include(":data:networking:training-sessions-api")
include(":android-features")
include(":android-features:training-sessions")
include(":android-core")
include(":android-core:design-system")
include(":data:networking:training-sessions-api:api")
include(":data:networking:training-sessions-api:implementation")
include(":features")
include(":features:trainings-diary")
include(":features:trainings-diary:ui")
include(":features:trainings-diary:domain")
