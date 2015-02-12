/*
 * Class name: InventoryDAOTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE              AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014   Tran Trong Nghia          Create java class file
 */

package com.htqlbh.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.htqlbh.model.Inventory;

/**
 * The Class InventoryDAOTest.
 * 
 * @author Tran Trong Nghia
 */
public class InventoryDAOTest {

    /** The inventory dao. */
    private InventoryDAO inventoryDao;

    /**
     * Sets the up.
     * 
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp() throws Exception {
	inventoryDao = new InventoryDAO();
    }

    /**
     * Test method for {@link com.htqlbh.dao.InventoryDAO#getListItem()}.
     */
    @Test
    public void testGetListItem() {
	assertTrue(inventoryDao.getListItem().size() == 8);
    }

    /**
     * Test method for
     * {@link com.htqlbh.dao.InventoryDAO#findById(java.lang.String)}.
     */
    @Test
    public void testFindById() {
	assertTrue(inventoryDao.findById("5InviId1").getClass() == Inventory.class);
	assertTrue(inventoryDao.findById("testId") == null);

    }

}
