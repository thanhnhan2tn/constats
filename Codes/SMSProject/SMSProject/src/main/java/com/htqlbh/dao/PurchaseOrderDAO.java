/*
 * Class name: PurchaseOrderDAO.java
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
 *  1-Aug-2014    Nguyen Gia Trang    DAO purchase order 
 */
package com.htqlbh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.htqlbh.model.PurchaseOrder;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class PurchaseOrderDAO.
 * 
 * @author Nguyen Gia Trang
 */
@Repository
public class PurchaseOrderDAO {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(PurchaseOrderDAO.class);

	/**
	 * Gets the list purchase order.
	 *
	 * @return the list purchase order
	 */
	public List<PurchaseOrder> getListPurchaseOrder() {

		try {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<PurchaseOrder> result = session.createCriteria(
					"com.htqlbh.model.PurchaseOrder").list();
			tx.commit();
			session.close();
			logger.debug("get successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("get fails", re);
			throw re;
		}
	}

	/**
	 * Adds the purchase order.
	 *
	 * @param purchaseOrder
	 *            the purchase order
	 */
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		try {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			session.save(purchaseOrder);
			tx.commit();
			session.close();
			logger.debug("Add successfull");
		} catch (RuntimeException re) {
			logger.error("Add failed", re);
			throw re;
		}
	}

}
