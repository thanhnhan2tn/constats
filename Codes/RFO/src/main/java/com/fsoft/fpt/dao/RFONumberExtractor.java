package com.fsoft.fpt.dao;

import java.awt.color.CMMException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.Address;
import com.fsoft.fpt.model.Company;
import com.fsoft.fpt.model.CustomerType;
import com.fsoft.fpt.model.RFONumber;

public class RFONumberExtractor implements ResultSetExtractor {
	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<RFONumber> rfoNumbers = new ArrayList<RFONumber>();
		while(rs.next()) {
			RFONumber rfoNumber = new RFONumber();
			rfoNumber.setRFONumberId(rs.getInt("rfonumberid"));
			rfoNumber.setRFONumber(rs.getString("rfonumber"));
			rfoNumber.setRFOName(rs.getString("rfoname"));
			rfoNumber.setCustomerTypeId(rs.getInt("customertypeid"));
			rfoNumber.setCompanyId(rs.getInt("companyid"));
			rfoNumber.setCreatedBy(rs.getString("createdby"));
			rfoNumber.setUpdatedBy(rs.getString("updatedby"));
			rfoNumber.setPostCode(rs.getString("postcode"));
			rfoNumbers.add(rfoNumber);
		}
		return rfoNumbers;
	}

}
