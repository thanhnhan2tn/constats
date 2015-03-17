/*
 * Class name: UserDAOTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE             AUTHOR                     DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Tran Trong Nghia          Create java class file
 */

package com.htqlbh.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.htqlbh.model.User;

/**
 * The Class UserDAOTest.
 *
 * @author Tran Trong Nghia
 */
public class UserDAOTest {

	/** The user dao. */
	UserDAO userDao;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		userDao = new UserDAO();
	}

	/**
	 * Test method for
	 * {@link com.htqlbh.dao.UserDAO#findByUserName(java.lang.String)}.
	 */
	@Test
	public void testFindByUserName() {
		assertTrue(userDao.findByUserName("nghia").getClass()
				.equals(User.class));
		assertTrue(userDao.findByUserName("1234") == null);
		assertTrue(userDao.findByUserName(null) == null);
	}
}
