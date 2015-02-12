/*
 * Class name: SalesOrderControllerTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE            AUTHOR                     DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Nguyen Nam Nhi          Create java class file
 */
package com.htqlbh.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

/**
 * The Class SalesOrderControllerTest.
 * 
 * @author Nguyen Nam Nhi
 */
public class SalesOrderControllerTest {
	
	/** The sales order test. */
	private SalesOrderController salesOrderTest;
	
	/**
	 * Test sales order list.
	 */
	@Test
	public void testSalesOrderList() {
		salesOrderTest = new SalesOrderController();
		Assert.assertEquals("hoadonban/order",
				salesOrderTest.SalesOrderList(new ExtendedModelMap()));
	}

	/**
	 * Test add item form.
	 */
	@Test
	public void testAddItemForm() {
		salesOrderTest = new SalesOrderController();
		Assert.assertEquals("hoadonban/newSalesOrder",
				salesOrderTest.addItemForm());
	}

	/**
	 * Test create new order.
	 */
	@Test
	public void testCreateNewOrder() {
		salesOrderTest = new SalesOrderController();
		String expected = salesOrderTest.createNewOrder(new ExtendedModelMap(),
				"1234", "KH01", "2014-3-3", "2014-4-3", "nothing");
		Assert.assertEquals("hoadonban/newSalesOrder", expected);
	}

	/**
	 * Testauto fill item.
	 */
	@Test
	public void testautoFillItem() {
		salesOrderTest = new SalesOrderController();
		String expected = salesOrderTest.autoFillItem("1");
		String result = "{\"custId\": \"1\", \"custName\": \"Nguyen Nam Nhi\" }";

		Assert.assertEquals(result, expected);
	}

}
