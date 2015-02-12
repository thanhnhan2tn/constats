/*
 * Class name: DistributorPaymentDaoTest.java
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
 *  1-Aug-2014    Nguyen Gia Trang    Test Distributor Payment Dao
 */
package com.htqlbh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.htqlbh.model.DistributorPayment;

/**
 * The Class PurchaseOrderManagerBO.
 * 
 * @author Nguyen Gia Trang
 */
@ContextConfiguration(locations = { "classpath:DistributorPayment.hbm.xml",
		"classpath: servlet-context.xml" })
// @TransactionConfiguration(defaultRollback = true)
public class DistributorPaymentDaoTest {

	/** The dao. */
	DistributorPaymentDao dao = new DistributorPaymentDao();

	/**
	 * Test get list distritor payment.
	 */
	@Test
	public void testGetListDistritorPayment() {
		dao.getListDistritorPayment();
	}

	/**
	 * Test add distributor payment.
	 */
	@Test
	public void testAddDistributorPayment() {
		DistributorPayment distributorPayment = new DistributorPayment();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();
		try {
			date = sdf.parse("2014-3-8");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		distributorPayment.setdPaymentNo("Dis07");
		distributorPayment.setdPaymentDate(date);
		distributorPayment.setdPaymentAmt((long) 150000000);
		dao.addDistributorPayment(distributorPayment);
	}

}
