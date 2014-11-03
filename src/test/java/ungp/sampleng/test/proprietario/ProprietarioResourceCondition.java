package ungp.sampleng.test.proprietario;


import org.junit.runner.Description;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import ungp.sampleng.backend.entity.Proprietario;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.test.Condition;

import java.util.ArrayList;

public class ProprietarioResourceCondition extends Condition {

        @Override
        public void prepare(Description description) {
            ApplicationContext ctx =
                    new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
            MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

            Proprietario proprietario = createProprietario();
            Veiculo veiculo = proprietario.getVeiculos().get(0);

            mongoOperation.insert(proprietario);
            mongoOperation.insert(veiculo);
        }

        @Override
        public void done(Description description) {
            ApplicationContext ctx =
                    new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
            MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
            mongoOperation.dropCollection(Proprietario.class);
            mongoOperation.dropCollection(Veiculo.class);
        }

        public static Proprietario createProprietario() {
            Proprietario proprietario = new Proprietario();
            proprietario.setNmProprietario("John Java");
            proprietario.setNuCnh("0123456789");

            Veiculo veiculo = new Veiculo();
            veiculo.setNuPlaca("ABC0123");
            veiculo.setNuRenavam("5451355435453");
            proprietario.setVeiculos(new ArrayList<Veiculo>());
            proprietario.getVeiculos().add(veiculo);

            return proprietario;
        }

}
