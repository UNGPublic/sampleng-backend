package ungp.sampleng.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.exception.SampleNgException;
import ungp.sampleng.backend.repository.CondutorRepository;
import ungp.sampleng.backend.repository.VeiculoRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CondutorRepository condutorRepository;

    @GET
    @Produces("application/json")
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
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
        if (veiculo == null) {
            throw new NotFoundException("Veículo não encontrado.");
        }

        return veiculo;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Veiculo veiculo) {
        if (veiculo.getProprietario() == null) {
            throw new SampleNgException("Não é possível cadastrar um veículo sem proprietário.");
        }

        //FIXME  avaliar questão realacionadas com a existência do proprietario nesse momento
        condutorRepository.save(veiculo.getProprietario());

        veiculoRepository.save(veiculo);

    }
}

