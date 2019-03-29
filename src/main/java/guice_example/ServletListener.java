package guice_example;

import guice_example.api.ApiModule;
import guice_example.api.PersistenceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        ServletModule api = new ApiModule();
        PersistenceModule persistence = new PersistenceModule();

        return Guice.createInjector(api, persistence);
    }
}
