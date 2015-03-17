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
 * The Class PurchaseOrdDetail.
 */
public class PurchaseOrdDetail implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
    private int id;
    
    /** The stock. */
    private Stock stock;
    
    /** The purchase order. */
    private PurchaseOrder purchaseOrder;
    
    /** The inventory. */
    private Inventory inventory;
    
    /** The qty. */
    private Integer qty;
    
    /** The purchase price. */
    private Long purchasePrice;
    
    /** The qty prom. */
    private Integer qtyProm;
    
    /** The qty prom amt. */
    private Long qtyPromAmt;
    
    /** The amt prom. */
    private Integer amtProm;
    
    /** The tax amt. */
    private Long taxAmt;
    
    /** The amount. */
    private Long amount;

    /**
     * The Constructor.
     */
    public PurchaseOrdDetail() {
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
     * Gets the purchase order.
     *
     * @return the purchase order
     */
    public PurchaseOrder getPurchaseOrder() {
	return purchaseOrder;
    }

    /**
     * Sets the purchase order.
     *
     * @param purchaseOrder the purchase order
     */
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
	this.purchaseOrder = purchaseOrder;
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

    /**
     * Gets the purchase price.
     *
     * @return the purchase price
     */
    public Long getPurchasePrice() {
	return purchasePrice;
    }

    /**
     * Sets the purchase price.
     *
     * @param purchasePrice the purchase price
     */
    public void setPurchasePrice(Long purchasePrice) {
	this.purchasePrice = purchasePrice;
    }

    /**
     * Gets the qty prom.
     *
     * @return the qty prom
     */
    public Integer getQtyProm() {
	return qtyProm;
    }

    /**
     * Sets the qty prom.
     *
     * @param qtyProm the qty prom
     */
    public void setQtyProm(Integer qtyProm) {
	this.qtyProm = qtyProm;
    }

    /**
     * Gets the qty prom amt.
     *
     * @return the qty prom amt
     */
    public Long getQtyPromAmt() {
	return qtyPromAmt;
    }

    /**
     * Sets the qty prom amt.
     *
     * @param qtyPromAmt the qty prom amt
     */
    public void setQtyPromAmt(Long qtyPromAmt) {
	this.qtyPromAmt = qtyPromAmt;
    }

    /**
     * Gets the amt prom.
     *
     * @return the amt prom
     */
    public Integer getAmtProm() {
	return amtProm;
    }

    /**
     * Sets the amt prom.
     *
     * @param amtProm the amt prom
     */
    public void setAmtProm(Integer amtProm) {
	this.amtProm = amtProm;
    }

    /**
     * Gets the tax amt.
     *
     * @return the tax amt
     */
    public Long getTaxAmt() {
	return taxAmt;
    }

    /**
     * Sets the tax amt.
     *
     * @param taxAmt the tax amt
     */
    public void setTaxAmt(Long taxAmt) {
	this.taxAmt = taxAmt;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public Long getAmount() {
	return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the amount
     */
    public void setAmount(Long amount) {
	this.amount = amount;
    }

}
