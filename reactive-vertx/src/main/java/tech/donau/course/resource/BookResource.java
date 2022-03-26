package tech.donau.course.resource;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;

@ApplicationScoped
public class BookResource {

    @Route(methods = Route.HttpMethod.GET)
    public void fearthenight(RoutingContext routingContext) {
        routingContext.response().end("Fear the night");
    }

    @Route(methods = Route.HttpMethod.GET)
    public void ultramarinechapter(RoutingContext routingContext) {
        routingContext.response().end("The Ultramarine's Chapter");
    }

    @Route(path = "index/codex",methods = Route.HttpMethod.GET)
    public void indexCodex(RoutingContext routingContext) {
        routingContext.response().end("The index is " + Instant.now().getEpochSecond());
    }
}
