package ungp.sampleng.backend.resource;

import ungp.sampleng.backend.entity.Proprietario;
import ungp.sampleng.backend.util.Application;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("proprietario")
public class ProprietarioResource {

    @GET
    @Path("{cnh}")
    public Proprietario findById(@PathParam("cnh") String cnh) {
        return Application.getProprietarioRepository().findOne(cnh);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Proprietario proprietario) {

        Application.getProprietarioRepository().save(proprietario);

    }

}
