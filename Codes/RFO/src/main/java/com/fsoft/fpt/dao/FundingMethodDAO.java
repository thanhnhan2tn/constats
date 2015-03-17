package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.FundingMethod;

public class FundingMethodDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public FundingMethodDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public FundingMethod get(int fundingMethodId) {
		List<FundingMethod> fundingMethods = new ArrayList<FundingMethod>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from FundingMethod where FundingMethodid = "
				+ fundingMethodId;
		fundingMethods = jdbcTemplateObject.query(sql,
				new FundingMethodExtractor());
		if (fundingMethods.isEmpty() == true) {
			return new FundingMethod();
		} else {
			return fundingMethods.get(0);
		}

	}

	public List<FundingMethod> list() {
		List<FundingMethod> fundingMethods = new ArrayList<FundingMethod>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from FundingMethod";
		fundingMethods = jdbcTemplateObject.query(sql,
				new FundingMethodExtractor());
		return fundingMethods;
	}

}
