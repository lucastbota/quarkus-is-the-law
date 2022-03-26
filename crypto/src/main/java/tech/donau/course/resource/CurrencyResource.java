package tech.donau.course.resource;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import tech.donau.course.data.CurrencyDTO;
import tech.donau.course.data.MultiPartBody;
import tech.donau.course.service.CurrencyService;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

@Path("/currencies")
public class CurrencyResource {
    @Inject
    @RestClient
    CurrencyService currencyService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CurrencyDTO> findById(@PathParam("id") String id) {
        System.out.println("requisiton received: " + id);
        var result = currencyService.getCurrency(id);
        result.forEach(System.out::println);
        return result;
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile(@MultipartForm MultiPartBody multiPartBody) {
        return "";
    }
}
