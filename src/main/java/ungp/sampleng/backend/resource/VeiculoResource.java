package ungp.sampleng.backend.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.exception.SampleNgException;
import ungp.sampleng.backend.repository.CondutorRepository;
import ungp.sampleng.backend.repository.VeiculoRepository;

@Path("veiculo")
@Component
public class VeiculoResource {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private CondutorRepository condutorRepository;

    @GET
    @Produces("application/json")
    public List<Veiculo> findAll() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        if( veiculos.isEmpty() ) {
            throw new NotFoundException("Nenhum veículo cadastrado.");
        }
        return veiculos;
    }

    @DELETE
    @Path("{placa}")
    @Consumes("application/json")
    public void delete(@PathParam("placa") String placa) {
        veiculoRepository.delete(placa);

    }

    @PUT
    @Consumes("application/json")
    public void update(Veiculo veiculo) {
    	veiculoRepository.save(veiculo);

    }

    @GET
    @Path("{placa}")
    @Produces("application/json")
    public Veiculo findById(@PathParam("placa") String placa) {
        Veiculo veiculo = veiculoRepository.findOne(placa);
        if( veiculo == null ) {
            throw new NotFoundException("Veículo não encontrado.");
        }

        return veiculo;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Veiculo veiculo) {
        if( veiculo.getProprietario() == null ) {
            throw new SampleNgException("Não é possível cadastrar um veículo sem proprietário.");
        }

        //FIXME  avaliar questão realacionadas com a existência do proprietario nesse momento
        condutorRepository.save(veiculo.getProprietario());

        veiculoRepository.save(veiculo);

    }
}

