package br.com.softplan.ungp.sample.ng.backend.test;

import br.com.softplan.ungp.sample.ng.backend.AppListener;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.BeforeClass;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

public class Base {
    public static final String BASE_URI = "http://localhost:8080/myapp/";
    protected static HttpServer server;
    protected static WebTarget target;

    @BeforeClass
    public static void setUp() throws Exception {
        server = startServer();
        Client c = ClientBuilder.newClient();

        target = c.target(BASE_URI);

        new AppListener().contextInitialized(null);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages(
                "br.com.softplan.ungp.sample.ng.backend.resource",
                "br.com.softplan.ungp.sample.ng.backend.exception");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
}
