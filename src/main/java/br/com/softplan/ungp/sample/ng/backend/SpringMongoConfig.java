package br.com.softplan.ungp.sample.ng.backend;

import br.com.softplan.ungp.sample.ng.backend.model.VeiculoRepository;
import br.com.softplan.ungp.sample.ng.backend.model.VeiculoRepositoryImpl;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Repository;

//basePackages = "br.com.softplan.ungp.sample.ng.backend.model")
@Configuration
public class SpringMongoConfig {

    public String getDatabaseName() {
        return "sample";
    }

    public @Bean MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    public @Bean MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(), "database");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
