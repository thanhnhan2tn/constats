/*
 * Class name: UnitDAOTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE               AUTHOR                    DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Tran Trong Nghia          Create java class file
 */
package com.htqlbh.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.htqlbh.model.Unit;

/**
 * The Class UnitDAOTest.
 *
 * @author Tran Trong Nghia
 */
public class UnitDAOTest {

    /** The unit dao. */
    UnitDAO unitDao;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
	unitDao = new UnitDAO();
    }

    /**
     * Test method for
     * {@link com.htqlbh.dao.UnitDAO#getFristByUnitName(java.lang.String)}.
     */
    @Test
    public void testGetFristByUnitName() {
	assertEquals(unitDao.getFristByUnitName("thung").getClass(), Unit.class);
	assertTrue(unitDao.getFristByUnitName(null) == null);
    }

}
