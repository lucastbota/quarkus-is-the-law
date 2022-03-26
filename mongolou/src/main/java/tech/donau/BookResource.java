package tech.donau;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookService service;

    @GET
    public List<Book> list() {
        return service.list();
    }

    @POST
    public List<Book> create(Book book) {
        service.add(book);
        return list();
    }
}