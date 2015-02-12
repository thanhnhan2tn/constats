/**
 * 
 */
package com.htqlbh.model;

import java.util.Date;

/**
 * The Class Order.
 *
 * @author TTN
 */
public class Order {

	/** The order no. */
	private String orderNo;
	
	/** The order date. */
	private Date orderDate;
	
	/** The over due date. */
	private Date overDueDate;
	
	/** The tax amt. */
	private Long taxAmt;
	
	/** The total amt. */
	private Long totalAmt;

	/**
	 * Gets the order no.
	 *
	 * @return the order no
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * Sets the order no.
	 *
	 * @param orderNo the order no
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the order date
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate2 the order date
	 */
	public void setOrderDate(Date orderDate2) {
		this.orderDate = orderDate2;
	}

	/**
	 * Gets the over due date.
	 *
	 * @return the over due date
	 */
	public Date getOverDueDate() {
		return overDueDate;
	}

	/**
	 * Sets the over due date.
	 *
	 * @param overDueDate the over due date
	 */
	public void setOverDueDate(Date overDueDate) {
		this.overDueDate = overDueDate;
	}

	/**
	 * Gets the tax amt.
	 *
	 * @return the tax amt
	 */
	public Long getTaxAmt() {
		return taxAmt;
	}

	/**
	 * Sets the tax amt.
	 *
	 * @param taxAmt the tax amt
	 */
	public void setTaxAmt(Long taxAmt) {
		this.taxAmt = taxAmt;
	}

	/**
	 * Gets the total amt.
	 *
	 * @return the total amt
	 */
	public Long getTotalAmt() {
		return totalAmt;
	}

	/**
	 * Sets the total amt.
	 *
	 * @param totalAmt the total amt
	 */
	public void setTotalAmt(Long totalAmt) {
		this.totalAmt = totalAmt;
	}
}
