package ungp.sampleng.backend.resource;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Service
@Path("/")
public class IndexResource {

    @GET
    @Produces("text/html")
    public String index() {
        return "<A href='/sample/res/application.wadl'>WSLD</a><br/>" +
                "JSON exemplo: {\"placa\":\"ABC0102\", \"renavam\": \"9854621222\", \"proprietario\":{\"nome\": \"John Java\", \"cnh\":\"0123456789\", \"cpf\":\"11122233344\"}}";
    }


}
