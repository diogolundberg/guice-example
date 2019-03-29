package guice_example;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import com.google.inject.servlet.GuiceFilter;

public class Run {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler();
        context.addEventListener(new ServletListener());
        context.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        context.addServlet(DefaultServlet.class, "/");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
