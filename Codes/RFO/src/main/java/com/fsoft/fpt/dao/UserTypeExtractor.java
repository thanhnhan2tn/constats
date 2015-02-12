package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.UserType;;

public class UserTypeExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<UserType> userTypes = new ArrayList<UserType>();
		while(rs.next()) {
			UserType userType = new UserType();
			userType.setUserTypeId(rs.getInt("userTypeId"));
			userType.setUserType(rs.getString("userType"));
			userTypes.add(userType);
		}
		return userTypes;
	}

}
