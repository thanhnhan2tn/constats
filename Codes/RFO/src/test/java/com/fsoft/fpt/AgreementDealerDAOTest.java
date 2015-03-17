package com.fsoft.fpt;

import static org.junit.Assert.*;


import java.util.ArrayList;

import javax.sql.DataSource;
 


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.test.context.ContextConfiguration; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.fsoft.fpt.dao.*;

import com.fsoft.fpt.model.AgreementDealer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "servlet-context.xml" })
@TransactionConfiguration(defaultRollback = true)

/**
 * AgreementDealer, testcase for AgreementDealerDAO class
 * @author ThanhNhan
 *
 */
public class AgreementDealerDAOTest {

	@Autowired
	AgreementDealerDAO AgreementDealerDAO = new AgreementDealerDAO();
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	AgreementDealer agr = new AgreementDealer();
	
	/**
	 * Test get CreateAgreementDealer
	 * 
	 */
	@Test
	@Transactional  // Rollback after test
	public void TestCreateAgreementDealer(){
		//Set datasource for jdbcTemplateOb
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		// Count max number row on database
		int initialCount = jdbcTemplateObject.queryForInt("select count(1) from AgreementDealer");
		agr.setAgreementId(1);
		agr.setRfoUserId(1);
		AgreementDealerDAO.create(agr);
		assertEquals(initialCount+1,jdbcTemplateObject.queryForInt("select count(1) from AgreementDealer"));
	}
	
	/**
	 * Test get TestGetAgreementDealer
	 * 
	 */
	@Test
	@Transactional  // Rollback after test
	public void TestGetAgreementDealer(){
		//Set datasource for jdbcTemplateOb
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		// Count max number row on database
		int MaxId = jdbcTemplateObject.queryForInt("SELECT AgreementDealerId "
				+ "FROM AgreementDealer ORDER BY AgreementDealerId DESC LIMIT 1");
		assertNotNull(AgreementDealerDAO.get(MaxId));
	}
	
	@Test
	@Transactional  // Rollback after test
	public void TestGetAgreementDealerEmpty(){
		//Set datasource for jdbcTemplateOb
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		// Count max number row on database
		int MaxId = jdbcTemplateObject.queryForInt("SELECT AgreementDealerId "
				+ "FROM AgreementDealer ORDER BY AgreementDealerId DESC LIMIT 1");
		assertEquals(AgreementDealerDAO.get(MaxId+1).getAgreementDealerId(),0);
	}
	
	@Test
	@Transactional  // Rollback after test
	public void TestListAgreementDealer(){
		//Set datasource for jdbcTemplateOb
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		// Count max number row on database
		int MaxId = jdbcTemplateObject.queryForInt("SELECT AgreementId "
				+ "FROM AgreementDealer ORDER BY AgreementDealerId DESC LIMIT 1");
		assertNotNull(AgreementDealerDAO.get(MaxId));
	}
	
	@Test
	@Transactional  // Rollback after test
	public void TestListAgreementDealerEmpty(){
		//Set datasource for jdbcTemplateOb
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		// Count max number row on database
		int MaxId = jdbcTemplateObject.queryForInt("SELECT AgreementId "
				+ "FROM Agreement ORDER BY AgreementId DESC LIMIT 1");
		assertEquals(AgreementDealerDAO.list(MaxId+1),new ArrayList<Integer>());
	}		
}
