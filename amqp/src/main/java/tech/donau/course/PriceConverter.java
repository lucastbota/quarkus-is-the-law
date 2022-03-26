package tech.donau.course;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PriceConverter {

    @Incoming("prices")
    @Outgoing("converted-prices")
    @Broadcast
    public double convert(int price) {
        var value = price * 2.0d;
        System.out.println("value: " + value);
        return value;
    }
}
