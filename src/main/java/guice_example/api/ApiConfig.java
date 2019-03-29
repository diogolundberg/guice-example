package guice_example.api;

import org.glassfish.jersey.server.ResourceConfig;

public class ApiConfig extends ResourceConfig {
    public ApiConfig() {
        packages(this.getClass().getPackage().getName());
    }
}
