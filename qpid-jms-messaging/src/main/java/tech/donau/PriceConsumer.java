package tech.donau;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Session;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class PriceConsumer implements Runnable {
    @Inject
    ConnectionFactory connectionFactory;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private Integer lastPrice;

    public Integer getLastPrice() {
        return lastPrice;
    }

    public void onStart(@Observes StartupEvent startupEvent) {
        executorService.execute(this);
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        executorService.shutdown();
    }

    @Override
    public void run() {
        try (JMSContext context = connectionFactory.createContext(Session.AUTO_ACKNOWLEDGE)) {
            final var consumer = context.createConsumer(context.createQueue("prices"));
            while (true) {
                final Message message = consumer.receive();
                if (message != null) {
                    this.lastPrice = Integer.valueOf(message.getBody(String.class));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
