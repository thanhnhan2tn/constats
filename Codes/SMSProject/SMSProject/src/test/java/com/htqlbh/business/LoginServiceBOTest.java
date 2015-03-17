/*
 * Class name: LoginServiceBOTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE             AUTHOR                    DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Tran Trong Nghia         Create java class file
 */
package com.htqlbh.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class LoginServiceBOTest.
 *
 * @author Tran Trong Nghia
 */
public class LoginServiceBOTest {

	/** The login service bo. */
	LoginServiceBO loginServiceBO;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		loginServiceBO = new LoginServiceBO();
	}

	/**
	 * Test method for
	 * {@link com.htqlbh.business.LoginServiceBO#validateUser(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testValidateUser() {
		assertTrue(loginServiceBO.validateUser("nghia", "nghia"));
		assertFalse(loginServiceBO.validateUser("nghia", "testabc"));
		assertFalse(loginServiceBO.validateUser("nghia", null));
		assertFalse(loginServiceBO.validateUser("1234", "nghia"));
		assertFalse(loginServiceBO.validateUser("1234", "testabc"));
		assertFalse(loginServiceBO.validateUser(null, "nghia"));
	}

}
