package ungp.sampleng.test.proprietario;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.test.PreCondition;
import ungp.sampleng.test.PreConditionRule;
import ungp.sampleng.test.ServerClassRule;

public class CondutorResourceTest {

    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    @Rule
    public PreConditionRule preConditionRule = new PreConditionRule();

    @Test
    @PreCondition(CondutorResourceCondition.class)
    public void test_findById() {
        Condutor proprietario = ServerClassRule.getTarget().path("condutor/11122233344").request().get(Condutor.class);
        Assert.assertNotNull(proprietario);
        Assert.assertEquals("John Java", proprietario.getNome());
    }

    @Test
    public void test_insert() {
    	Condutor proprietario = CondutorResourceCondition.createProprietario();

        ServerClassRule.getTarget().path("condutor").request()
                .post(Entity.entity(proprietario, MediaType.APPLICATION_JSON_TYPE),
                		Condutor.class);

        proprietario = ServerClassRule.getTarget().path("condutor/11122233344").request().get(Condutor.class);

        Assert.assertEquals("John Java", proprietario.getNome());
    }
}
