package ungp.sampleng.backend.filter;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

public class CrossDomainFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        containerResponseContext.getHeaders().add("Access-Control-Max-Age", "1209600");

    }

}
