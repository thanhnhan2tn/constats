package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.CustomerType;

public class CustomerTypeDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public CustomerTypeDAO() {

	}

	public CustomerType get(int customerTypeId) {
		List<CustomerType> customerTypes = new ArrayList<CustomerType>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from customertype where customertypeid = " + customerTypeId;
		customerTypes = (List<CustomerType>) jdbcTemplateObject.query(sql, new CustomerTypeExtractor());
		if (customerTypes.isEmpty() == true) {
			return new CustomerType();
		} else {
			return customerTypes.get(0);
		}
	}
	
	public List<CustomerType> list() {
		List<CustomerType> customerTypes = new ArrayList<CustomerType>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from customertype";
		customerTypes = (List<CustomerType>) jdbcTemplateObject.query(sql, new CustomerTypeExtractor());
		return customerTypes;
	}

}
