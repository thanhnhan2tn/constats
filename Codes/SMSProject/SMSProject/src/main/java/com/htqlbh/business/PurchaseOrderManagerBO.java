/*
 * Class name: PurchaseOrderManagerBO.java
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
 *  1-Aug-2014    Nguyen Gia Trang    Purchase order manager business
 */
package com.htqlbh.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.htqlbh.dao.PurchaseOrderDAO;
import com.htqlbh.model.PurchaseOrder;

/**
 * The Class PurchaseOrderManagerBO.
 * 
 * @author Nguyen Gia Trang
 */
public class PurchaseOrderManagerBO {

	/** The purchase order dao. */
	private PurchaseOrderDAO purchaseOrderDao;

	/** The order no. */
	private String orderNo;

	/** The order date. */
	private String orderDate;

	/** The disc amt. */
	private Long discAmt;

	/** The tax amt. */
	private Long taxAmt;

	/** The total amt. */
	private Long totalAmt;

	/**
	 * The Constructor.
	 */
	public PurchaseOrderManagerBO() {
		purchaseOrderDao = new PurchaseOrderDAO();
	}

	/**
	 * Gets the purchase order list.
	 *
	 * @return the purchase order list
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		return (ArrayList<PurchaseOrder>) purchaseOrderDao
				.getListPurchaseOrder();

	}

	/**
	 * The Constructor.
	 *
	 * @param orderNo
	 *            the order no
	 * @param orderDate
	 *            the order date
	 * @param discAmt
	 *            the disc amt
	 * @param taxAmt
	 *            the tax amt
	 * @param totalAmt
	 *            the total amt
	 */
	public PurchaseOrderManagerBO(String orderNo, String orderDate,
			Long discAmt, Long taxAmt, Long totalAmt) {
		purchaseOrderDao = new PurchaseOrderDAO();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.discAmt = discAmt;
		this.taxAmt = taxAmt;
		this.totalAmt = totalAmt;
	}

	/**
	 * Adds the purchase order.
	 */
	public void addPurchaseOrder() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();
		try {
			date = sdf.parse(orderDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		purchaseOrder.setOrderNo(orderNo);
		purchaseOrder.setOrderDate(date);
		purchaseOrder.setDiscAmt(discAmt);
		purchaseOrder.setTaxAmt(taxAmt);
		purchaseOrder.setTotalAmt(totalAmt);
		purchaseOrderDao.addPurchaseOrder(purchaseOrder);
	}
}
