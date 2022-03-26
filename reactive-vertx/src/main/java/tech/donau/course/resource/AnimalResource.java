package tech.donau.course.resource;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.quarkus.vertx.web.RouteFilter;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;


@ApplicationScoped
@RouteBase(path = "mammal", produces = "text/html")
public class AnimalResource {

    @Route(methods = Route.HttpMethod.GET)
    public void lion(RoutingContext routingContext) {
        routingContext.response().end("Roar");
    }

    @Route(methods = Route.HttpMethod.GET)
    public void dog(RoutingExchange exchange) {
        exchange.ok("Woof");
    }

    public void init(@Observes Router router) {
        router.get("/cow").method(HttpMethod.GET).handler(rc -> rc.response().end("mu!"));
    }

    @RouteFilter
    public void myFilter(RoutingContext routingContext) {
        routingContext.response().putHeader("api-key", "xpto");
        routingContext.next();
    }
}
