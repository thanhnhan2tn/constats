package vn.edu.cit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.cit.model.Server;
import vn.edu.cit.model.ServerStatus;

public class ServerStatusDAOImpl {
	public static final String COLLECTION = "users";

	@Autowired
	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void createServerStatus(ServerStatus status) {
		mongoTemplate.save(status);
	}

	public List<ServerStatus> getServerStatus(String ip) {
		Query searchQuery = new Query(Criteria.where("serverAddress").is(ip));
		Server sv = mongoTemplate.findOne(searchQuery, Server.class);
		if (sv != null) {
			if (sv.getStatus() != null) {
				return sv.getStatus();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public void updateServerStatus(ServerStatus status) {
		mongoTemplate.save(status);
	}

}