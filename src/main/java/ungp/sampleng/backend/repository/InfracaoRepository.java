package ungp.sampleng.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ungp.sampleng.backend.entity.Infracao;

public interface InfracaoRepository extends MongoRepository<Infracao, String> {

	List<Infracao> findByCondutorCpf(String cpf);
	
}

