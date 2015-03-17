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
@TransactionConfiguration(defaultRollback = true)
/**
 * AccountDATTAddressDAOTestest, testcase for AddressDAOTest class
 * @author ThanhNhan
 *
 */
public class AddressDAOTest {

	@Autowired
	AddressDAO AddressDAO = new AddressDAO();
	
	//Test get country
	@Test
	public void TestGetCountry(){
		assertNotNull(AddressDAO.get(1).getCountry());
	}
	@Test
	public void TestGetId(){
		assertNotNull(AddressDAO.get(1).getAddressId());
	}
	@Test
	public void TestGetEmpty(){
		assertEquals(AddressDAO.get(-1).getCountry(),null);
	}
}
