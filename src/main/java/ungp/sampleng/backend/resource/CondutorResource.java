package ungp.sampleng.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.backend.repository.CondutorRepository;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("condutor")
@Resource
@Component
public class CondutorResource {
	
	@Autowired
	private CondutorRepository condutorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Condutor> findAll() {
        return condutorRepository.findAll();
    }

    @GET
    @Path("{cnh}")
    public Condutor findById(@PathParam("cnh") String cnh) {
        return condutorRepository.findOne(cnh);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Condutor condutor) {
    	condutorRepository.save(condutor);
    }

    @PUT
    @Consumes("application/json")
    public void update(Condutor condutor) {
    	condutorRepository.save(condutor);

    }

}
