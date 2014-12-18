package ungp.sampleng.backend.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.backend.util.Application;

@Path("condutor")
public class CondutorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Condutor> findAll() {
        return Application.getCondutorRepository().findAll();
    }

    @GET
    @Path("{cnh}")
    public Condutor findById(@PathParam("cnh") String cnh) {
        return Application.getCondutorRepository().findOne(cnh);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Condutor condutor) {

        Application.getCondutorRepository().save(condutor);

    }

    @PUT
    @Consumes("application/json")
    public void update(Condutor condutor) {
        Application.getCondutorRepository().save(condutor);

    }

}
