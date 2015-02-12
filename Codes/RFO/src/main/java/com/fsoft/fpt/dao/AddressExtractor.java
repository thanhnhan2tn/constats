package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.Address;

;

public class AddressExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Address> addresses = new ArrayList<Address>();
		while (rs.next()) {
			Address address = new Address();
			address.setAddressId(rs.getInt("addressid"));
			address.setAddress1(rs.getString("address1"));
			address.setAddress2(rs.getString("address2"));
			address.setAddress3(rs.getString("address3"));
			address.setAddress4(rs.getString("address4"));
			address.setAddress5(rs.getString("address5"));
			address.setCity(rs.getString("city"));
			address.setState(rs.getString("state"));
			address.setCountry(rs.getString("country"));
			address.setPostcode(rs.getString("postcode"));
			addresses.add(address);
		}
		return addresses;
	}

}