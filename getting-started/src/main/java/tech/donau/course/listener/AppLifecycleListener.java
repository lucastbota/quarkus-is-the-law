package tech.donau.course.listener;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@ApplicationScoped
public class AppLifecycleListener {
    private static Logger LOGGER = Logger.getLogger("LifeCycle");
    public void onStart(@Observes StartupEvent startupEvent){
        LOGGER.info("Onstart Executed");
    }
    public void onStop(@Observes ShutdownEvent shutdown){
        LOGGER.info("Onstop Executed");
    }
}
