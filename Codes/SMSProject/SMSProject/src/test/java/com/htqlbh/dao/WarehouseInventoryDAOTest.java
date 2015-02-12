/*
 * Class name: WarehouseInventoryDAOTest
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
 *  1-August-2014    Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.htqlbh.dao.WarehouseInventoryDAO;
import com.htqlbh.model.Stock;
import com.htqlbh.model.WarehouseInventory;

/**
 * The Class WarehouseInventoryDAOTest.
 * 
 * @author Pham Hoang Dieu
 */
public class WarehouseInventoryDAOTest {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(InventoryDAO.class);
	
	/**
	 * Test list.
	 */
	@Test
	public void testList() {
		WarehouseInventoryDAO obj = new WarehouseInventoryDAO();
		ArrayList<WarehouseInventory> list = (ArrayList<WarehouseInventory>) obj.list();
		String[] arr = new String[3];
		arr[0] = list.iterator().next().getwInventoryNo();
		arr[1] = list.iterator().next().getwInventoryDate().toString();
		arr[2] = list.iterator().next().getStock().getStockId();
		
		String[] sample = {"123", "2013-01-01", "1"};
		Assert.assertArrayEquals(sample, arr);
		
		String[] sample1 = {"140123", "2014-01-02", "5"};
		Assert.assertNotSame(sample1, arr);
		
		logger.info("Test list() done");
	}

	/**
	 * Test add.
	 *
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testAdd() throws ParseException {
		WarehouseInventoryDAO obj = new WarehouseInventoryDAO();
		WarehouseInventory warehouseInvt = new WarehouseInventory();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2013-03-21");
		Stock stock = new Stock();
		stock.setStockId("1");

		warehouseInvt.setwInventoryNo("3125");
		warehouseInvt.setwInventoryDate(date);
		warehouseInvt.setStock(stock);
		
		String result = obj.add(warehouseInvt);
		Assert.assertEquals("success", result);
		
		logger.info("Test add() done");
	}

}
