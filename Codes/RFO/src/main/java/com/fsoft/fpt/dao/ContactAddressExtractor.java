package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.ContactAddress;;

public class ContactAddressExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<ContactAddress> contactAddresses = new ArrayList<ContactAddress>();
		while(rs.next()) {
			ContactAddress contactAddress = new ContactAddress();
			contactAddress.setContactAddressId(rs.getInt("ContactAddressid"));
			contactAddress.setAddress1(rs.getString("Address1"));
			contactAddress.setAddress2(rs.getString("Address2"));
			contactAddress.setAddress3(rs.getString("Address3"));
			contactAddress.setCountry(rs.getString("country"));
			contactAddress.setPostcode(rs.getString("postcode"));
			contactAddress.setCounty(rs.getString("county"));
			contactAddress.setMobileNo(rs.getString("mobileNo"));
			contactAddress.setFaxNo(rs.getString("faxNo"));
			contactAddress.setAddress1(rs.getString("officeNo"));
			contactAddresses.add(contactAddress);
		}
		return contactAddresses;
	}

}
