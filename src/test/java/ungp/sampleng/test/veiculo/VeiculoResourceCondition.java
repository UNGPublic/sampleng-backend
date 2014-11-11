package ungp.sampleng.test.veiculo;

import java.util.ArrayList;

import org.junit.runner.Description;
import org.springframework.data.mongodb.core.MongoOperations;

import ungp.sampleng.backend.entity.Proprietario;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.util.Application;
import ungp.sampleng.test.Condition;

public class VeiculoResourceCondition extends Condition {

	public static ThreadLocal<Veiculo> OBJECT = new ThreadLocal<>();
	
    @Override
    public void prepare(Description description) {
        MongoOperations mongoOperation = Application.getMongoOperations();

        Veiculo veiculo = createVeiculo();
        Proprietario proprietario = veiculo.getProprietario();

        mongoOperation.insert(proprietario);
        mongoOperation.insert(veiculo);
        
        OBJECT.set(veiculo);
    }

    @Override
    public void done(Description description) {
        MongoOperations mongoOperation = Application.getMongoOperations();
        mongoOperation.dropCollection(Veiculo.class);
        mongoOperation.dropCollection(Proprietario.class);
    }

    public static Veiculo createVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC0123");
        veiculo.setRenavam("5451355435453");

        Proprietario proprietario = new Proprietario();
        proprietario.setCpf("11122233344");
        proprietario.setNome("John Java");
        proprietario.setCnh("1234567890");
        proprietario.setVeiculos(new ArrayList<Veiculo>());
        proprietario.getVeiculos().add(veiculo);
        veiculo.setProprietario(proprietario);

        return veiculo;
    }

}
