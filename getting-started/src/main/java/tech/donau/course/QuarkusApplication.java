package tech.donau.course;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(title = "Getting Started API",
        description = "Just entry point on Quarkus World",
        version = "1")
)
public class QuarkusApplication extends Application {
}
