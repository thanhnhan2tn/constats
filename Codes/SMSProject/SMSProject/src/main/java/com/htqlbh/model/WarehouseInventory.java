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
package com.htqlbh.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Warehouse inventory
 */
public class WarehouseInventory implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6169488622972327476L;

	/** The w inventory no. */
    private String wInventoryNo;
    
    /** The stock. */
    private Stock stock;
    
    /** The w inventory date. */
    private Date wInventoryDate;
    
    /** The warehouse inventory details. */
    private Set<WarehouseInventoryDetail> warehouseInventoryDetails = new HashSet<WarehouseInventoryDetail>(
	    0);

    /**
     * The Constructor.
     */
    public WarehouseInventory() {
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

    /**
     * Getw inventory date.
     *
     * @return the w inventory date
     */
    public Date getwInventoryDate() {
	return wInventoryDate;
    }

    /**
     * Setw inventory date.
     *
     * @param wInventoryDate the w inventory date
     */
    public void setwInventoryDate(Date wInventoryDate) {
	this.wInventoryDate = wInventoryDate;
    }

    /**
     * Gets the warehouse inventory details.
     *
     * @return the warehouse inventory details
     */
    public Set<WarehouseInventoryDetail> getWarehouseInventoryDetails() {
	return warehouseInventoryDetails;
    }

    /**
     * Sets the warehouse inventory details.
     *
     * @param warehouseInventoryDetails the warehouse inventory details
     */
    public void setWarehouseInventoryDetails(
	    Set<WarehouseInventoryDetail> warehouseInventoryDetails) {
	this.warehouseInventoryDetails = warehouseInventoryDetails;
    }

}
