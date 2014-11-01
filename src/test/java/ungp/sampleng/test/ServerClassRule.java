package ungp.sampleng.test;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

public class ServerClassRule implements TestRule {

    public static final String BASE_URI = "http://localhost:8888/myapp/";

    protected static HttpServer server;
    protected static WebTarget target;

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    server = startServer();
                    Client c = ClientBuilder.newClient();

                    target = c.target(BASE_URI);

                    base.evaluate();

                } catch (Throwable e) {
                    throw new RuntimeException(e);

                } finally {
                    server.stop();
                }

            }
        };
    }

    HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages(
                "ungp.sampleng.backend.resource",
                "ungp.sampleng.backend.exception");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    public static HttpServer getServer() {
        return server;
    }

    public static WebTarget getTarget() {
        return target;
    }
}
