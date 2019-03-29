package guice_example;

import guice_example.api.ApiConfig;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(GuiceContainer.class);
                new ApiConfig().getClasses().forEach(resource -> bind(resource));
                serve("/*").with(GuiceContainer.class);
            }
        });
    }
}
