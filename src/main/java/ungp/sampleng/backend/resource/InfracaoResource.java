package ungp.sampleng.backend.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import ungp.sampleng.backend.entity.Infracao;
import ungp.sampleng.backend.repository.InfracaoRepository;

@Service
@Path("infracao")
public class InfracaoResource {
	
	@Autowired
    private InfracaoRepository infracaoRepository;

    @GET
    @Path("condutor/{cpf}")
    @Produces("application/json")
    public List<Infracao> findByCondutor(@PathParam("cpf") String cpf) {
    	//FIXME verificar se o CPF do condutor é referente ao do usuário logado ou, 
    	//se condutor está relacionado com outros condutores que possui o cpf informado.
    	
        List<Infracao> infracoes = infracaoRepository.findByCondutorCpf(cpf);
        if( infracoes.isEmpty() ) {
            throw new NotFoundException("Nenhuma infração registrada.");
        }
        return infracoes;
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Infracao findById(@PathParam("id") String id) {
    	Infracao infracao = infracaoRepository.findOne(id);
        if( infracao == null ) {
            throw new NotFoundException("Infração não encontrada.");
        }

        return infracao;
    }
    
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Infracao infracao) {

    	infracaoRepository.save(infracao);

	}

}

