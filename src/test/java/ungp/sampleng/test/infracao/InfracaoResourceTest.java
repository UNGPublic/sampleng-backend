package ungp.sampleng.test.infracao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import ungp.sampleng.backend.entity.Infracao;
import ungp.sampleng.test.PreCondition;
import ungp.sampleng.test.PreConditionRule;
import ungp.sampleng.test.ServerClassRule;

public class InfracaoResourceTest {

    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    @Rule
    public PreConditionRule preConditionRule = new PreConditionRule();

    @Test @PreCondition(InfracaoResourceCondition.class)
    public void deve_existir_infracao() {
    	
        Infracao infracao = ServerClassRule.getTarget().path("infracao/1").request().get(Infracao.class);
        Assert.assertNotNull(infracao);
        Assert.assertEquals("John Java", infracao.getCondutor().getNome());
    	
    }
    
    @Test @PreCondition(InfracaoResourceCondition.class)
    public void deve_existir_duas_infracoes_para_condutor() {
    	
        List<Infracao> infracoes = ServerClassRule.getTarget().path("infracao/condutor/11122233344").request().get(new GenericType<List<Infracao>>() {});
        Assert.assertNotNull(infracoes);
        Assert.assertEquals(2, infracoes.size());
    	
    }
    
}
