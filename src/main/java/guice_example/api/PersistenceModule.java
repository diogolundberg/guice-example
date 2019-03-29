package guice_example.api;

import com.google.inject.AbstractModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

import javax.inject.Inject;

public class PersistenceModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new JpaPersistModule("default"));
        bind(Initializer.class).asEagerSingleton();
    }

    private static class Initializer {
        @Inject
        public Initializer(PersistService service) {
            service.start();
        }
    }
}