package ungp.sampleng.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ungp.sampleng.backend.entity.Proprietario;
import ungp.sampleng.backend.entity.Veiculo;

public interface ProprietarioRepository extends MongoRepository<Proprietario, String> {

}
