package tech.donau.course.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import tech.donau.course.data.CurrencyDTO;
import tech.donau.course.data.MultiPartBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(configKey = "currency")
@Path("/ticker")
public interface CurrencyService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<CurrencyDTO> getCurrency(@QueryParam("id") String id);

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendFile(@MultipartForm MultiPartBody body);
}
