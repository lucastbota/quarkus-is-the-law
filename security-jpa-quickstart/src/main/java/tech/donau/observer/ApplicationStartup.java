package tech.donau.observer;

import io.quarkus.runtime.StartupEvent;
import tech.donau.entity.User;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class ApplicationStartup {
    @Transactional
    public void loadUsers(@Observes StartupEvent startupEvent) {
        User.deleteAll();
        User.add("admin", "admin", "admin");
        User.add("user", "user", "user");
    }
}
