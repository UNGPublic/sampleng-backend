package br.com.softplan.ungp.sample.ng.backend.model;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

public class VeiculoRepositoryImpl extends SimpleMongoRepository<Veiculo, String> implements VeiculoRepository {

    public VeiculoRepositoryImpl(MongoEntityInformation metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }

    @Override
    public Veiculo findByPlaca(String placa) {
        Query searchUserQuery = new Query(Criteria.where("nuPlaca").is(placa));
        return getMongoOperations().findOne(searchUserQuery, Veiculo.class);
    }
}
