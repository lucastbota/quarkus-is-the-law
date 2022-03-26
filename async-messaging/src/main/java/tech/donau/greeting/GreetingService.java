package tech.donau.greeting;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class GreetingService {

    @ConsumeEvent(value = "greeting")
    public String onMessage(String name) {
        return "Hello " + name;
    }

   /* @ConsumeEvent(value = "greeting")
    //public CompletionStage<String> onMessageAsynchronous(String name) {
    public Uni<String> onMessageAsynchronous(Message<String> data) {
        System.out.println(data.address());
        return Uni.createFrom().item("Hello " + data.body());
    }*/
}
