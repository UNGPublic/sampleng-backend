package ungp.sampleng.test.veiculo;

import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.test.Condition;
import org.junit.runner.Description;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class VeiculoResourceCondition extends Condition {

    @Override
    public void prepare(Description description) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:/META-INF/applicationContext.xml");
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        mongoOperation.insert(createVeiculo());
    }

    @Override
    public void done(Description description) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:/META-INF/applicationContext.xml");
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        mongoOperation.dropCollection(Veiculo.class);
    }

    public static Veiculo createVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setNmProprietario("Natanael Walsh");
        veiculo.setNuPlaca("ABC0123");
        veiculo.setNuRenavam("5451355435453");
        return veiculo;
    }

}
