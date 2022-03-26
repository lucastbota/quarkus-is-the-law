package tech.donau.course;

import tech.donau.course.data.Book;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
public class BookResource {
    @Inject
    private Validator validator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(List.of(new Book(1L, "The snake", "How to Struggle the fools"))).build();
    }

    @POST
    @Produces
    //public Response create(@Valid Book book) {
    public Response create(Book book) {
        validator.validate(book, Book.class);
        return Response.ok(book).build();
    }
}
