import org.gradle.kotlin.dsl.DependencyHandlerScope
import DependencyHandlerExtensions.implementation

object Dependencies {

    /** Kotlinx dependencies */
    private const val kotlinxSerializationPluginVersion = "1.9.0"

    /** Jetpack Compose */
    private const val composeUi = "1.4.3"
    private const val composeUiTooling = "1.4.3"
    private const val composeUiToolingPreview = "1.4.3"
    private const val composeFoundation = "1.4.3"
    private const val composeMaterialDesign = "1.4.3"
    private const val activityCompose = "1.7.1"
    private const val navigationCompose = "2.7.3"

    /** Ktor */
    private const val ktorVersion = "2.3.4"

    /** Coroutines */
    private const val coroutinesVersion = "1.6.4"

    object AndroidAppConfiguration {
        const val compileSdk = 34
        const val targetSdk = 34
        const val minSdk = 26
        const val versionCode = 1
        const val versionName = "1.0"
    }

    object Plugins {
        val androidApplication = GradlePlugin(id = "com.android.application")
        val kotlinSerialization = GradlePlugin(
            id = "org.jetbrains.kotlin.plugin.serialization",
            module = "org.jetbrains.kotlin:kotlin-serialization:$kotlinxSerializationPluginVersion"
        )
    }

    object Libraries {

        const val ktorCore = "io.ktor:ktor-client-core:$ktorVersion"
        const val ktorOkHttp = "io.ktor:ktor-client-okhttp:$ktorVersion"
        const val ktorDarwin = "io.ktor:ktor-client-darwin:$ktorVersion"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val jetpackComposeNavigation = "androidx.navigation:navigation-compose:$navigationCompose"

        object Android {

            private val jetpackComposeDependencies = listOf(
                "androidx.compose.ui:ui:$composeUi",
                "androidx.compose.ui:ui-tooling:$composeUiTooling",
                "androidx.compose.ui:ui-tooling-preview:$composeUiToolingPreview",
                "androidx.compose.foundation:foundation:$composeFoundation",
                "androidx.compose.material:material:$composeMaterialDesign",
                "androidx.activity:activity-compose:$activityCompose",
            )

            private val androidDependencies = mutableListOf<String>().apply {
                addAll(jetpackComposeDependencies)
                add(coroutines)
                add(ktorOkHttp)
                add(jetpackComposeNavigation)
            }

            fun DependencyHandlerScope.androidAppDependencies() {
                implementation(androidDependencies)
            }
        }

        object Multiplatform {

            object CommonMain {

                val commonMainDependencies = listOf(ktorCore, coroutines)
            }
        }
    }
}