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

/**
 * The Class InventoryVoucherDetail.
 */
public class InventoryVoucherDetail implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4643215712309887461L;

	/** The id. */
    private int id;
    
    /** The stock. */
    private Stock stock;
    
    /** The inventory. */
    private Inventory inventory;
    
    /** The inventory voucher. */
    private InventoryVoucher inventoryVoucher;
    
    /** The qty. */
    private Integer qty;

    /**
     * The Constructor.
     */
    public InventoryVoucherDetail() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id
     */
    public void setId(int id) {
	this.id = id;
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
     * Gets the inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory() {
	return inventory;
    }

    /**
     * Sets the inventory.
     *
     * @param inventory the inventory
     */
    public void setInventory(Inventory inventory) {
	this.inventory = inventory;
    }

    /**
     * Gets the inventory voucher.
     *
     * @return the inventory voucher
     */
    public InventoryVoucher getInventoryVoucher() {
	return inventoryVoucher;
    }

    /**
     * Sets the inventory voucher.
     *
     * @param inventoryVoucher the inventory voucher
     */
    public void setInventoryVoucher(InventoryVoucher inventoryVoucher) {
	this.inventoryVoucher = inventoryVoucher;
    }

    /**
     * Gets the qty.
     *
     * @return the qty
     */
    public Integer getQty() {
	return qty;
    }

    /**
     * Sets the qty.
     *
     * @param qty the qty
     */
    public void setQty(Integer qty) {
	this.qty = qty;
    }

}
