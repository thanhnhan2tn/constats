package vn.edu.cit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.model.Server;

@Controller
public class TestMongoDB {
	@Autowired
	public ApplicationContext ctx;

	@RequestMapping(value = "/testMongo", method = RequestMethod.GET)
	public String TestMongo() {
		// TODO Auto-generated constructor stub
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		for(int i = 1;i<=99;i++){
		Server server = new Server(i, "192.168.1.1"+i, 22, "root", "123456");
		// save
		mongoOperation.insert(server);
		System.out.println(i+". server : " + server);
		}
		// now user object got the created id.

		// query to search user
		Query searchQuery = new Query(Criteria.where("serverUsername").is(
				"root"));

		// find the saved user again.
		Server saved = mongoOperation.findOne(searchQuery, Server.class);
		System.out.println("2. find - savedServer : " + saved.getServerAddress());

		// update password
		mongoOperation.updateFirst(searchQuery,
				Update.update("serverPassword", "1234"), Server.class);

		// find the updated user object
		Server updatedServer = mongoOperation
				.findOne(searchQuery, Server.class);

		System.out.println("3. updatedServer : " + updatedServer);

		// delete
		//mongoOperation.remove(searchQuery, Server.class);

		// List, it should be empty now.
		List<Server> listServer = mongoOperation.findAll(Server.class);
		System.out.println("4. Number of user = " + listServer.size());
		return "home";
	}
}
