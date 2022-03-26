package tech.donau.course;

import org.hibernate.search.mapper.orm.Search;
import tech.donau.course.entity.Author;
import tech.donau.course.entity.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@Path("/book")
public class BookResource {

    @Inject
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var list = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        return list.stream().map(b -> b.getName()).collect(Collectors.joining(","));
    }
}