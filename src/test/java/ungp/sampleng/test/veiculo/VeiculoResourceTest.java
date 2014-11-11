package ungp.sampleng.test.veiculo;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.test.PreCondition;
import ungp.sampleng.test.PreConditionRule;
import ungp.sampleng.test.ServerClassRule;


public class VeiculoResourceTest {

    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    @Rule
    public PreConditionRule preConditionRule = new PreConditionRule();

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_findById() {
        Veiculo veiculo = ServerClassRule.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);
        Assert.assertNotNull(veiculo);
        Assert.assertEquals("John Java", veiculo.getProprietario().getNome());
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_findAll() {
        List<Veiculo> veiculos = ServerClassRule.getTarget().path("veiculo").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Veiculo>>() {} );
        Assert.assertNotNull(veiculos);
        Assert.assertFalse(veiculos.isEmpty());
        Assert.assertEquals("John Java", veiculos.get(0).getProprietario().getNome());
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_delete() {
        Veiculo veiculo = ServerClassRule.getTarget().path("veiculo/ABC0123").request().delete(Veiculo.class);

        try {
            veiculo = ServerClassRule.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);
            Assert.fail("Deveria dar NotFoundException");

        } catch (Exception e) {
            Assert.assertTrue(e instanceof javax.ws.rs.NotFoundException);
        }

        Assert.assertNull(veiculo);
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_update() {
        Veiculo veiculo = VeiculoResourceCondition.createVeiculo();
        veiculo.setRenavam("987987");

        ServerClassRule.getTarget().path("veiculo").request()
                        .put(Entity.entity(veiculo, MediaType.APPLICATION_JSON_TYPE),
                                Veiculo.class);

        veiculo = ServerClassRule.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);

        Assert.assertEquals("987987", veiculo.getRenavam());
    }

    @Test
    public void test_insert() {
        Veiculo veiculo = VeiculoResourceCondition.createVeiculo();

        ServerClassRule.getTarget().path("veiculo").request()
                .post(Entity.entity(veiculo, MediaType.APPLICATION_JSON_TYPE),
                        Veiculo.class);

        veiculo = ServerClassRule.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);

        Assert.assertEquals("John Java", veiculo.getProprietario().getNome());
    }
}
