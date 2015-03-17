/*
 * Class name: Nguyen Nam Nhi
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE            AUTHOR                  DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Nguyen Nam Nhi          Create java class file
 */
package com.htqlbh.business;

import java.util.ArrayList;

import com.htqlbh.dao.SalesOrderDAO;

import com.htqlbh.model.SalesOrder;

/**
 * The Class SalesOrderManagerBO.
 * 
 * @author Nguyen Nam Nhi
 */
public class SalesOrderManagerBO {

	/** The sales order dao. */
	private SalesOrderDAO salesOrderDAO;

	/**
	 * The Constructor.
	 */
	public SalesOrderManagerBO() {
		salesOrderDAO = new SalesOrderDAO();
	}

	/**
	 * Gets the all order.
	 *
	 * @return the all order
	 */
	public ArrayList<SalesOrder> getAllOrder() {
		return (ArrayList<SalesOrder>) salesOrderDAO.getAllOrder();
	}

	public void addSalesOrder(SalesOrder saleOrder) {
		salesOrderDAO.addSalesOrder(saleOrder);
	}
}
