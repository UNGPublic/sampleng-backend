package ungp.sampleng.test.proprietario;

import org.junit.runner.Description;
import org.springframework.data.mongodb.core.MongoOperations;

import ungp.sampleng.backend.entity.Proprietario;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.util.Application;
import ungp.sampleng.test.Condition;

import java.util.ArrayList;

public class ProprietarioResourceCondition extends Condition {
	public static ThreadLocal<Proprietario> OBJECT = new ThreadLocal<>();

	@Override
	public void prepare(Description description) {
		MongoOperations mongoOperation = Application.getMongoOperations();

		Proprietario proprietario = createProprietario();
		Veiculo veiculo = proprietario.getVeiculos().get(0);

		mongoOperation.insert(proprietario);
		mongoOperation.insert(veiculo);
		
		OBJECT.set(proprietario);

	}

	@Override
	public void done(Description description) {
		MongoOperations mongoOperation = Application.getMongoOperations();
		mongoOperation.dropCollection(Proprietario.class);
		mongoOperation.dropCollection(Veiculo.class);
	}

	public static Proprietario createProprietario() {
		Proprietario proprietario = new Proprietario();
		proprietario.setCpf("11122233344");
		proprietario.setNome("John Java");
		proprietario.setCnh("0123456789");

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("ABC0123");
		veiculo.setRenavam("5451355435453");
		proprietario.setVeiculos(new ArrayList<Veiculo>());
		proprietario.getVeiculos().add(veiculo);

		return proprietario;
	}

}
