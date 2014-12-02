package ungp.sampleng.test.infracao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ungp.sampleng.backend.entity.Infracao;
import ungp.sampleng.backend.resource.InfracaoResource;
import ungp.sampleng.test.BaseTest;
import ungp.sampleng.test.PreCondition;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class InfracaoResourceTest extends BaseTest {

    @Autowired
    private InfracaoResource infracaoResource;

    @Test @PreCondition(InfracaoResourceCondition.class)
    public void deve_existir_infracao() {

        Infracao infracao = getWebTarget().path("infracao/1").request().get(Infracao.class);
        Assert.assertNotNull(infracao);
        Assert.assertEquals("John Java", infracao.getCondutor().getNome());
    	
    }
    
    @Test @PreCondition(InfracaoResourceCondition.class)
    public void deve_existir_duas_infracoes_para_condutor() {
    	
        List<Infracao> infracoes = getWebTarget().path("infracao/condutor/11122233344").request().get(new GenericType<List<Infracao>>() {});
        Assert.assertNotNull(infracoes);
        Assert.assertEquals(2, infracoes.size());
    	
    }
    
}
