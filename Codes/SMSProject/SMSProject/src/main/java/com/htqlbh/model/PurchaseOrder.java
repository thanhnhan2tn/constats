/*
 * Class name: PurchaseOrder.java
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
 *  1-Aug-2014    Nguyen Gia Trang     Purchase order
 */
package com.htqlbh.model;

// 

import java.util.HashSet;
import java.util.Set;

/**
 * The Class PurchaseOrder.
 */
public class PurchaseOrder extends Order implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The vendor. */
	private Vendor vendor;

	/** The order type. */
	private String orderType;

	/** The disc amt. */
	private Long discAmt;

	/** The prom amt. */
	private Long promAmt;

	/** The com amt. */
	private Long comAmt;

	/** The purchase ord details. */
	private Set<PurchaseOrdDetail> purchaseOrdDetails = new HashSet<PurchaseOrdDetail>(
			0);

	/**
	 * The Constructor.
	 */
	public PurchaseOrder() {
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
	 * Gets the order type.
	 *
	 * @return the order type
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * Sets the order type.
	 *
	 * @param orderType
	 *            the order type
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * Gets the disc amt.
	 *
	 * @return the disc amt
	 */
	public Long getDiscAmt() {
		return discAmt;
	}

	/**
	 * Sets the disc amt.
	 *
	 * @param discAmt
	 *            the disc amt
	 */
	public void setDiscAmt(Long discAmt) {
		this.discAmt = discAmt;
	}

	/**
	 * Gets the prom amt.
	 *
	 * @return the prom amt
	 */
	public Long getPromAmt() {
		return promAmt;
	}

	/**
	 * Sets the prom amt.
	 *
	 * @param promAmt
	 *            the prom amt
	 */
	public void setPromAmt(Long promAmt) {
		this.promAmt = promAmt;
	}

	/**
	 * Gets the com amt.
	 *
	 * @return the com amt
	 */
	public Long getComAmt() {
		return comAmt;
	}

	/**
	 * Sets the com amt.
	 *
	 * @param comAmt
	 *            the com amt
	 */
	public void setComAmt(Long comAmt) {
		this.comAmt = comAmt;
	}

	/**
	 * Gets the purchase ord details.
	 *
	 * @return the purchase ord details
	 */
	public Set<PurchaseOrdDetail> getPurchaseOrdDetails() {
		return purchaseOrdDetails;
	}

	/**
	 * Sets the purchase ord details.
	 *
	 * @param purchaseOrdDetails
	 *            the purchase ord details
	 */
	public void setPurchaseOrdDetails(Set<PurchaseOrdDetail> purchaseOrdDetails) {
		this.purchaseOrdDetails = purchaseOrdDetails;
	}

}
