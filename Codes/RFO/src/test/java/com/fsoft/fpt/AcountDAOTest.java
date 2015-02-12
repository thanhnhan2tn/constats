package com.fsoft.fpt;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import com.fsoft.fpt.dao.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "servlet-context.xml" })
@TransactionConfiguration(defaultRollback = false)
/**
 * AccountDATTest, testcase for AccountDAO class
 * @author ThanhNhan
 *
 */
public class AcountDAOTest {

	@Autowired
	AccountDAO AccountDAO = new AccountDAO();
	
	//Test true account and password
	@Test
	public void testcheckTrue() {
		assertTrue(AccountDAO.check("admin", "admin"));
	}
	
	//Test False password
	@Test
	public void testcheckFalsePass() {
		assertFalse(AccountDAO.check("admin", "anyPass"));
	}
	
	//Test false account 
	@Test
	public void testcheckFalseUsername() {
		assertFalse(AccountDAO.check("anyUser", "admin"));
	}
	
	//Test false account and password
	@Test
	public void testcheckFalseUsernameAndPass() {
		assertFalse(AccountDAO.check("anyUser", "anyPass"));
	}
	
	//Test symbol input
	@Test
	public void testcheckSymbol_1() {
		assertFalse(AccountDAO.check("admin", "' or '1 = 1"));
	}
	
	//Test symbol input
		@Test
		public void testcheckSymbol_2() {
			assertFalse(AccountDAO.check("'admin' or 1=1 -- ", "1111"));
		}
}
