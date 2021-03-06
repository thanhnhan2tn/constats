package vn.edu.cit.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;

/**
 * Server object with JSCH and Server table in DB
 * 
 * @author Thanh
 *
 */
public class ServerDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void ServerDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public Server create(Server sv, User user){
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		//Add new Server
		
		return sv;
	}
}
