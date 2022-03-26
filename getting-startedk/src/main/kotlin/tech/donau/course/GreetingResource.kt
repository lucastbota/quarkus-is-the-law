package tech.donau.course

import tech.donau.course.service.GreetingService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {

    @Inject
    @field: Default
    lateinit var greetingService: GreetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello RESTEasy"

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun greet(@PathParam("name") name: String): String = greetingService.greetIt(name)
}