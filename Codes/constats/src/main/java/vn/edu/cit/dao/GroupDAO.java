package vn.edu.cit.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import vn.edu.cit.model.Group;
import vn.edu.cit.model.GroupExtractor;

/**
 * Class Group is e model of Group table in DB
 * 
 * @author Thanh
 *
 */
public class GroupDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public GroupDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("unchecked")
	public Group get(int groupId){
		Group group = new Group();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "SELECT groupId, groupName FROM group WHERE groupId = "+ groupId;
		group = jdbcTemplateObject.query(sql, new GroupExtractor());
		return group;
	}
}
