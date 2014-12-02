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
import ungp.sampleng.test.BaseTest;
import ungp.sampleng.test.PreCondition;
import ungp.sampleng.test.PreConditionRule;
import ungp.sampleng.test.ServerClassRule;


public class VeiculoResourceTest extends BaseTest {

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_findById() {
        Veiculo veiculo = getWebTarget().path("veiculo/ABC0123").request().get(Veiculo.class);
        Assert.assertNotNull(veiculo);
        Assert.assertEquals("John Java", veiculo.getProprietario().getNome());
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_findAll() {
        List<Veiculo> veiculos = getWebTarget().path("veiculo").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Veiculo>>() {} );
        Assert.assertNotNull(veiculos);
        Assert.assertFalse(veiculos.isEmpty());
        Assert.assertEquals("John Java", veiculos.get(0).getProprietario().getNome());
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_delete() {
        Veiculo veiculo = getWebTarget().path("veiculo/ABC0123").request().delete(Veiculo.class);

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

        getWebTarget().path("veiculo").request()
              .put(Entity.entity(veiculo, MediaType.APPLICATION_JSON_TYPE), Veiculo.class);

        veiculo = getWebTarget().path("veiculo/ABC0123").request().get(Veiculo.class);

        Assert.assertEquals("987987", veiculo.getRenavam());
    }

    @Test
    public void test_insert() {
        Veiculo veiculo = VeiculoResourceCondition.createVeiculo();

        getWebTarget().path("veiculo").request()
              .post(Entity.entity(veiculo, MediaType.APPLICATION_JSON_TYPE), Veiculo.class);

        veiculo = getWebTarget().path("veiculo/ABC0123").request().get(Veiculo.class);

        Assert.assertEquals("John Java", veiculo.getProprietario().getNome());
    }
}
