package ungp.sampleng.test.proprietario;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import ungp.sampleng.backend.entity.Proprietario;
import ungp.sampleng.test.PreCondition;
import ungp.sampleng.test.PreConditionRule;
import ungp.sampleng.test.ServerClassRule;

public class ProprietarioResourceTest {

    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    @Rule
    public PreConditionRule preConditionRule = new PreConditionRule();

    @Test
    @PreCondition(ProprietarioResourceCondition.class)
    public void test_findById() {
        Proprietario proprietario = ServerClassRule.getTarget().path("proprietario/11122233344").request().get(Proprietario.class);
        Assert.assertNotNull(proprietario);
        Assert.assertEquals("John Java", proprietario.getNome());
    }

    @Test
    public void test_insert() {
        Proprietario proprietario = ProprietarioResourceCondition.createProprietario();

        ServerClassRule.getTarget().path("proprietario").request()
                .post(Entity.entity(proprietario, MediaType.APPLICATION_JSON_TYPE),
                        Proprietario.class);

        proprietario = ServerClassRule.getTarget().path("proprietario/11122233344").request().get(Proprietario.class);

        Assert.assertEquals("John Java", proprietario.getNome());
    }
}
