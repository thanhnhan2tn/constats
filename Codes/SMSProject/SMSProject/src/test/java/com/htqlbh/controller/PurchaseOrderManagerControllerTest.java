/*
 * Class name: PurchaseOrderManagerControllerTest.java
 * 
 * Version information: 1.0
 *
 * Date: 1-Aug-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE         AUTHOR             DESCRIPTION
 *  --------------------------------------------------------
 *  1-Aug-2014    Nguyen Gia Trang   Test Purchase Order Manager Controller
 */

package com.htqlbh.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

/**
 * The Class PurchaseOrderManagerBO.
 * 
 * @author Nguyen Gia Trang
 */
public class PurchaseOrderManagerControllerTest {

	/**
	 * Test purchase order.
	 */
	@Test
	public void testPurchaseOrder() {
		PurchaseOrderManagerController purchaseController = new PurchaseOrderManagerController();
		Assert.assertEquals("hoadonmua/nhapHD",
				purchaseController.purchaseOrder(new ExtendedModelMap()));
	}

	/**
	 * Test add purchase order.
	 */
	@Test
	public void testAddPurchaseOrder() {
		PurchaseOrderManagerController purchaseController = new PurchaseOrderManagerController();
		Assert.assertEquals("hoadonmua/nhapHD", purchaseController
				.addPurchaseOrder(new ExtendedModelMap(), "Order_95",
						"2014-12-03", 2L, 1L, 15600000L));
	}

	/**
	 * Test purchase order list.
	 */
	@Test
	public void testPurchaseOrderList() {
		PurchaseOrderManagerController purchaseController = new PurchaseOrderManagerController();
		Assert.assertEquals("hoadonmua/dsHD",
				purchaseController.PurchaseOrderList(new ExtendedModelMap()));
	}

	/**
	 * Test distributor payment.
	 */
	@Test
	public void testDistributorPayment() {
		PurchaseOrderManagerController purchaseController = new PurchaseOrderManagerController();
		Assert.assertEquals("hoadonmua/ttNPP",
				purchaseController.DistributorPayment(new ExtendedModelMap()));
	}

	/**
	 * Test add distributor payment.
	 */
	@Test
	public void testAddDistributorPayment() {
		PurchaseOrderManagerController purchaseController = new PurchaseOrderManagerController();
		Assert.assertEquals("hoadonmua/ttNPP", purchaseController
				.addDistributorPayment(new ExtendedModelMap(), "Dis11",
						"2014-1-8", 24000000L));
	}

	/**
	 * Test distributor payment list.
	 */
	@Test
	public void testDistributorPaymentList() {
		PurchaseOrderManagerController purchaseController = new PurchaseOrderManagerController();
		Assert.assertEquals("hoadonmua/dsHDTT", purchaseController
				.DistributorPaymentList(new ExtendedModelMap()));
	}

	/**
	 * Test distributor return product.
	 */
	@Test
	public void testDistributorReturnProduct() {
		PurchaseOrderManagerController purchaseController = new PurchaseOrderManagerController();
		Assert.assertEquals("hoadonmua/nppTraHang", purchaseController
				.DistributorReturnProduct(new ExtendedModelMap()));
	}

}
