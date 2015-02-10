package vn.edu.cit.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.cit.model.User;

public class UserDAOImpl implements UserDAO {
	private MongoOperations mongoOps;
	private static final String USER_COLLECTION = "User";

	public UserDAOImpl(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	public void create(User user) {
		this.mongoOps.insert(user, USER_COLLECTION);
	}

	public User getByUsername(String userName) {
		Query query = new Query(Criteria.where("userName").is(userName));
		return this.mongoOps.findOne(query, User.class, USER_COLLECTION);
	}

	public void update(User user) {

	}

	public int deleteById(String userId) {
		return 0;
	}

	public int deleteByUsername(String userName) {
		return 0;
	}

	// public boolean check(String username, String password) {
	// jdbcTemplateObject = new JdbcTemplate(dataSource);
	// String sql =
	// "select count(*) from User where username = ? and password = ?";
	// int result = jdbcTemplateObject.queryForInt(sql, new Object[] {
	// username, password });
	// System.out.println("Result = " + result);
	// return (result == 1);
	// }
}
