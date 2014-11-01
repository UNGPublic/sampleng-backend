package ungp.sampleng.backend.repository;

import ungp.sampleng.backend.entity.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

    Veiculo findByNuPlaca(String placa);

}
