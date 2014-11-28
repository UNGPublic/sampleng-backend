package ungp.sampleng.backend.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Component;

import ungp.sampleng.backend.entity.Logradouro;
import ungp.sampleng.backend.exception.SampleNgException;
import ungp.sampleng.backend.repository.LogradouroRepository;
import ungp.sampleng.backend.util.pageable.PageData;

@Path("logradouro")
@Component
public class LogradouroResource {
	
	@Autowired
	private LogradouroRepository logradouroRepository;
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Logradouro findById(@PathParam("id") String id) {
		return logradouroRepository.findOne(id);
	}

	@GET
	@Path("{termo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Logradouro> findAllBy(@PathParam("termo") String termo) {
		Sort sort = new Sort("score");
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(termo);
		return logradouroRepository.findAllBy(criteria, sort);
	}
	
	@GET
	@Path("{page}/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public PageData findAllByPageable(@QueryParam("q") List<String> termos, @PathParam("page") Integer page, @PathParam("size") Integer size) {
		if( termos == null || termos.isEmpty() ) {
			throw new SampleNgException("Termos ausentes.");
		}
		Sort sort = new Sort("score");
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(termos.toArray(new String[termos.size()]));
		Page<Logradouro> pageInfo = logradouroRepository.findAllBy(criteria, new PageRequest(page, size, sort));
		
		PageData pd = new PageData();
		pd.setContent( pageInfo.getContent() );
		pd.setNumber( pageInfo.getNumber() );
		pd.setNumberOfElements( pageInfo.getNumberOfElements() );
		pd.setSize( pageInfo.getSize() );
		pd.setTotalElements( pageInfo.getTotalElements() );
		pd.setTotalPages( pageInfo.getTotalPages() );
		
		return pd;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Logradouro logradouro) {

		logradouroRepository.save(logradouro);

	}
		
}
