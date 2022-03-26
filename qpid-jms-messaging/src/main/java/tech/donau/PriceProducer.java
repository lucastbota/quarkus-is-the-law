package tech.donau;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Session;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PriceProducer implements Runnable {
    private final Random random = new Random();
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    @Inject
    ConnectionFactory connectionFactory;

    public void onStart(@Observes StartupEvent startupEvent) {
        scheduledExecutorService.scheduleWithFixedDelay(this, 0L, 5L, TimeUnit.SECONDS);
    }

    public void onStop(@Observes ShutdownEvent startupEvent) {

    }

    @Override
    public void run() {
        try (JMSContext context = connectionFactory.createContext(Session.AUTO_ACKNOWLEDGE)) {
            context.createProducer().send(context.createQueue("prices"), Integer.toString(random.nextInt(100)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
