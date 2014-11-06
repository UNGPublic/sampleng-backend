package ungp.sampleng.backend;

import org.glassfish.jersey.server.ResourceConfig;
import ungp.sampleng.backend.repository.ProprietarioRepository;
import ungp.sampleng.backend.resource.VeiculoResource;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class SampleApplication extends ResourceConfig {

    public SampleApplication() {
        System.out.println("Iniciando ApplicationPath /sampleng...");
        super.packages(true, "ungp.sampleng.backend.resource", "ungp.sampleng.backend.exception");
    }

}