package ungp.sampleng.test.logradouro;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import ungp.sampleng.backend.entity.Logradouro;
import ungp.sampleng.backend.util.pageable.PageData;
import ungp.sampleng.test.ServerClassRule;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class LogradouroResourceTest {
    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

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
		PageData page = ServerClassRule.getTarget().path("logradouro/1/10")				
				.queryParam("q", "\"Rua XV\"")
				.queryParam("q", "Florianópolis")
	            .request()
	            .get(PageData.class);
		
		
		List<Logradouro> logradouros = page.getContent();
		for (Logradouro logradouro : logradouros) {
			System.out.println(logradouro.getTp_logradouro() + " " + logradouro.getLogradouro() + ", " + logradouro.getBairro() + " - " + logradouro.getCidade());
		}
		
		/*
		Assert.assertEquals(Integer.valueOf(1), page.getNumber());
		Assert.assertEquals(Integer.valueOf(5), page.getSize());
		Assert.assertEquals(Long.valueOf(11), page.getTotalElements());
		Assert.assertEquals(Integer.valueOf(3), page.getTotalPages());
		Assert.assertNotNull(page.getContent());
		Assert.assertEquals(5, page.getContent().size());
		*/
		
	}
	
	@Test @Ignore
	public void testIndexSearch_mongoversion() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "sampleng" );
		DBCollection coll = db.getCollection("logradouros");
				
		BasicDBObject search = new BasicDBObject("$search", "Deodoro Marechal");
		BasicDBObject textSearch = new BasicDBObject("$text", search);
		
		DBCursor cursor = coll.find(textSearch).limit(10);
		int matchCount = cursor.count();
		System.out.println(matchCount);
		
		while( cursor.hasNext() ) {
			DBObject object = cursor.next();
			System.out.println(object);
		}
		cursor.close();
	}
	
}
