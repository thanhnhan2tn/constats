package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.AgreementStatus;;

public class AgreementStatusExtractor implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<AgreementStatus> agreementStatuses = new ArrayList<AgreementStatus>();
		while(rs.next()) {
			AgreementStatus agreementStatus = new AgreementStatus();
			agreementStatus.setStatusId(rs.getInt("statusId"));
			agreementStatus.setStatus(rs.getString("status"));
			agreementStatuses.add(agreementStatus);
		}
		return agreementStatuses;
	}

}
