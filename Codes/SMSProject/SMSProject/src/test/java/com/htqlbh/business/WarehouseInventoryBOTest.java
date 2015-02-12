/*
 * Class name: WarehouseInventoryBOTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *       DATE             AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014     Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.business;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.htqlbh.business.WarehouseInventoryBO;
import com.htqlbh.model.WarehouseInventory;

/**
 * The Class WarehouseInventoryBOTest.
 * 
 * @author: Pham Hoang Dieu
 */
public class WarehouseInventoryBOTest {

	/**
	 * Test warehouse inventory bo.
	 */
	@Test
	public void testWarehouseInventoryBO() {
		WarehouseInventoryBO warehouseInvtBO = new WarehouseInventoryBO();
		Assert.assertNotNull(warehouseInvtBO);
	}

	/**
	 * Test warehouse inventory bo string string string.
	 */
	@Test
	public void testWarehouseInventoryBOStringStringString() {
		WarehouseInventoryBO warehouseInvtBO = new WarehouseInventoryBO("1232",
				"2014-01-02", "1");
		Assert.assertNotNull(warehouseInvtBO);
	}

	/**
	 * Test is empty list.
	 */
	@Test
	public void testIsEmptyList() {
		WarehouseInventoryBO warehouseInvtBO = new WarehouseInventoryBO();
		boolean isEmptyList = warehouseInvtBO.isEmptyList();
//		System.out.println(isEmptyList);
		Assert.assertFalse(isEmptyList);
	}

	/**
	 * Test get list.
	 */
	@Test
	public void testGetList() {
		WarehouseInventoryBO warehouseInvtBO = new WarehouseInventoryBO();
		ArrayList<WarehouseInventory> list = warehouseInvtBO.getList();
		Assert.assertNotNull(list);
	}

	/**
	 * Test add.
	 */
	@Test
	public void testAdd() {
		WarehouseInventoryBO warehouseInvtBO = new WarehouseInventoryBO();
		warehouseInvtBO.setwInventoryNo("1234");
		warehouseInvtBO.setwInventoryDate("2012-11-22");
		warehouseInvtBO.setStock("1");
		String result = warehouseInvtBO.add();
		Assert.assertEquals("added", result);
	}
}
