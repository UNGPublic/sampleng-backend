package ungp.sampleng.test.logradouro;

import javax.ws.rs.core.GenericType;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import ungp.sampleng.backend.util.pageable.PageData;
import ungp.sampleng.test.ServerClassRule;

public class LogradouroResourceTest {
    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    /**
     * O boot da vm ja vem com os logradouros de SC.
     * TODO: precisa evoluir mais na questão da indexação.
     */
	@Test @Ignore
	public void testIndexSearch() {
		
		PageData page = ServerClassRule.getTarget().path("logradouro/1/5")
				.queryParam("q", "Quatro")
	            .request()
	            .get(new GenericType<PageData>() {});
		
		Assert.assertEquals(Integer.valueOf(1), page.getNumber());
		Assert.assertEquals(Integer.valueOf(5), page.getSize());
		Assert.assertEquals(Long.valueOf(11), page.getTotalElements());
		Assert.assertEquals(Integer.valueOf(3), page.getTotalPages());
		Assert.assertNotNull(page.getContent());
		Assert.assertEquals(5, page.getContent().size());
		
	}
	
	
	
}
