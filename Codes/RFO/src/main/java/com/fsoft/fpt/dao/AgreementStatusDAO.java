package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.AgreementStatus;

public class AgreementStatusDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public AgreementStatusDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public AgreementStatus get(int agreementStatusId) {
		List<AgreementStatus> agreementStatuses = new ArrayList<AgreementStatus>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from AgreementStatus where Statusid = " + agreementStatusId;
		agreementStatuses = (List<AgreementStatus>) jdbcTemplateObject.query(sql, new AgreementStatusExtractor());
		if (agreementStatuses.isEmpty() == true) {
			return new AgreementStatus();
		} else {
			return agreementStatuses.get(0);
		}
	}
	
	public List<AgreementStatus> list() {
		List<AgreementStatus> agreementStatuses = new ArrayList<AgreementStatus>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from AgreementStatus";
		agreementStatuses = (List<AgreementStatus>) jdbcTemplateObject.query(sql, new AgreementStatusExtractor());
		return agreementStatuses;
	}

}
