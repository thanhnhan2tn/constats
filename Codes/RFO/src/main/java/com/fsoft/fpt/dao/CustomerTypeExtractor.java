package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.CustomerType;

public class CustomerTypeExtractor implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<CustomerType> customerTypes = new ArrayList<CustomerType>();
		while(rs.next()) {
			CustomerType customerType = new CustomerType();
			customerType.setCustomerType(rs.getString("customertype"));
			customerType.setCustomerTypeId(rs.getInt("customertypeid"));
			customerTypes.add(customerType);
		}
		return customerTypes;
	}

}
