package tech.donau;

import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.Principal;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
    @Inject
    SecurityIdentity securityIdentity;

    @Path("/users")
    @GET
    @NoCache
    @RolesAllowed("user")
    public Principal userPrincipal() {
        LOGGER.info("debug");
        return securityIdentity.getPrincipal();
    }

    @Path("/admin")
    @GET
    @NoCache
    @RolesAllowed("admin")
    public Principal adminPrincipal() {
        LOGGER.info("debug");
        return securityIdentity.getPrincipal();
    }

    @Path("/one")
    @PermitAll
    public void securityTestOne(){}
    @Path("/two")
    @DenyAll
    public void securityTesttwo(){}
}