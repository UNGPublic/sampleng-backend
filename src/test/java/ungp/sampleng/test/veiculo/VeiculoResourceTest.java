package ungp.sampleng.test.veiculo;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.repository.VeiculoRepository;
import ungp.sampleng.test.PreCondition;
import ungp.sampleng.test.PreConditionRule;
import ungp.sampleng.test.ServerClassRule;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;


public class VeiculoResourceTest {

    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    @Rule
    public PreConditionRule preConditionRule = new PreConditionRule();

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_findById() {
        Veiculo veiculo = server.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);
        Assert.assertNotNull(veiculo);
        Assert.assertEquals("Natanael Walsh", veiculo.getNmProprietario());
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_findAll() {
        List<Veiculo> veiculos = server.getTarget().path("veiculo").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Veiculo>>() {} );
        Assert.assertNotNull(veiculos);
        Assert.assertFalse(veiculos.isEmpty());
        Assert.assertEquals("Natanael Walsh", veiculos.get(0).getNmProprietario());
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_delete() {
        Veiculo veiculo = server.getTarget().path("veiculo/ABC0123").request().delete(Veiculo.class);

        try {
            veiculo = server.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);
            Assert.fail("Deveria dar NotFoundException");

        } catch (Exception e) {
            Assert.assertTrue(e instanceof javax.ws.rs.NotFoundException);
        }

        Assert.assertNull(veiculo);
    }

    @Test @PreCondition(VeiculoResourceCondition.class)
    public void test_update() {
        Veiculo veiculo = VeiculoResourceCondition.createVeiculo();
        veiculo.setNmProprietario("Sofia");

        server.getTarget().path("veiculo").request()
                        .put(Entity.entity(veiculo, MediaType.APPLICATION_JSON_TYPE),
                                Veiculo.class);

        veiculo = server.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);

        Assert.assertEquals("Sofia", veiculo.getNmProprietario());
    }

    @Test
    public void test_insert() {
        Veiculo veiculo = VeiculoResourceCondition.createVeiculo();

        server.getTarget().path("veiculo").request()
                .post(Entity.entity(veiculo, MediaType.APPLICATION_JSON_TYPE),
                        Veiculo.class);

        veiculo = server.getTarget().path("veiculo/ABC0123").request().get(Veiculo.class);

        Assert.assertEquals("Natanael Walsh", veiculo.getNmProprietario());
    }
}
