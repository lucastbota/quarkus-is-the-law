package tech.donau.course;

import tech.donau.course.service.GreetingsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private final GreetingsService service;

    @Inject
    public GreetingResource(GreetingsService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return String.format("ID: %s",service.getId());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(@HeaderParam("token") String token, @QueryParam("name") String name) {
        if (token == null) {
            throw new IllegalArgumentException("Unauthorized");
        }
        return String.format("{\"name\": \"%s\"}", name);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void get(@PathParam("id") String id) {
        System.out.println(id);
    }
}
