package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.AgreementDealer;

/**
 * AgreementDealerDAO,
 * 
 * @author ThanhNhan, Work from database with AgreementDealer table
 */
public class AgreementDealerDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public AgreementDealerDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public AgreementDealer create(AgreementDealer agreementDealer) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "insert into agreementdealer values (null, ?, ?)";
		jdbcTemplateObject.update(sql, agreementDealer.getRfoUserId(),
				agreementDealer.getAgreementId());
		int agreementDealerId = jdbcTemplateObject
				.queryForInt("select max(agreementdealerid) from agreementdealer");
		agreementDealer.setAgreementDealerId(agreementDealerId);
		return agreementDealer;
	}

	/**
	 * @author Luong Duc Duy
	 * @param agreementDealerId
	 * @return get agreementDealer by agreementDealerId
	 */
	@SuppressWarnings("unchecked")
	public AgreementDealer get(int agreementDealerId) {
		List<AgreementDealer> agreementDealer = new ArrayList<AgreementDealer>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from AgreementDealer where agreementdealerId = "
				+ agreementDealerId;
		agreementDealer = jdbcTemplateObject.query(sql,
				new AgreementDealerExtractor());
		if (agreementDealer.isEmpty() == true) {
			return new AgreementDealer();
		} else {
			return agreementDealer.get(0);
		}
	}

	/**
	 * @author Luong Duc Duy TODO List all agreement dealer by agreeementid
	 */
	public List<AgreementDealer> list(int agreementId) {
		List<AgreementDealer> agreementDealers = new ArrayList<AgreementDealer>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from AgreementDealer where agreementId = "
				+ agreementId;
		agreementDealers = jdbcTemplateObject.query(sql,
				new AgreementDealerExtractor());
		return agreementDealers;

	}

	/**
	 * @author Luong Duc Duy TODO Delete all agreementDealer by agreementId
	 */
	public void delete(int agreementId) {
		List<AgreementDealer> agreementDealers = new ArrayList<AgreementDealer>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "delete from AgreementDealer where agreementId = ?";
		jdbcTemplateObject.update(sql, new Object[] { agreementId });
	}
}
