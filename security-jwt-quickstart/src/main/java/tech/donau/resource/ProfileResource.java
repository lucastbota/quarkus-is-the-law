package tech.donau.resource;

import tech.donau.service.TokenService;
import tech.donau.utils.TokenUtils;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/profile")
@RequestScoped
public class ProfileResource {

    @Inject
    TokenService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({TokenUtils.ROLE_USER})
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Map<String, String> register(User user) {
        return Map.of("token", service.generate(user));
    }
}