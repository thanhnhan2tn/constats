/*
 * Class name: PurchaseOrderDAOTest.java
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
 *  1-Aug-2014    Nguyen Gia Trang   Test Purchase Order Manager Dao
 */

package com.htqlbh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.htqlbh.model.PurchaseOrder;

/**
 * The Class PurchaseOrderManagerBO.
 * 
 * @author Nguyen Gia Trang
 */
@ContextConfiguration(locations = { "classpath:PurchaseOrder.hbm.xml",
		"classpath: servlet-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class PurchaseOrderDAOTest {

	/** The dao. */
	PurchaseOrderDAO dao = new PurchaseOrderDAO();

	/**
	 * Test get list purchase order.
	 */
	@Test
	@Transactional
	public void testGetListPurchaseOrder() {
		@SuppressWarnings("unused")
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		dao.getListPurchaseOrder();
	}

	/**
	 * Test add purchase order.
	 */
	@Test
	@Transactional
	public void testAddPurchaseOrder() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();
		try {
			date = sdf.parse("2014-2-20");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		purchaseOrder.setOrderNo("Order_12");
		purchaseOrder.setOrderDate(date);
		purchaseOrder.setDiscAmt((long) 5);
		purchaseOrder.setTaxAmt((long) 3);
		purchaseOrder.setTotalAmt((long) 80000000);
		dao.addPurchaseOrder(purchaseOrder);

	}
}
