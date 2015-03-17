package vn.edu.cit.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import vn.edu.cit.model.User;

public class UserService {
	private MongoOperations mongo = MongoDBService.getMongoService();
	public User getUser(String username) {
		
		// query to search user
		Query searchQuery = new Query(Criteria.where("email").is(username));
		User user = mongo.findOne(searchQuery, User.class);
		// System.out.println(user);
		return user;
	}


	public static void main(String args[]) {
		// System.out.println(UserService.getUser("thanhnhan2tn@gmail.com"));
		// System.out.println(ctx);
	}
}
