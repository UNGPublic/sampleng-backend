package ungp.sampleng.test.logradouro;

import java.net.UnknownHostException;

import javax.ws.rs.core.GenericType;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import ungp.sampleng.backend.util.pageable.PageData;
import ungp.sampleng.test.ServerClassRule;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class LogradouroResourceTest {
    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    /**
     * O boot da vm ja vem com os logradouros de SC.
     * TODO: precisa evoluir mais na questão da indexação.
     */
	@Test
	public void testIndexSearch() {
		
		PageData page = ServerClassRule.getTarget().path("logradouro/1/5")
				.queryParam("q", "quatro")
	            .request()
	            .get(new GenericType<PageData>() {});
		
		Assert.assertEquals(Integer.valueOf(1), page.getNumber());
		Assert.assertEquals(Integer.valueOf(5), page.getSize());
		Assert.assertEquals(Long.valueOf(11), page.getTotalElements());
		Assert.assertEquals(Integer.valueOf(3), page.getTotalPages());
		Assert.assertNotNull(page.getContent());
		Assert.assertEquals(5, page.getContent().size());
		
	}
	
	@Test
	public void testIndexSearch_mongoversion() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "sampleng" );
		DBCollection coll = db.getCollection("logradouros");
				
		BasicDBObject search = new BasicDBObject("$search", "quatro");
		BasicDBObject textSearch = new BasicDBObject("$text", search);
		int matchCount = coll.find(textSearch).count();
		Assert.assertEquals(11, matchCount);		
	}
	
}
