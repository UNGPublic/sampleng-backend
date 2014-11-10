package ungp.sampleng.backend.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class IndexResource {

    @GET
    @Produces("text/html")
    public String index() {
        return "<A href='/sample/res/application.wadl'>WSLD</a><br/>" +
                "JSON exemplo: {\"nuPlaca\":\"ABC0102\", \"nuRenavam\": \"9854621222\", \"proprietario\":{\"nmProprietario\": \"John Java\", \"nuCnh\":\"0123456789\"}}";
    }

}
