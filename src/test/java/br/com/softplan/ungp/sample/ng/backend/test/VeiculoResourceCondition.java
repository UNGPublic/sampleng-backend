package br.com.softplan.ungp.sample.ng.backend.test;

import br.com.softplan.ungp.sample.ng.backend.SpringMongoConfig;
import br.com.softplan.ungp.sample.ng.backend.model.Veiculo;
import br.com.softplan.ungp.sample.ng.test.util.Condition;
import org.junit.runner.Description;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class VeiculoResourceCondition extends Condition {

    @Override
    public void prepare(Description description) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        mongoOperation.insert(createVeiculo());
    }

    @Override
    public void done(Description description) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        mongoOperation.dropCollection(Veiculo.class);
    }

    protected Veiculo createVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setNmProprietario("Natanael Walsh");
        veiculo.setNuPlaca("ABC0123");
        veiculo.setNuRenavam("5451355435453");
        return veiculo;
    }

}
