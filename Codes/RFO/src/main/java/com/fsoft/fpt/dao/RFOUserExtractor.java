package com.fsoft.fpt.dao;

import java.awt.color.CMMException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.RFOUser;

public class RFOUserExtractor implements ResultSetExtractor {
	@Autowired
	private CompanyDAO companyDAO;

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<RFOUser> rfoUsers = new ArrayList<RFOUser>();
		while (rs.next()) {
			RFOUser rfoUser = new RFOUser();
			rfoUser.setRfoUserId(rs.getInt("rfoUserId"));
			rfoUser.setDealerCode(rs.getString("dealerCode"));
			rfoUser.setTitle(rs.getString("title"));
			rfoUser.setFirstName(rs.getString("firstName"));
			rfoUser.setLastName(rs.getString("lastname"));
			rfoUser.setExtranetUser(rs.getString("extranetUser"));
			rfoUser.setEmailAddress(rs.getString("emailAddress"));
			rfoUser.setUserTypeId(rs.getInt("userTypeId"));
			rfoUser.setContactAdressId(rs.getInt("contactAddressId"));
			rfoUser.setStatus(rs.getString("status"));
			rfoUsers.add(rfoUser);
		}
		return rfoUsers;
	}

}
