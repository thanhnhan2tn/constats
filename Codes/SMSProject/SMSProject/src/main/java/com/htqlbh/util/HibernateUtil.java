/*
 * Class name:
 * 
 * Version information:
 *
 * Date: 10-July-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE         AUTHOR             DESCRIPTION
 *  --------------------------------------------------------
 *  10-July-2014    XXXXXX          Create java class file
 */
package com.htqlbh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * The Class HibernateUtil.
 */
public class HibernateUtil {
	
	/** The session factory. */
	@SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Open session.
	 *
	 * @return the session
	 */
	public static Session openSession() {
		return sessionFactory.openSession();
	}
}
