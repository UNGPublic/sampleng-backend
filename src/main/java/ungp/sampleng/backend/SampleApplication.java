package ungp.sampleng.backend;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import ungp.sampleng.backend.filter.CORSResponseFilter;

@ApplicationPath("/res/*")
public class SampleApplication extends ResourceConfig {

    public SampleApplication() {
        System.out.println("Iniciando ApplicationPath...");
        super.packages(true, "ungp.sampleng.backend.resource", "ungp.sampleng.backend.exception");
        super.register(CORSResponseFilter.class);
    }

}