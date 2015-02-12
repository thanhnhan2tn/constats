package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.UserType;

public class UserTypeDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public UserTypeDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public UserType get(int userTypeId) {
		List<UserType> userTypes = new ArrayList<UserType>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from UserType where UserTypeid = " + userTypeId;
		userTypes = jdbcTemplateObject.query(sql, new UserTypeExtractor());
		if (userTypes.isEmpty() == true) {
			return new UserType();
		} else {
			return userTypes.get(0);
		}
	}
	
	public List<UserType> list() {
		List<UserType> userTypes = new ArrayList<UserType>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from UserType";
		userTypes = jdbcTemplateObject.query(sql, new UserTypeExtractor());
		return userTypes;
	}

}
