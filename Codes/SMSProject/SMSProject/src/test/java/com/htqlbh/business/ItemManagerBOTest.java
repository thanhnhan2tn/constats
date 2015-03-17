/*
 * Class name: ItemManagerBOTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE              AUTHOR                      DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Tran Trong Nghia          Create java class file
 */

package com.htqlbh.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class ItemManagerBOTest.
 *
 * @author Tran Trong Nghia
 */
public class ItemManagerBOTest {

    /** The item manager. */
    private ItemManagerBO itemManager;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
	itemManager = new ItemManagerBO();
    }

    /**
     * Test method for {@link com.htqlbh.business.ItemManagerBO#getItemList()}.
     */
    @Test
    public void testGetItemList() {
	System.out.println(itemManager.getItemList().size());
	assertTrue(itemManager.getItemList().size() == 8);
    }

    /**
     * Test method for
     * {@link com.htqlbh.business.ItemManagerBO#addItem(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long)}
     * .
     */
    @Test
    public void testAddItem() {
	int n = itemManager.getItemList().size();
	itemManager
		.addItem("testid", "testname", "testclass", "testunitT", 123,
			new Long(123), "TestUnitL", new Long(234), new Long(
				12345));
	assertTrue((n + 1) == itemManager.getItemList().size());
    }

    /**
     * Test method for
     * {@link com.htqlbh.business.ItemManagerBO#deleteItem(java.lang.String)}.
     */
    @Test
    public void testDeleteItem() {
	int n = itemManager.getItemList().size();
	itemManager.deleteItem("test");
	assertTrue(n == itemManager.getItemList().size());
	itemManager.deleteItem("testid");
	assertTrue((n - 1) == itemManager.getItemList().size());

    }

    /**
     * Test method for
     * {@link com.htqlbh.business.ItemManagerBO#getJSONItemById(java.lang.String)}
     * .
     */
    @Test
    public void testGetJSONItemById() {
	assertEquals(
		itemManager.getJSONItemById("4InviId1"),
		"{\"invtId\": \"4InviId1\", \"invtName\": \"2Inventory Name\", \"className\": \"Class Nam3e\", \"unitT\": \"lon\", \"unitRate\": \"100\", \"salesPriceT\": \"155\", \"unitL\": \"thung\", \"salesPriceL\": \"122\", \"slsTax\": \"10\"}");
    }
}
