package vn.edu.cit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.cit.model.Log;

public class LogDAOImpl implements LogDAO {
	public static final String COLLECTION = "logs";

	public LogDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void createLog(Log log) {
		mongoTemplate.save(log);
	}

	@Override
	public Log getLog(String date) {
		Query searchQuery = new Query(Criteria.where("date").is(date));
		Log log = mongoTemplate.findOne(searchQuery, Log.class);
		return log;
	}

	@Override
	public List<Log> getAllLogs() {
		List<Log> logs = mongoTemplate.findAll(Log.class);
		return logs;
	}
}
