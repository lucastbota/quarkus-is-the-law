package tech.donau;

import tech.donau.data.Weather;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/weather")
public class WeatherResource {
    @Inject
    WeatherService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getInfoByCity(@QueryParam("city") String city) {
        return service.getBy(city);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eraseCacheByCity(@QueryParam("city") String city) {
        if(city == null) {
            service.invalidateAll();
        }else {
            service.invalidate(city);
        }
        return Response.ok().build();
    }
}