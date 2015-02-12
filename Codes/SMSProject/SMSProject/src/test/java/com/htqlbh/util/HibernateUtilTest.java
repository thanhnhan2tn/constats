/*
 * Class name: HibernateUtilTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE            AUTHOR                     DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Tran Trong Nghia         Create java class file
 */

package com.htqlbh.util;

import org.hibernate.Session;
import org.junit.Test;

/**
 * @author Tran Trong Nghia
 * 
 */
public class HibernateUtilTest {

	/**
	 * Test method for {@link com.htqlbh.util.HibernateUtil#openSession()}.
	 */
	@Test
	public void testOpenSession() {
		assert HibernateUtil.openSession().getClass().equals(Session.class);
	}

}
