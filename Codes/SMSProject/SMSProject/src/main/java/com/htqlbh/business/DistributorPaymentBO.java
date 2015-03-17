/*
 * Class name: DistributorPaymentBO.java
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
 *  1-Aug-2014    Nguyen Gia Trang   Distributor payment business
 */
package com.htqlbh.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.htqlbh.dao.DistributorPaymentDao;
import com.htqlbh.model.DistributorPayment;

/**
 * The Class DistributorPaymentBO.
 * 
 * @author Nguyen Gia Trang
 */
public class DistributorPaymentBO {

	/** The distributor payment dao. */
	private DistributorPaymentDao distributorPaymentDao;

	/** The d payment no. */
	private String dPaymentNo;

	/** The d payment date. */
	private String dPaymentDate;

	/** The d payment amt. */
	private Long dPaymentAmt;

	/**
	 * The Constructor.
	 */
	public DistributorPaymentBO() {
		distributorPaymentDao = new DistributorPaymentDao();
	}

	/**
	 * Gets the distributor payment list.
	 *
	 * @return the distributor payment list
	 */
	public ArrayList<DistributorPayment> getDistributorPaymentList() {
		return (ArrayList<DistributorPayment>) distributorPaymentDao
				.getListDistritorPayment();
	}

	/**
	 * The Constructor.
	 *
	 * @param dPaymentNo
	 *            the d payment no
	 * @param dPaymentDate
	 *            the d payment date
	 * @param dPaymentAmt
	 *            the d payment amt
	 */
	public DistributorPaymentBO(String dPaymentNo, String dPaymentDate,
			Long dPaymentAmt) {
		distributorPaymentDao = new DistributorPaymentDao();
		this.dPaymentNo = dPaymentNo;
		this.dPaymentDate = dPaymentDate;
		this.dPaymentAmt = dPaymentAmt;
	}

	/**
	 * Adds the distributor payment.
	 */
	public void addDistributorPayment() {
		DistributorPayment distributorPayment = new DistributorPayment();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();
		try {
			date = sdf.parse(dPaymentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		distributorPayment.setdPaymentNo(dPaymentNo);
		distributorPayment.setdPaymentDate(date);
		distributorPayment.setdPaymentAmt(dPaymentAmt);
		distributorPaymentDao.addDistributorPayment(distributorPayment);
	}

}
