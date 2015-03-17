package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.FundingMethod;;

public class FundingMethodExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<FundingMethod> fundingMethods = new ArrayList<FundingMethod>();
		while(rs.next()) {
			FundingMethod fundingMethod = new FundingMethod();
			fundingMethod.setFundingMethodId(rs.getInt("fundingMethodId"));
			fundingMethod.setFundingMethodName(rs.getString("fundingMethodName"));
			fundingMethod.setFundingType(rs.getString("fundingType"));
			fundingMethod.setContractTemplateLocation(rs.getInt("contractTemplateLocation"));
			fundingMethod.setSignedContractDefult(rs.getInt("signedContractDefault"));
			fundingMethod.setStatus(rs.getString("status"));
			fundingMethods.add(fundingMethod);
		}
		return fundingMethods;
	}

}
