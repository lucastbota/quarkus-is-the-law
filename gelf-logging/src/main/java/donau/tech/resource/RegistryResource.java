package donau.tech.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/registry")
public class RegistryResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistryResource.class);

    @GET
    public String getInfo() {
        LOGGER.info("Method getInfo is called");
        return "Info is empty.";
    }
}
