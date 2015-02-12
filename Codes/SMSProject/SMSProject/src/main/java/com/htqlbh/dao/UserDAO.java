/*
 * Class name: UserDAO
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.htqlbh.model.User;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class UserDAO.
 * 
 * @author Tran Trong Nghia
 */
public class UserDAO {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	/**
	 * Find by example - tim kiem user tren Database
	 * 
	 * @param instance
	 *            the instance
	 * @return the User
	 */
	public User findByUserName(String userName) {
		User instance = new User();
		instance.setUserName(userName);

		Session session = HibernateUtil.openSession();
		@SuppressWarnings("unchecked")
		List<User> results = session.createCriteria("com.htqlbh.model.User")
				.add(create(instance)).list();
		session.close();
		logger.debug("get successed");
		if (results.size() == 1) {
			return results.get(0);
		} else {
			return null;
		}
	}
}
