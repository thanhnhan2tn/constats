package vn.edu.cit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.cit.model.User;

public class UserDAOImpl implements UserDAO {
	public static final String COLLECTION = "users";

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void createUser(User user) {
		mongoTemplate.save(user);
	}

	@Override
	public User getUser(String username) {
		// query to search user
		Query searchQuery = new Query(Criteria.where("email").is(username));
		return mongoTemplate.findOne(searchQuery, User.class);
	}

	@Override
	public void updateUser(User user) {
		mongoTemplate.save(user);
	}

	@Override
	public List<User> getUsers() {
		return mongoTemplate.findAll(User.class);
	}
}
