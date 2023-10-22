import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope

data class GradlePlugin(
    val id: String,
    val module: String? = null,
    val version: String? = null
)

fun DependencyHandlerScope.plugin(grandlePlugin: GradlePlugin): Dependency? {
    return grandlePlugin.module?.let { "classpath"(it) }
}