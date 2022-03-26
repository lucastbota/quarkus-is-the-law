package tech.donau.course;

import io.quarkus.infinispan.client.Remote;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import tech.donau.course.data.Book;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/books")
public class BookResource {
    @Inject
    @Remote("books")
    RemoteCache<String, Book> remoteCache;

    @Inject
    RemoteCacheManager remoteCacheManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@QueryParam("id") String id) {
        return remoteCache.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book create(Book book) {
        System.out.println(book);
        remoteCache.put(book.getId(), book);
        return book;
    }
}