package tech.donau.course;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class PriceProducer {
    private Random random = new Random();
    @Outgoing("price")
    public Multi<Long> producerPrice() {

        return
            Multi.createFrom().ticks().every(Duration.ofSeconds(2)).map(x -> random.nextLong(4000));}
}
