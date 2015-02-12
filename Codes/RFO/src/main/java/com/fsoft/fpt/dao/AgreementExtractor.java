package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.Agreement;

;

public class AgreementExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Agreement> Agreements = new ArrayList<Agreement>();
		while (rs.next()) {
			Agreement agreement = new Agreement();
			agreement.setAgreementId(rs.getInt("agreementId"));
			agreement.setAgreementNumber(rs.getInt("agreementNumber"));
			agreement.setVariantNumber(rs.getInt("variantNumber"));
			agreement.setName(rs.getString("name"));
			agreement.setDescription(rs.getString("description"));
			// add startdate by Nhan
			agreement.setStartDate(rs.getDate("startDate").toString());
			// add endDate by Nhan
			agreement.setEndDate(rs.getDate("endDate").toString());

			// changed statuId to statusId by Nhan
			agreement.setStatusId(rs.getInt("statusId"));
			agreement.setAuthorisedBy(rs.getString("authorisedBy"));
			// changed createdBy to createBy by Nhan
			agreement.setCreateBy(rs.getString("createBy"));

			agreement.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
			agreement.setPaymentTo(rs.getString("paymentTo"));
			agreement.setHandlingCharge(rs.getFloat("handlingCharge"));
			agreement.setFundingMethodId(rs.getInt("fundingMethodId"));
			agreement.setCreditNoteText(rs.getString("creditNoteText"));
			agreement.setSignRequired(rs.getInt("signRequired"));
			agreement.setSignReceived(rs.getInt("signReceived"));
			agreement.setDealerVisibility(rs.getString("dealerVisibility"));
			agreement.setCombinability(rs.getString("combinability"));
			agreement.setNumberOfRegistrations(rs.getInt("numberOfRegistrations"));
			agreement.setVolumeId(rs.getInt("volumeId"));
			agreement.setRfoNumberId(rs.getInt("rfoNumberId"));
			agreement.setDiscountUnit(rs.getString("discountUnit"));
			agreement.setJustification(rs.getString("justificationComment"));
			Agreements.add(agreement);
		}
		return Agreements;
	}

}
