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

import java.util.HashSet;
import java.util.Set;

/**
 * The Class Stock.
 */
public class Stock implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1357261905822928270L;

	/** The stock id. */
    private String stockId;
    
    /** The stock name. */
    private String stockName;
    
    /** The address. */
    private String address;
    
    /** The description. */
    private String description;
    
    /** The warehouse inventories. */
    private Set<WarehouseInventory> warehouseInventories = new HashSet<WarehouseInventory>(
	    0);
    
    /** The purchase ord details. */
    private Set<PurchaseOrdDetail> purchaseOrdDetails = new HashSet<PurchaseOrdDetail>(
	    0);
    
    /** The inventory voucher details. */
    private Set<InventoryVoucherDetail> inventoryVoucherDetails = new HashSet<InventoryVoucherDetail>(
	    0);

    /**
     * The Constructor.
     */
    public Stock() {
    }

    /**
     * Gets the stock id.
     *
     * @return the stock id
     */
    public String getStockId() {
	return stockId;
    }

    /**
     * Sets the stock id.
     *
     * @param stockId the stock id
     */
    public void setStockId(String stockId) {
	this.stockId = stockId;
    }

    /**
     * Gets the stock name.
     *
     * @return the stock name
     */
    public String getStockName() {
	return stockName;
    }

    /**
     * Sets the stock name.
     *
     * @param stockName the stock name
     */
    public void setStockName(String stockName) {
	this.stockName = stockName;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
	return address;
    }

    /**
     * Sets the address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the warehouse inventories.
     *
     * @return the warehouse inventories
     */
    public Set<WarehouseInventory> getWarehouseInventories() {
	return warehouseInventories;
    }

    /**
     * Sets the warehouse inventories.
     *
     * @param warehouseInventories the warehouse inventories
     */
    public void setWarehouseInventories(
	    Set<WarehouseInventory> warehouseInventories) {
	this.warehouseInventories = warehouseInventories;
    }

    /**
     * Gets the purchase ord details.
     *
     * @return the purchase ord details
     */
    public Set<PurchaseOrdDetail> getPurchaseOrdDetails() {
	return purchaseOrdDetails;
    }

    /**
     * Sets the purchase ord details.
     *
     * @param purchaseOrdDetails the purchase ord details
     */
    public void setPurchaseOrdDetails(Set<PurchaseOrdDetail> purchaseOrdDetails) {
	this.purchaseOrdDetails = purchaseOrdDetails;
    }

    /**
     * Gets the inventory voucher details.
     *
     * @return the inventory voucher details
     */
    public Set<InventoryVoucherDetail> getInventoryVoucherDetails() {
	return inventoryVoucherDetails;
    }

    /**
     * Sets the inventory voucher details.
     *
     * @param inventoryVoucherDetails the inventory voucher details
     */
    public void setInventoryVoucherDetails(
	    Set<InventoryVoucherDetail> inventoryVoucherDetails) {
	this.inventoryVoucherDetails = inventoryVoucherDetails;
    }

}
