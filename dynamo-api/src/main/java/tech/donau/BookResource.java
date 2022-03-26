package tech.donau;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookService service;

    @GET
    public List<Book> list(@QueryParam("title") String title) {
        if (title != null)
            return List.of(service.get(title));
        else
            return service.findAll();
    }

    @POST
    public List<Book> create(Book book) {
        service.add(book);
        return service.findAll();
    }
}