package vn.edu.cit.dao;

import java.util.List;

import model.server.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;

public class ServerStatusDAOImpl {
//	public static final String COLLECTION = "users";
//
//	@Autowired
//	private MongoTemplate mongoTemplate;
//
//	public void setMongoTemplate(MongoTemplate mongoTemplate) {
//		this.mongoTemplate = mongoTemplate;
//	}
//
//	public void createServerStatus(ServerStatus status) {
//		mongoTemplate.save(status);
//	}
//
//	public boolean checkEnable(User user, String ip) {
//		Query searchQuery = new Query(Criteria.where("email").is(user.getEmail()));
//		User u = mongoTemplate.findOne(searchQuery, User.class);
//		if (u != null) {
//			Server sv = u.getServerByIp(ip);
//			if (sv != null) {
//
//			} else {
//				return false;
//			}
//		}
//		return false;
//	}
//
//	public List<ServerStatus> getServerStatus(User user, String ip) {
//		Query searchQuery = new Query(Criteria.where("email").is(user.getEmail()));
//		User u = mongoTemplate.findOne(searchQuery, User.class);
//		if (u != null) {
//			Server sv = u.getServerByIp(ip);
//			if (sv != null) {
//				return null;
//			} else {
//				return null;
//			}
//		}
//		return null;
//	}
//
//	public void updateServerStatus(ServerStatus status) {
//		mongoTemplate.save(status);
//	}

}
