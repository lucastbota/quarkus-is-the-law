package tech.donau.course;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PriceConverter {
    /*mp.messaging.outgoing.generated-price.topic=prices*/
    @Incoming("prices")
    @Outgoing("converted-prices")
    @Broadcast
    public double convert(Long price) {
        var value = price * 1.5d;
        System.out.println("value: " + value);
        return value;
    }
}
