package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.ContactAddress;

public class ContactAddressDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public ContactAddressDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public ContactAddress get(int ContactAdressId) {
		List<ContactAddress> contactAddresses = new ArrayList<ContactAddress>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from ContactAddress where ContactAddressid = " + ContactAdressId;
		contactAddresses = jdbcTemplateObject.query(sql, new ContactAddressExtractor());
		if (contactAddresses.isEmpty() == true) {
			return new ContactAddress();
		} else {
			return contactAddresses.get(0);
		}
		
	}

}
