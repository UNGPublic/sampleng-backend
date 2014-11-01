package br.com.softplan.ungp.sample.ng.backend.test;

import br.com.softplan.ungp.sample.ng.backend.SpringMongoConfig;
import br.com.softplan.ungp.sample.ng.backend.model.Veiculo;
import br.com.softplan.ungp.sample.ng.backend.model.VeiculoRepository;
import br.com.softplan.ungp.sample.ng.test.util.PreCondition;
import br.com.softplan.ungp.sample.ng.test.util.PreConditionRule;
import br.com.softplan.ungp.sample.ng.test.util.ServerClassRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes={SpringMongoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class VeiculoResourceTest {

    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    @Rule
    public PreConditionRule preConditionRule = new PreConditionRule();

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_dados() {
        Veiculo veiculo = server.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);
        Assert.assertNotNull(veiculo);
        Assert.assertTrue(veiculo.getNmProprietario().contains("Natanael"));
    }


}
