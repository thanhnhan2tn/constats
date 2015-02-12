/*
 * Class name: DistributorPaymentDao.java
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
 *  1-Aug-2014    Nguyen Gia Trang    DAO distributor payment
 */
package com.htqlbh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.htqlbh.model.DistributorPayment;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class DistributorPaymentDao.
 * 
 * @author Nguyen Gia Trang
 */
@Repository
public class DistributorPaymentDao {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(DistributorPaymentDao.class);

	/**
	 * Gets the list distritor payment.
	 *
	 * @return the list distritor payment
	 */
	public List<DistributorPayment> getListDistritorPayment() {
		try {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<DistributorPayment> result = session.createCriteria(
					"com.htqlbh.model.DistributorPayment").list();
			tx.commit();
			// session.close();
			logger.debug("get successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("get fails", re);
			throw re;
		}
	}

	/**
	 * Adds the distributor payment.
	 *
	 * @param distributorPayment
	 *            the distributor payment
	 */
	public void addDistributorPayment(DistributorPayment distributorPayment) {
		try {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			session.save(distributorPayment);
			tx.commit();
			session.close();
			logger.debug("Add successfull");
		} catch (RuntimeException re) {
			logger.error("Add failed", re);
			throw re;
		}
	}
}
