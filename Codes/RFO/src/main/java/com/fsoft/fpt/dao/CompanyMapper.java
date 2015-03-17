package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.fsoft.fpt.model.Address;
import com.fsoft.fpt.model.Company;

public class CompanyMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
		Company company = new Company();
		company.setAddressId(rs.getInt("addressid"));
		company.setName(rs.getString("name"));
		company.setType(rs.getString("type"));
		company.setStatus(rs.getString("status"));
		company.setSector(rs.getString("sector"));
		company.setPhoneNumber(rs.getString("phonenumber"));
		company.setFaxNumber(rs.getString("faxnumber"));
		company.setEmailAddress(rs.getString("emailaddress"));
		company.setCreatedBy(rs.getString("createdby"));
		company.setBusinessArea(rs.getString("businessarea"));
		return company;
	}
	
}
