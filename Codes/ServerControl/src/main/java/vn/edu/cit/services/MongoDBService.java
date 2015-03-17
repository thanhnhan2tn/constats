package vn.edu.cit.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoDBService {

	public MongoDBService() {
		// TODO Auto-generated constructor stub
	}

	public static MongoOperations getMongoService() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringMongoConfig.class);
		return (MongoOperations) ctx.getBean("mongoTemplate");
	}
}
