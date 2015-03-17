/*
 * Class name: DistributorPayment.java
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
 *  1-Aug-2014    Nguyen Gia Trang    Distributor payment
 */
package com.htqlbh.model;

import java.util.Date;

/**
 * The Class DistributorPayment.
 */
public class DistributorPayment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4680143975432119924L;

	/** The d payment id. */
	private int dPaymentId;

	/** The vendor. */
	private Vendor vendor;

	/** The d payment no. */
	private String dPaymentNo;

	/** The d payment date. */
	private Date dPaymentDate;

	/** The d payment amt. */
	private Long dPaymentAmt;

	/**
	 * The Constructor.
	 */
	public DistributorPayment() {
	}

	/**
	 * Getd payment id.
	 *
	 * @return the d payment id
	 */
	public int getdPaymentId() {
		return dPaymentId;
	}

	/**
	 * Setd payment id.
	 *
	 * @param dPaymentId
	 *            the d payment id
	 */
	public void setdPaymentId(int dPaymentId) {
		this.dPaymentId = dPaymentId;
	}

	/**
	 * Gets the vendor.
	 *
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}

	/**
	 * Sets the vendor.
	 *
	 * @param vendor
	 *            the vendor
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	/**
	 * Getd payment no.
	 *
	 * @return the d payment no
	 */
	public String getdPaymentNo() {
		return dPaymentNo;
	}

	/**
	 * Setd payment no.
	 *
	 * @param dPaymentNo
	 *            the d payment no
	 */
	public void setdPaymentNo(String dPaymentNo) {
		this.dPaymentNo = dPaymentNo;
	}

	/**
	 * Getd payment date.
	 *
	 * @return the d payment date
	 */
	public Date getdPaymentDate() {
		return dPaymentDate;
	}

	/**
	 * Setd payment date.
	 *
	 * @param dPaymentDate
	 *            the d payment date
	 */
	public void setdPaymentDate(Date dPaymentDate) {
		this.dPaymentDate = dPaymentDate;
	}

	/**
	 * Getd payment amt.
	 *
	 * @return the d payment amt
	 */
	public Long getdPaymentAmt() {
		return dPaymentAmt;
	}

	/**
	 * Setd payment amt.
	 *
	 * @param dPaymentAmt
	 *            the d payment amt
	 */
	public void setdPaymentAmt(Long dPaymentAmt) {
		this.dPaymentAmt = dPaymentAmt;
	}

}
