package tech.donau.course;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.donau.course.data.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Random;

@Path("/books")
public class BookResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(delay = 1000L, maxRetries = 4)
    public List<Book> hello() {
        var b = new Random().nextBoolean();
        if (!b) {
            LOGGER.error("Retrying");
            throw new RuntimeException("Can't connect to database.");
        }
        return getBooks();
    }


    @GET
    @Path("/timeout")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout
    public List<Book> helloWithTimeout() throws InterruptedException {
        var b = new Random().nextBoolean();
        if (!b) {
            Thread.sleep(2000l);
        }
        return getBooks();
    }

    @GET
    @Path("/fallback")
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "getFallback")
    public List<Book> helloWithFallback() {
        var b = new Random().nextBoolean();
        if (!b) {
            LOGGER.error("Fallback");
            throw new RuntimeException("Can't connect to database.");
        }
        return getBooks();
    }

    @GET
    @Path("/circuitbreaker")
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(failureRatio = 0.5, failOn = RuntimeException.class, requestVolumeThreshold = 5, delay = 3000L)
    public List<Book> helloWithCircuitBreaker() {
        var b = new Random().nextBoolean();
        if (!b) {
            LOGGER.error("Circuit Breaker");
            throw new RuntimeException("Can't connect to database.");
        }
        return getBooks();
    }

    private List<Book> getBooks() {
        return List.of(new Book("1", "First", "Author A"),
                new Book("2", "Second", "Author B"),
                new Book("3", "Third", "Author C"));
    }

    private List<Book> getFallback() {
        return List.of(new Book("1", "First Fallback", "Author A"),
                new Book("2", "Second Fallback", "Author B"),
                new Book("3", "Third Fallback", "Author C"));
    }
}