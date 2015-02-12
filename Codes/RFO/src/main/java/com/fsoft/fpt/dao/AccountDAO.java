package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public AccountDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public boolean check(String username, String password) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select count(*) from Account where username = ? and password = ?";
		int result = jdbcTemplateObject.queryForInt(sql, new Object[] {
				username, password });
		System.out.println("Result = " + result);
		return (result == 1);
	}

}
