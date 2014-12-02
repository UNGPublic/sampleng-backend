package ungp.sampleng.test.infracao;

import java.util.Date;
import java.util.List;

import org.junit.runner.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import ungp.sampleng.backend.entity.Infracao;
import ungp.sampleng.backend.entity.Logradouro;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.repository.InfracaoRepository;
import ungp.sampleng.backend.resource.InfracaoResource;
import ungp.sampleng.backend.util.Application;
import ungp.sampleng.backend.util.ApplicationContextProvider;
import ungp.sampleng.test.veiculo.VeiculoResourceCondition;

import javax.inject.Inject;

public class InfracaoResourceCondition extends VeiculoResourceCondition {
	public static ThreadLocal<List<Infracao>> OBJECT = new ThreadLocal<>();

    @Override
	public void prepare(Description description) {
		super.prepare(description);

		Veiculo veiculo = VeiculoResourceCondition.OBJECT.get();

		MongoOperations mongoOperation = (MongoOperations) ApplicationContextProvider.getApplicationContext().getBean("mongoTemplate");

		Logradouro logradouro = new Logradouro();
		logradouro.setId("1");
		logradouro.setLogradouro("Rua das Acacias");
		logradouro.setCep("88030000");
		logradouro.setTp_logradouro("Rua");

		Infracao infracao1 = createInfracao("1", veiculo, logradouro);
		Infracao infracao2 = createInfracao("2", veiculo, logradouro);
		
		mongoOperation.save(infracao1);
		mongoOperation.save(infracao2);
	}


	@Override
	public void done(Description description) {
		super.done(description);
		MongoOperations mongoOperation = Application.getMongoOperations();
		mongoOperation.dropCollection(Infracao.class);
		mongoOperation.dropCollection(Logradouro.class);
	}
	

	public static Infracao createInfracao(String id, Veiculo veiculo, Logradouro logradouro) {
		Infracao infracao1 = new Infracao();
		infracao1.setId(id);
		infracao1.setDtInfracao(new Date());
		infracao1.setCondutor(veiculo.getProprietario());
		infracao1.setLogradouro(logradouro);
		return infracao1;
	}

}
