package ungp.sampleng.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;
import ungp.sampleng.backend.entity.Logradouro;
import ungp.sampleng.backend.exception.SampleNgException;
import ungp.sampleng.backend.repository.LogradouroRepository;
import ungp.sampleng.backend.util.pageable.PageData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("logradouro")
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
        if (termos == null || termos.isEmpty()) {
            throw new SampleNgException("Termos ausentes.");
        }
        Sort sort = new Sort("score");
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(termos.toArray(new String[termos.size()]));
        Page<Logradouro> pageInfo = logradouroRepository.findAllBy(criteria, new PageRequest(page, size, sort));

        PageData pd = new PageData();
        pd.setContent(pageInfo.getContent());
        pd.setNumber(pageInfo.getNumber());
        pd.setNumberOfElements(pageInfo.getNumberOfElements());
        pd.setSize(pageInfo.getSize());
        pd.setTotalElements(pageInfo.getTotalElements());
        pd.setTotalPages(pageInfo.getTotalPages());

        return pd;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Logradouro logradouro) {

        logradouroRepository.save(logradouro);

    }

}
