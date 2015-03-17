/*
 * Class name: StockDAO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE              AUTHOR             DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.dao;

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.htqlbh.model.Stock;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class StockDAO.
 * 
 * @author Pham Hoang Dieu
 */
public class StockDAO {

	/**
	 * List.
	 *
	 * @return the list< stock>
	 */
	@SuppressWarnings("unchecked")
	public List<Stock> list() {
		Transaction tx = null;
		List<Stock> result = null;
		try {
			Session session = HibernateUtil.openSession();
			tx = session.beginTransaction();

			result = (List<Stock>) session.createCriteria(
					"com.htqlbh.model.Stock").list();

			tx.commit();
		} catch (Exception e) {
			System.err.println("[ERROR] Co loi khi khoi tao session");
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return result;
	}

	/**
	 * Checks if is exists.
	 *
	 * @param stock
	 *            the stock
	 * @return true, if checks if is exists
	 */
	public boolean isExists(Stock stock) {
		Transaction tx = null;
		boolean isExists = false;
		try {
			Session session = HibernateUtil.openSession();
			tx = session.beginTransaction();

			@SuppressWarnings("unchecked")
			ArrayList<Stock> list = (ArrayList<Stock>) session
					.createCriteria("com.htqlbh.model.Stock")
					.add(create(stock)).list();

			if (list.size() == 1) {
				isExists = true;
			} else {
				isExists = false;
			}

			tx.commit();
		} catch (Exception e) {
			System.err.println("[ERROR] Co loi khi khoi tao session");
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return isExists;
	}
}
