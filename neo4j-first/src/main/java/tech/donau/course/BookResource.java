package tech.donau.course;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Values;
import org.neo4j.driver.async.AsyncSession;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    Driver driver;

    @GET
    public CompletionStage<Response> list() {
        final AsyncSession session = driver.asyncSession();

        return session.runAsync("MATCH (b:Book) RETURN b ORDER BY b.title")
                .thenCompose(cursor -> cursor.listAsync(record -> Book.from(record.get("b").asNode())))
                .thenCompose(books ->
                        session.closeAsync().thenApply(it -> books))
                .thenApply(Response::ok)
                .thenApply(Response.ResponseBuilder::build);
    }

    @POST
    public CompletionStage<Response> create(Book book) {
        final AsyncSession session = driver.asyncSession();
        return session.writeTransactionAsync(tx -> tx.runAsync("CREATE (b:Book {title: $title, pages: $pages}) RETURN b",
                                Values.parameters("title", book.title(), "pages", book.pages()))
                        .thenCompose(fn -> fn.singleAsync()))
                .thenApply(record -> Book.from(record.get("b").asNode()))
                .thenCompose(createdBook -> session.closeAsync().thenApply(it -> createdBook))
                .thenApply(Response::ok)
                .thenApply(Response.ResponseBuilder::build);
    }
}