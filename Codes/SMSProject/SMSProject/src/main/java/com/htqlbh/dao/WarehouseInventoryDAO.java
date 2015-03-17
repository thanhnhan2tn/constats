/*
 * Class name: WarehouseInventoryDAO
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
 *  1-August-2014   Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.htqlbh.model.WarehouseInventory;
import com.htqlbh.util.HibernateUtil;

/**
 * The Class WarehouseInventoryDAO.
 * 
 * @author Pham Hoang Dieu
 */
public class WarehouseInventoryDAO {

	/**
	 * List.
	 *
	 * @return the list< warehouse inventory>
	 */
	@SuppressWarnings("unchecked")
	public List<WarehouseInventory> list() {
		Transaction tx = null;
		List<WarehouseInventory> result = null;
		try {
			Session session = HibernateUtil.openSession();
			tx = session.beginTransaction();

			result = (List<WarehouseInventory>) session.createCriteria(
					"com.htqlbh.model.WarehouseInventory").list();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return result;
	}

	/**
	 * Adds the.
	 *
	 * @param warehouseInventory
	 *            the warehouse inventory
	 */
	public String add(WarehouseInventory warehouseInventory) {
		Transaction tx = null;
		try {
			Session session = HibernateUtil.openSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(warehouseInventory);
			tx.commit();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			return "fail";
		}
	}
}
