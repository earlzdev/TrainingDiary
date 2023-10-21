import org.gradle.api.artifacts.dsl.DependencyHandler

object DependencyHandlerExtensions {

    fun DependencyHandler.kapt(list: List<String>) {
        list.forEach { dependency ->
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementation(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.implementationProject(list: List<String>) {
        list.forEach { path ->
            add("implementation", project(mapOf("path" to path)))
        }
    }
}