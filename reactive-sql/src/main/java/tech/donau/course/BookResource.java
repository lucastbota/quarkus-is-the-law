package tech.donau.course;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.mysqlclient.MySQLPool;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/book")
public class BookResource {
    @Inject
    MySQLPool pool;

    public void onStart(@Observes StartupEvent event) {
        System.out.println("Observing");

        pool.query("DROP TABLE IF EXISTS Book").execute()
                .flatMap(r -> pool.query("CREATE TABLE IF NOT EXISTS Book(id integer primary key,title varchar(20) not null)").execute())
                .flatMap(r ->pool.query("INSERT INTO Book (id,title) VALUES (1, 'foo'), (2,'things'), (3, 'The unknow mask'), (4, 'The reaper')").execute())
                .await().indefinitely();

        System.out.println("Observed");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Book>> listBooks() {
        return pool.query("SELECT * FROM Book").execute().onItem().transform(r -> {
            List<Book> books = new ArrayList<>();

            for (var x : r) {
                books.add(Book.from(x));
            }
            return books;
        });
    }
}