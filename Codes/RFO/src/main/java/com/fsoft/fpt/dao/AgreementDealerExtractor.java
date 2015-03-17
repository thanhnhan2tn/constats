package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.AgreementDealer;

	/**
	 * AgreementDealerExtractor ResultSet to List<AgreementDealer>
	 * @author ThanhNhan
	 *
	 */
public class AgreementDealerExtractor implements ResultSetExtractor {
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<AgreementDealer> agreementDealers = new ArrayList<AgreementDealer>();
		while (rs.next()) {
			AgreementDealer agreementDealer = new AgreementDealer();
			agreementDealer.setAgreementDealerId(rs.getInt("agreementDealerId"));
			agreementDealer.setAgreementId(rs.getInt("agreementId"));
			agreementDealer.setRfoUserId(rs.getInt("rfoUserId"));
			agreementDealers.add(agreementDealer);
		}
		return agreementDealers;
	}
}
