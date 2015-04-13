package vn.edu.cit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;

public class ServerDAOImpl implements ServerDAO {
	public static final String COLLECTION = "users";

	public ServerDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void createServer(Server sv) {
		mongoTemplate.save(sv);
	}

	@Override
	public Server getServer(User user, String ip) {
		// query to search user
		if (user.getServers() != null) {
			for (Server server : user.getServers())
				if (server.getServerAddress().equals(ip)) {
					return server;
				}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public Server getServerSudo(User user, String ip, String sudousername, String sudopass) {
		// query to search user
		if (user.getServers() != null) {
			for (Server server : user.getServers())
				if (server.getServerAddress().equals(ip)) {
					return server;
				}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public void updateServer(Server sv) {
		mongoTemplate.save(sv);
	}

}
