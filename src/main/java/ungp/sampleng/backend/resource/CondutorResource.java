package ungp.sampleng.backend.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.backend.util.Application;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("condutor")
public class CondutorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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