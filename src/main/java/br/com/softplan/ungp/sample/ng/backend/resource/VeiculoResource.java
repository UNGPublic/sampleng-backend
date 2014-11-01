package br.com.softplan.ungp.sample.ng.backend.resource;

import br.com.softplan.ungp.sample.ng.backend.SpringMongoConfig;
import br.com.softplan.ungp.sample.ng.backend.model.Veiculo;
import br.com.softplan.ungp.sample.ng.backend.model.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("veiculo")
public class VeiculoResource {

    @Autowired
    VeiculoRepository veiculoRepository;

    @GET
    @Produces("application/json")
    public List<Veiculo> findAll() {
        return new ArrayList<>();
    }

    @DELETE
    @Path("{placa}")
    @Consumes("application/json")
    public void delete(@PathParam("placa") String placa) {

    }

    @PUT
    @Consumes("application/json")
    public void update(Veiculo veiculo) {

    }

    @GET
    @Path("{placa}")
    @Produces("application/json")
    public Veiculo findById(@PathParam("placa") String placa) {
        //MongoOperations mongoOperation = (MongoOperations) getApplicationContext().getBean("mongoTemplate");

        //Query searchUserQuery = new Query(Criteria.where("nuPlaca").is(placa));

        //return mongoOperation.findOne(searchUserQuery, Veiculo.class);
        return veiculoRepository.findByPlaca(placa);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
    }

    protected VeiculoRepository getVeiculoRepository() {
        return getApplicationContext().getBean(VeiculoRepository.class);
    }

    protected ApplicationContext getApplicationContext() {
        return new AnnotationConfigApplicationContext(SpringMongoConfig.class);

    }
}

