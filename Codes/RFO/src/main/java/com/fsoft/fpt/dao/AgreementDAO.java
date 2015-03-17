package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.Agreement;
import com.fsoft.fpt.model.AgreementStatus;
import com.fsoft.fpt.model.Banding;
import com.fsoft.fpt.model.RFONumber;
import com.fsoft.fpt.model.Volume;

public class AgreementDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	@Autowired
	private RFONumberDAO rfoNumberDAO;
	@Autowired
	private VolumeDAO volumeDAO;
	@Autowired
	private BandingDAO bandingDAO;
	@Autowired
	private AgreementStatusDAO agreementStatusDAO;

	/**
	 * 
	 */
	public AgreementDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Agreement create(Agreement agreement, List<Banding> bandings) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		// Add new volume
		Volume volume = agreement.getVolume();
		volume = volumeDAO.create(volume);
		agreement.setVolumeId(volume.getVolumeId());
		agreement.setVolume(volume);

		// Add banding
		for (int i = 0; i < bandings.size(); i++) {
			Banding banding = bandings.get(i);
			banding.setVolumeId(volume.getVolumeId());
			bandingDAO.create(banding);
		}
		String sql = "insert into agreement value(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplateObject.update(
				sql,
				new Object[] { agreement.getAgreementNumber(),
						agreement.getVariantNumber(), agreement.getName(),
						agreement.getDescription(), agreement.getStartDate(),
						agreement.getEndDate(), agreement.getStatusId(),
						agreement.getLastStatusUpdateDate(),
						agreement.getAuthorisedBy(),
						agreement.getAuthorisedDate(),
						agreement.getCreateDate(), agreement.getCreateBy(),
						agreement.getLastUpdatedDate(),
						agreement.getLastUpdatedBy(), agreement.getPaymentTo(),
						agreement.getHandlingCharge(),
						agreement.getFundingMethodId(),
						agreement.getCreditNoteText(),
						agreement.getSignRequired(),
						agreement.getSignReceived(),
						agreement.getSignReceivedDate(),
						agreement.getDealerVisibility(),
						agreement.getCombinability(),
						agreement.getNumberOfRegistrations(),
						agreement.getVolumeId(), agreement.getRfoNumberId(),
						agreement.getDiscountUnit(),
						agreement.getJustification() });
		int agreementId = jdbcTemplateObject
				.queryForInt("select max(agreementid) from agreement");
		agreement.setAgreementId(agreementId);
		return agreement;
	}
	
	/**
	 * @author Luong Duc Duy
	 * @param agreementId
	 * @return
	 */
	public Agreement update(Agreement agreement, List<Banding> bandings) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		// Update volume
		Volume volume = agreement.getVolume();
		volumeDAO.update(volume);
		System.out.println("Volume id = " + volume.getVolumeId());
		// Update banding
		//  Delete all old banding
		bandingDAO.delete(volume.getVolumeId());
		//  Create new banding
		for (int i = 0; i < bandings.size(); i++) {
			Banding banding = bandings.get(i);
			banding.setVolumeId(volume.getVolumeId());
			bandingDAO.create(banding);
		}
		
		String sql = "update agreement set agreementNumber = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getAgreementNumber(), agreement.getAgreementId()});
		
		sql = "update agreement set VariantNumber = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getVariantNumber(), agreement.getAgreementId()});
		
		sql = "update agreement set name = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getName(), agreement.getAgreementId()});
		
		sql = "update agreement set Description = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getDescription(), agreement.getAgreementId()});
		
		sql = "update agreement set StartDate = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getStartDate(), agreement.getAgreementId()});
		
		sql = "update agreement set EndDate = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getEndDate(), agreement.getAgreementId()});
		
		sql = "update agreement set StatusId = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getStatusId(), agreement.getAgreementId()});
		
		sql = "update agreement set LastStatusUpdatedDate = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getLastStatusUpdateDate(), agreement.getAgreementId()});
		
		sql = "update agreement set AUTHORISEDBY = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getAuthorisedBy(), agreement.getAgreementId()});
		
		sql = "update agreement set AuthorisedDate = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getAuthorisedDate(), agreement.getAgreementId()});
		
		sql = "update agreement set CreateDate = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getCreateDate(), agreement.getAgreementId()});
		
		sql = "update agreement set CreateBy = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getCreateBy(), agreement.getAgreementId()});
		
		sql = "update agreement set LastUpdatedDate = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getLastUpdatedDate(), agreement.getAgreementId()});
		
		sql = "update agreement set PaymentTo = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getPaymentTo(), agreement.getAgreementId()});
		
		sql = "update agreement set HandlingCharge = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getHandlingCharge(), agreement.getAgreementId()});
		
		sql = "update agreement set FundingMethodId = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getFundingMethodId(), agreement.getAgreementId()});
		
		sql = "update agreement set CreditNoteText = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getCreditNoteText(), agreement.getAgreementId()});
		
		sql = "update agreement set SignRequired = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getSignRequired(), agreement.getAgreementId()});
		
		sql = "update agreement set SignReceived = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getSignReceived(), agreement.getAgreementId()});
		
		sql = "update agreement set SignReceivedDate = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getSignReceivedDate(), agreement.getAgreementId()});
		
		sql = "update agreement set DealerVisibility = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getDealerVisibility(), agreement.getAgreementId()});
		
		sql = "update agreement set Combinability = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getCombinability(), agreement.getAgreementId()});
		
		sql = "update agreement set NumberOfRegistrations = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getNumberOfRegistrations(), agreement.getAgreementId()});
		
		sql = "update agreement set VolumeId = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getVolumeId(), agreement.getAgreementId()});
		
		sql = "update agreement set RfoNumberId = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getRfoNumberId(), agreement.getAgreementId()});
		
		sql = "update agreement set DiscountUnit = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getDiscountUnit(), agreement.getAgreementId()});
		
		sql = "update agreement set JUSTIFICATIONCOMMENT = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[]{ agreement.getJustification(), agreement.getAgreementId()});
		
		return agreement;
	}

	public Agreement get(int agreementId) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<Agreement> agreements = new ArrayList<Agreement>();

		String sql = "select * from agreement where agreementid = "
				+ agreementId;
		agreements = jdbcTemplateObject.query(sql, new AgreementExtractor());
		agreements = extractAllComponentAgreement(agreements);
		if (agreements.isEmpty() == true) {
			return new Agreement();
		} else {
			return agreements.get(0);
		}
	}

	/**
	 * @author Luong Duc Duy
	 * @return
	 */
	public List<Agreement> list() {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<Agreement> agreements = new ArrayList<Agreement>();

		String sql = "select * from agreement";
		agreements = jdbcTemplateObject.query(sql, new AgreementExtractor());
		agreements = extractAllComponentAgreement(agreements);
		return agreements;
	}

	/**
	 * @author Luong Duc Duy TODO search agreement by condition
	 */

	public List<Agreement> search(String customerTypeId, String name,
			String rfoNumber, String postCode, String statusId,
			String startDate, String endDate, String agreementNumber) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from agreement as a inner join rfonumber as b on a.rfoNumberId = b.rfoNumberId inner join customerType as c on b.customerTypeId = c.customerTypeId ";
		List<Agreement> agreements = new ArrayList<Agreement>();
		boolean flag = false;
		if (customerTypeId.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			}
			sql += " c.customerTypeId = " + customerTypeId + "";
		}
		if (name.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " rfoName like '%" + name + "%'";
		}
		if (rfoNumber.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " rfoNumber like '%" + rfoNumber + "%'";
		}
		if (postCode.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " postCode like '%" + postCode + "%'";
		}
		if (statusId.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " statusId = " + statusId;
		}
		if (agreementNumber.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " agreementNumber = " + agreementNumber;
		}
		if (startDate.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " startDate >= '" + startDate + "'";
		}
		if (endDate.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " endDate <= '" + endDate + "'";
		}
		System.out.println("Query = " + sql);
		agreements = jdbcTemplateObject.query(sql, new AgreementExtractor());
		agreements = extractAllComponentAgreement(agreements);
		return agreements;
	}

	/**
	 * @author Luong Duc Duy
	 * @return a list of full component of agreement
	 */
	public List<Agreement> extractAllComponentAgreement(
			List<Agreement> agreements) {
		for (int i = 0; i < agreements.size(); i++) {
			RFONumber rfoNumber1 = rfoNumberDAO.get(agreements.get(i)
					.getRfoNumberId());
			agreements.get(i).setRfoNumber(rfoNumber1);
			/*
			 * @author: Huynh Thanh Nha
			 */
			AgreementStatus agreementStatus = agreementStatusDAO.get(agreements
					.get(i).getStatusId());
			agreements.get(i).setAgreementStatus(agreementStatus);
			/**
			 * @author Luong Duc Duy
			 * TODO get Volume
			 */
			System.out.println("Agreement volume id = " + agreements.get(i).getVolumeId());
			Volume volume = volumeDAO.get(agreements.get(i).getVolumeId());
			agreements.get(i).setVolume(volume);
		}
		return agreements;
	}

	/**
	 * @author Luong Duc Duy
	 * @return
	 */
	public int getMaxAgreementNumber() {
		int result = 0;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select max(agreementNumber) from agreement";
		result = jdbcTemplateObject.queryForInt(sql);
		return result;
	}
	/**
	 * @author Luong Duc Duy
	 * @return
	 */
	public int getMaxVariantNumber() {
		int result = 0;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select max(variantNumber) from agreement";
		result = jdbcTemplateObject.queryForInt(sql);
		return result;
	}

	/**
	 * @author Luong Duc Duy
	 * @return max agreementID
	 */
	public int getMaxAgreementId() {
		int result = 0;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select max(agreementId) from agreement";
		result = jdbcTemplateObject.queryForInt(sql);
		return result;
	}
	
	/**
	 * @author Luong Duc Duy
	 * TODO Count agreement by status
	 */
	public int count(int statusId){
		int result = 0;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select count(*) from agreement where statusid = ?";
		result = jdbcTemplateObject.queryForInt(sql, statusId);
		return result;
	}

	/**
	 * @author: Huynh Thanh Nha TODO Method update Agreement status
	 */
	public void updateStatus(int agreementId, int statusId) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "update Agreement set statusId = ? where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[] { statusId, agreementId });
	}

	/**
	 * extend for UC Extend an Agreement
	 * 
	 * @author ThanhNhan
	 * @param agreementId
	 * @param endDate
	 * @param variantNumber
	 * @return
	 */
	public int extend(int agreementId, String startDate, String endDate,
			int variantNumber) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "UPDATE agreement SET VARIANTNUMBER = ?, STARTDATE = ?, ENDDATE = ?, STATUSID = 1 WHERE AGREEMENTID = ?;";
		jdbcTemplateObject.update(sql, new Object[] { variantNumber, startDate,
				endDate, agreementId });
		return agreementId;
	}
}
