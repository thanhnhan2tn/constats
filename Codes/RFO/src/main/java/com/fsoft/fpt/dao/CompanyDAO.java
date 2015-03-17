package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.Address;
import com.fsoft.fpt.model.Company;

public class CompanyDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	@Autowired
	private AddressDAO addressDAO;

	/**
	 * 
	 */
	public CompanyDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Company get(int companyId) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		System.out.println("Get company ...");
		List<Company> companies = new ArrayList<Company>();
		String sql = "select * from company where companyid = " + companyId;
		companies = jdbcTemplateObject.query(sql, new CompanyExtractor());
		// Address address = addressDAO.get(company.getAddressId());
		// company.setAddress(address);
		if (companies.isEmpty() == true) {
			return new Company();
		} else {
			return companies.get(0);
		}
	}

}
