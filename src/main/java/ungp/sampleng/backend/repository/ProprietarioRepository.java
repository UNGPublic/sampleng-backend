package ungp.sampleng.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ungp.sampleng.backend.entity.Proprietario;

public interface ProprietarioRepository extends MongoRepository<Proprietario, String> {

}
