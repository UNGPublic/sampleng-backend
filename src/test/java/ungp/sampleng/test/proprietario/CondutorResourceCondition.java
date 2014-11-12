package ungp.sampleng.test.proprietario;

import org.junit.runner.Description;
import org.springframework.data.mongodb.core.MongoOperations;

import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.util.Application;
import ungp.sampleng.test.Condition;

public class CondutorResourceCondition extends Condition {
	public static ThreadLocal<Condutor> OBJECT = new ThreadLocal<>();

	@Override
	public void prepare(Description description) {
		MongoOperations mongoOperation = Application.getMongoOperations();

		Condutor proprietario = createProprietario();

		mongoOperation.insert(proprietario);
		
		OBJECT.set(proprietario);

	}

	@Override
	public void done(Description description) {
		MongoOperations mongoOperation = Application.getMongoOperations();
		mongoOperation.dropCollection(Condutor.class);
		mongoOperation.dropCollection(Veiculo.class);
	}

	public static Condutor createProprietario() {
		Condutor proprietario = new Condutor();
		proprietario.setCpf("11122233344");
		proprietario.setNome("John Java");
		proprietario.setCnh("0123456789");
		proprietario.setProprietario(true);

		return proprietario;
	}

}
