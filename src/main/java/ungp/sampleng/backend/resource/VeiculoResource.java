package ungp.sampleng.backend.resource;

import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.exception.SampleNgException;
import ungp.sampleng.backend.repository.VeiculoRepository;
import ungp.sampleng.backend.util.Application;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("veiculo")
public class VeiculoResource {

    @GET
    @Produces("application/json")
    public List<Veiculo> findAll() {
        List<Veiculo> veiculos = Application.getVeiculoRepository().findAll();
        if( veiculos.isEmpty() ) {
            throw new NotFoundException("Nenhum veículo cadastrado.");
        }
        return veiculos;
    }

    @DELETE
    @Path("{placa}")
    @Consumes("application/json")
    public void delete(@PathParam("placa") String placa) {
        Application.getVeiculoRepository().delete(placa);

    }

    @PUT
    @Consumes("application/json")
    public void update(Veiculo veiculo) {
        Application.getVeiculoRepository().save(veiculo);

    }

    @GET
    @Path("{placa}")
    @Produces("application/json")
    public Veiculo findById(@PathParam("placa") String placa) {
        Veiculo veiculo = Application.getRepository(VeiculoRepository.class).findOne(placa);
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
        Application.getProprietarioRepository().save(veiculo.getProprietario());

        Application.getVeiculoRepository().save(veiculo);

    }
}

