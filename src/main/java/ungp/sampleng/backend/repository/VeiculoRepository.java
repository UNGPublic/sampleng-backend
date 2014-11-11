package ungp.sampleng.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ungp.sampleng.backend.entity.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

}
