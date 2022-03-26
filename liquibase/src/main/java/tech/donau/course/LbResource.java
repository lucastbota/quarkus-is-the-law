package tech.donau.course;

import io.quarkus.liquibase.LiquibaseFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/liquibase")
public class LbResource {
    @Inject
    LiquibaseFactory liquibaseFactory;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return liquibaseFactory.getConfiguration().changeLog;
    }
}