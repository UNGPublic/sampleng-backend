package ungp.sampleng.backend.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.backend.repository.CondutorRepository;

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
