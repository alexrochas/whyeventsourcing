import org.gradle.api.Plugin
import org.gradle.api.Project

class EventuateDependencyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.dependencies {
            if (project.hasProperty("eventuateDriver") && project.property("eventuateDriver") == "local") {
                compile "io.eventuate.client.java:eventuate-client-java-http-stomp-spring:0.20.0.RELEASE"
            } else
                compile "io.eventuate.local.java:eventuate-local-java-jdbc:0.20.0.RELEASE"
        }
    }
}
