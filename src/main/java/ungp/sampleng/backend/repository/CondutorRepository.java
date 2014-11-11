package ungp.sampleng.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ungp.sampleng.backend.entity.Condutor;

public interface CondutorRepository extends MongoRepository<Condutor, String> {

}
