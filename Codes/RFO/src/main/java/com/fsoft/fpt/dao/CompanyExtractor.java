package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.Company;

public class CompanyExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Company> companies = new ArrayList<Company>();
		while(rs.next()) {
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
			companies.add(company);
		}
		return companies;
	}

}
