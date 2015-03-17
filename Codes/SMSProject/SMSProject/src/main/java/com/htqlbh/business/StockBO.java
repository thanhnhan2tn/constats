/*
 * Class name: StockBO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE            AUTHOR                 DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014   Pham Hoang Dieu           Stock business
 */
package com.htqlbh.business;

import java.util.ArrayList;

import com.htqlbh.dao.StockDAO;
import com.htqlbh.model.Stock;

/**
 * The Class StockBO.
 * 
 * @author Pham Hoang Dieu
 */
public class StockBO {
	
	/** The stock dao. */
	private StockDAO stockDAO;
	
	/** The stock. */
	private Stock stock;

	/**
	 * The Constructor.
	 */
	public StockBO() {
		stockDAO = new StockDAO();
		stock = new Stock();
	}

	/**
	 * The Constructor.
	 *
	 * @param stockDAO the stock dao
	 * @param stock the stock
	 */
	public StockBO(StockDAO stockDAO, Stock stock) {
		stockDAO = new StockDAO();
		stock = new Stock();
		this.stockDAO = stockDAO;
		this.stock = stock;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public ArrayList<Stock> getList() {
		ArrayList<Stock> stoList = (ArrayList<Stock>) stockDAO.list();
		return stoList;
	}
	
	/**
	 * Gets the stock dao.
	 *
	 * @return the stock dao
	 */
	public StockDAO getStockDAO() {
		return stockDAO;
	}

	/**
	 * Sets the stock dao.
	 *
	 * @param stockDAO the stock dao
	 */
	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * Sets the stock.
	 *
	 * @param stock the stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
