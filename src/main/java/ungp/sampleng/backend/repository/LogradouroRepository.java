package ungp.sampleng.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import ungp.sampleng.backend.entity.Logradouro;

public interface LogradouroRepository extends MongoRepository<Logradouro, String> {

    List<Logradouro> findAllBy(TextCriteria criteria, Sort sort);
	
	Page<Logradouro> findAllBy(TextCriteria criteria, Pageable pageable);
	
	List<Logradouro> findByLogradouroOrderByScoreDesc(String logradouro, TextCriteria criteria);
	
}

