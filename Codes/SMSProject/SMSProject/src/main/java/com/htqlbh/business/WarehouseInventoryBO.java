/*
 * Class name: WarehouseInventoryBO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE             AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014   Pham Hoang Dieu        Warehouse Inventory Business
 */
package com.htqlbh.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.htqlbh.dao.WarehouseInventoryDAO;
import com.htqlbh.model.Stock;
import com.htqlbh.model.WarehouseInventory;

/**
 * The Class WarehouseInventoryBO.
 * 
 * @author Pham Hoang Dieu
 */
public class WarehouseInventoryBO {
	
	/** The warehouse invt dao. */
	private WarehouseInventoryDAO warehouseInvtDao;
	
	/** The w inventory no. */
	private String wInventoryNo;
	
	/** The stock. */
	private String stock;
	
	/** The w inventory date. */
	private String wInventoryDate;

	/**
	 * The Constructor.
	 */
	public WarehouseInventoryBO() {
		warehouseInvtDao = new WarehouseInventoryDAO();
	}


	/**
	 * The Constructor.
	 *
	 * @param wInventoryNo the w inventory no
	 * @param stock the stock
	 * @param wInventoryDate the w inventory date
	 */
	public WarehouseInventoryBO(String wInventoryNo, String stock,
			String wInventoryDate) {
		warehouseInvtDao = new WarehouseInventoryDAO();
		this.wInventoryNo = wInventoryNo;
		this.stock = stock;
		this.wInventoryDate = wInventoryDate;
	}

	/**
	 * Checks if is empty list.
	 *
	 * @return true, if checks if is empty list
	 */
	public boolean isEmptyList() {
		ArrayList<WarehouseInventory> wiList = (ArrayList<WarehouseInventory>) warehouseInvtDao
				.list();
		if (wiList.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public ArrayList<WarehouseInventory> getList() {
		ArrayList<WarehouseInventory> wiList = (ArrayList<WarehouseInventory>) warehouseInvtDao.list();
		return wiList;
	}

	/**
	 * Adds the.
	 */
	public String add() {
		WarehouseInventory wi = new WarehouseInventory();
		Stock s = new Stock();
		s.setStockId(stock);
		wi.setwInventoryNo(wInventoryNo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(wInventoryDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wi.setwInventoryDate(date);
		wi.setStock(s);
		warehouseInvtDao.add(wi);
		return "added";
	}

	/**
	 * Gets the warehouse invt dao.
	 *
	 * @return the warehouse invt dao
	 */
	public WarehouseInventoryDAO getWarehouseInvtDao() {
		return warehouseInvtDao;
	}

	/**
	 * Sets the warehouse invt dao.
	 *
	 * @param warehouseInvtDao the warehouse invt dao
	 */
	public void setWarehouseInvtDao(WarehouseInventoryDAO warehouseInvtDao) {
		this.warehouseInvtDao = warehouseInvtDao;
	}

	/**
	 * Getw inventory no.
	 *
	 * @return the w inventory no
	 */
	public String getwInventoryNo() {
		return wInventoryNo;
	}

	/**
	 * Setw inventory no.
	 *
	 * @param wInventoryNo the w inventory no
	 */
	public void setwInventoryNo(String wInventoryNo) {
		this.wInventoryNo = wInventoryNo;
	}

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	public String getStock() {
		return stock;
	}

	/**
	 * Sets the stock.
	 *
	 * @param stock the stock
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	/**
	 * Getw inventory date.
	 *
	 * @return the w inventory date
	 */
	public String getwInventoryDate() {
		return wInventoryDate;
	}

	/**
	 * Setw inventory date.
	 *
	 * @param wInventoryDate the w inventory date
	 */
	public void setwInventoryDate(String wInventoryDate) {
		this.wInventoryDate = wInventoryDate;
	}

}
