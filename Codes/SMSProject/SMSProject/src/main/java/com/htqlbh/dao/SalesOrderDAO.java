/*
 * Class name: SalesOrderDAO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE            AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Nguyen Nam Nhi          Create java class file
 */
package com.htqlbh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.htqlbh.model.SalesOrder;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class SalesOrderDAO.
 * 
 * @author Nguyen Nam Nhi
 */
public class SalesOrderDAO {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(InventoryDAO.class);

	/**
	 * Gets the all order.
	 *
	 * @return the all order
	 */
	public List<SalesOrder> getAllOrder() {
		try {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<SalesOrder> results = session.createQuery("from SalesOrder")
					.list();
			tx.commit();
			session.close();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * Adds the sales order.
	 *
	 * @param saleorder
	 *            the saleorder
	 * @return true, if adds the sales order
	 */
	public boolean addSalesOrder(SalesOrder saleorder) {

		try {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(saleorder);
			tx.commit();
			session.close();
			logger.debug("add successful");
			return true;
		} catch (RuntimeException re) {
			logger.error("add failed", re);
			throw re;
		}
	}
}
