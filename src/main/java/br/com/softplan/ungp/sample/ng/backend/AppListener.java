package br.com.softplan.ungp.sample.ng.backend;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


@javax.servlet.annotation.WebListener()
public class AppListener implements ServletContextListener {

    public AppListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
