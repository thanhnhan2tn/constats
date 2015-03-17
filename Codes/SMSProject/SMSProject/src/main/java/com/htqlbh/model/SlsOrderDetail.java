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
 * The Class SlsOrderDetail.
 */
public class SlsOrderDetail implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1765555478425149225L;

	/** The id. */
    private int id;
    
    /** The sales order. */
    private SalesOrder salesOrder;
    
    /** The inventory. */
    private Inventory inventory;
    
    /** The qty. */
    private Integer qty;
    
    /** The sales price. */
    private Long salesPrice;
    
    /** The discount. */
    private Long discount;
    
    /** The tax amt. */
    private Long taxAmt;
    
    /** The amount. */
    private Long amount;

    /**
     * The Constructor.
     */
    public SlsOrderDetail() {
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
     * Gets the sales order.
     *
     * @return the sales order
     */
    public SalesOrder getSalesOrder() {
	return salesOrder;
    }

    /**
     * Sets the sales order.
     *
     * @param salesOrder the sales order
     */
    public void setSalesOrder(SalesOrder salesOrder) {
	this.salesOrder = salesOrder;
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
     * Gets the sales price.
     *
     * @return the sales price
     */
    public Long getSalesPrice() {
	return salesPrice;
    }

    /**
     * Sets the sales price.
     *
     * @param salesPrice the sales price
     */
    public void setSalesPrice(Long salesPrice) {
	this.salesPrice = salesPrice;
    }

    /**
     * Gets the discount.
     *
     * @return the discount
     */
    public Long getDiscount() {
	return discount;
    }

    /**
     * Sets the discount.
     *
     * @param discount the discount
     */
    public void setDiscount(Long discount) {
	this.discount = discount;
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
