package tech.donau;

import org.flywaydb.core.Flyway;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/flyway")
public class FlywayResource {
    @Inject
    Flyway flyway;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return flyway.info().current().getVersion().toString();
    }
}