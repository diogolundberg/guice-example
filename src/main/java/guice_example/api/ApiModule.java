package guice_example.api;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.glassfish.jersey.server.ResourceConfig;


public class ApiModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(GuiceContainer.class);
        new Config().getClasses().forEach(resource -> bind(resource));
        serve("/*").with(GuiceContainer.class);
    }

    private class Config extends ResourceConfig {
        public Config() {
            packages(this.getClass().getPackage().getName());
        }
    }
}
