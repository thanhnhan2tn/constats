package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.Address;

public class AddressDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public AddressDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Address get(int addressId) {
		List<Address> addresses = new ArrayList<Address>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from address where addressid = " + addressId;
		addresses = jdbcTemplateObject.query(sql, new AddressExtractor());
		if (addresses.isEmpty() == true) {
			return new Address();
		} else {
			return addresses.get(0);
		}
		
	}

}
