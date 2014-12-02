package ungp.sampleng.test.logradouro;

import com.mongodb.*;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import ungp.sampleng.backend.entity.Logradouro;
import ungp.sampleng.backend.util.pageable.PageData;
import ungp.sampleng.test.BaseTest;
import ungp.sampleng.test.ServerClassRule;

import java.net.UnknownHostException;
import java.util.List;

public class LogradouroResourceTest extends BaseTest {

    /**
     * Precisa inserir os logradouros.
     * TODO: precisa evoluir mais na questão da indexação.
     * @throws UnknownHostException 
     */
	@Test @Ignore
	public void testIndexSearch() throws UnknownHostException {
		/*MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "sampleng" );
		DBCollection coll = db.getCollection("logradouros");
		coll.dropIndexes();*/

        /*
		PageData page = ServerClassRule.getTarget().path("logradouro/1/10")				
				.queryParam("q", "\"Rua XV\"")
				.queryParam("q", "Florianópolis")
	            .request()
	            .get(PageData.class);
		
		
		List<Logradouro> logradouros = page.getContent();
		for (Logradouro logradouro : logradouros) {
			System.out.println(logradouro.getTp_logradouro() + " " + logradouro.getLogradouro() + ", " + logradouro.getBairro() + " - " + logradouro.getCidade());
		}
		*/

	}

}
