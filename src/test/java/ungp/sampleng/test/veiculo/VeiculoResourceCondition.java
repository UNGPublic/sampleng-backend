package ungp.sampleng.test.veiculo;

import org.junit.runner.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.stereotype.Component;
import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.repository.VeiculoRepository;
import ungp.sampleng.backend.util.Application;
import ungp.sampleng.backend.util.ApplicationContextProvider;
import ungp.sampleng.test.Condition;

public class VeiculoResourceCondition extends Condition {

	public static ThreadLocal<Veiculo> OBJECT = new ThreadLocal<>();
	@Autowired
    VeiculoRepository repository;
    @Override
    public void prepare(Description description) {
        MongoOperations mongoOperation = (MongoOperations) ApplicationContextProvider.getApplicationContext().getBean("mongoTemplate");

        Veiculo veiculo = createVeiculo();
        Condutor proprietario = veiculo.getProprietario();

        mongoOperation.insert(proprietario);
        mongoOperation.insert(veiculo);
        
        OBJECT.set(veiculo);
    }

    @Override
    public void done(Description description) {
        MongoOperations mongoOperation = Application.getMongoOperations();
        mongoOperation.dropCollection(Veiculo.class);
        mongoOperation.dropCollection(Condutor.class);
    }

    public static Veiculo createVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC0123");
        veiculo.setRenavam("5451355435453");

        Condutor proprietario = new Condutor();
        proprietario.setCpf("11122233344");
        proprietario.setNome("John Java");
        proprietario.setCnh("1234567890");
        proprietario.setProprietario(true);
        veiculo.setProprietario(proprietario);

        return veiculo;
    }

}
