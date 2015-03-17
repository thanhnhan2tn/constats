/*
 * Class name: CustomerDAO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *       DATE          AUTHOR                    DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014   Nguyen Nam Nhi            Create java class file
 */
package com.htqlbh.dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.htqlbh.model.Customer;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class CustomerDAO.
 * 
 * @author: Nguyen Nam Nhi
 */
public class CustomerDAO {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerDAO.class);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the customer
	 */
	public Customer findById(java.lang.String id) {

		try {
			Session session = HibernateUtil.openSession();
			Customer instance = (Customer) session.get(
					"com.htqlbh.model.Customer", id);
			session.close();
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}
}
