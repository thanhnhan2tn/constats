/*
 * Class name: InventoryDAO
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
 * 1-August-2014  Tran Trong Nghia           Database Access Object
 */

package com.htqlbh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.htqlbh.model.Inventory;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class InventoryDAO.
 * 
 * @author Tran Trong Nghia
 */
public class InventoryDAO {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(InventoryDAO.class);

	/**
	 * Gets the list item - lay danh sach mat hang
	 * 
	 * @return the list item
	 */
	public List<Inventory> getListItem() {
		try {
			// mo session
			Session session = HibernateUtil.openSession();
			// bat dau giao dich
			Transaction tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Inventory> results = session.createCriteria(
					"com.htqlbh.model.Inventory").list();
			// commit giao dich
			tx.commit();
			// dong session
			session.close();
			logger.debug("get successful");
			return results;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	/**
	 * Adds the item - them hoac cap nhat thong tin mat hang
	 * 
	 * @param inventory
	 *            the inventory
	 */
	public void addItem(Inventory inventory) {
		try {
			// mo session
			Session session = HibernateUtil.openSession();
			// bat dau giao dich
			Transaction tx = session.beginTransaction();
			// them moi hoac cap nhat mat hang neu trung Id
			session.saveOrUpdate(inventory);
			// commit
			tx.commit();
			// dong session
			session.close();
			logger.debug("add successful");
		} catch (RuntimeException re) {
			logger.error("add failed", re);
			throw re;
		}
	}

	/**
	 * Delete item - xoa mot mat hang
	 * 
	 * @param persistentInstance
	 *            the persistent instance
	 */
	public void deleteItem(Inventory persistentInstance) {
		try {
			// mo session
			Session session = HibernateUtil.openSession();
			// bat dau giao dich
			Transaction tx = session.beginTransaction();
			session.delete(persistentInstance);
			// commit giao dich
			tx.commit();
			// dong session
			session.close();
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Find by id - tim kiem mat hang theo id
	 * 
	 * @param id
	 *            the id
	 * @return the inventory
	 */
	public Inventory findById(java.lang.String id) {
		try {
			// mo sesion
			Session session = HibernateUtil.openSession();
			// lay mat hang theo id
			Inventory instance = (Inventory) session.get(
					"com.htqlbh.model.Inventory", id);
			// dong sesion
			session.close();
			// kiem tra ket qua
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
