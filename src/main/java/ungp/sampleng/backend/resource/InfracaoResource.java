package ungp.sampleng.backend.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ungp.sampleng.backend.entity.Infracao;
import ungp.sampleng.backend.util.Application;

@Path("infracao")
public class InfracaoResource {

    @GET
    @Path("condutor/{cpf}")
    @Produces("application/json")
    public List<Infracao> findByCondutor(@PathParam("cpf") String cpf) {
    	//FIXME verificar se o CPF do condutor é referente ao do usuário logado ou, 
    	//se condutor está relacionado com outros condutores que possui o cpf informado.
    	
        List<Infracao> infracoes = Application.getInfracaoRepository().findByCondutorCpf(cpf);
        if( infracoes.isEmpty() ) {
            throw new NotFoundException("Nenhuma infração registrada.");
        }
        return infracoes;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Infracao findById(@PathParam("id") String id) {
    	Infracao infracao = Application.getInfracaoRepository().findOne(id);
        if( infracao == null ) {
            throw new NotFoundException("Infração não encontrada.");
        }

        return infracao;
    }

}

