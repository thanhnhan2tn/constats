/*
 * Class name: UnitDAO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE            AUTHOR                     DESCRIPTION
 *  --------------------------------------------------------
 * 1-August-2014   Tran Trong Nghia           Database Access Object
 */
package com.htqlbh.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.htqlbh.model.Unit;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class UnitDAO.
 * 
 * @author Tran Trong Nghia
 */
public class UnitDAO {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(UnitDAO.class);

	/**
	 * Find by example - tim don vi tinh tren database
	 * 
	 * @param instance
	 *            the instance
	 * @return the list< unit>
	 */
	public List<Unit> findByExample(Unit instance) {
		try {
			Session session = HibernateUtil.openSession();
			@SuppressWarnings("unchecked")
			List<Unit> results = session
					.createCriteria("com.htqlbh.model.Unit")
					.add(create(instance)).list();
			session.close();
			logger.debug("get successed");
			return results;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	/**
	 * Gets the frist by Unit Name - lay don vi tinh dau tien tim thay
	 * 
	 * @param unitName
	 *            the unitName
	 * 
	 * @return the frist by unit Name
	 */
	public Unit getFristByUnitName(String unitName) {
		Unit instance = new Unit();
		instance.setUnitName(unitName);
		List<Unit> results = findByExample(instance);
		logger.debug("get unit by name successed");
		if (results.size() > 0) {
			return results.get(0);
		} else {
			logger.debug("get unit by name successed: null");
			return null;
		}
	}

	/**
	 * Adds the unit.
	 * 
	 * @param instance
	 *            the instance
	 */
	public void addUnit(String unitName) {
		try {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			Unit instance = new Unit(unitName);
			session.save(instance);
			tx.commit();
			session.close();
			logger.error("add successed");
		} catch (RuntimeException re) {
			logger.error("add failed", re);
			throw re;
		}
	}
}
