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
 * The Class Inventory.
 */
public class Inventory implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5255299317304362765L;

	/** The invt id. */
    private String invtId;
    
    /** The unit id t. */
    private Unit unitIdT;
    
    /** The unit id l. */
    private Unit unitIdL;
    
    /** The invt name. */
    private String invtName;
    
    /** The class name. */
    private String className;
    
    /** The unit rate. */
    private Integer unitRate;
    
    /** The sales price t. */
    private Long salesPriceT;
    
    /** The sales price l. */
    private Long salesPriceL;
    
    /** The qty stock. */
    private Integer qtyStock;
    
    /** The sls tax. */
    private Long slsTax;
    
    /** The status. */
    private String status;
    
    /** The description. */
    private String description;

    /**
     * The Constructor.
     */
    public Inventory() {
    }

    /**
     * Gets the invt id.
     *
     * @return the invt id
     */
    public String getInvtId() {
	return invtId;
    }

    /**
     * Sets the invt id.
     *
     * @param invtId the invt id
     */
    public void setInvtId(String invtId) {
	this.invtId = invtId;
    }

    /**
     * Gets the unit id t.
     *
     * @return the unit id t
     */
    public Unit getUnitIdT() {
	return unitIdT;
    }

    /**
     * Sets the unit id t.
     *
     * @param unitIdT the unit id t
     */
    public void setUnitIdT(Unit unitIdT) {
	this.unitIdT = unitIdT;
    }

    /**
     * Gets the unit id l.
     *
     * @return the unit id l
     */
    public Unit getUnitIdL() {
	return unitIdL;
    }

    /**
     * Sets the unit id l.
     *
     * @param unitIdL the unit id l
     */
    public void setUnitIdL(Unit unitIdL) {
	this.unitIdL = unitIdL;
    }

    /**
     * Gets the invt name.
     *
     * @return the invt name
     */
    public String getInvtName() {
	return invtName;
    }

    /**
     * Sets the invt name.
     *
     * @param invtName the invt name
     */
    public void setInvtName(String invtName) {
	this.invtName = invtName;
    }

    /**
     * Gets the class name.
     *
     * @return the class name
     */
    public String getClassName() {
	return className;
    }

    /**
     * Sets the class name.
     *
     * @param className the class name
     */
    public void setClassName(String className) {
	this.className = className;
    }

    /**
     * Gets the unit rate.
     *
     * @return the unit rate
     */
    public Integer getUnitRate() {
	return unitRate;
    }

    /**
     * Sets the unit rate.
     *
     * @param unitRate the unit rate
     */
    public void setUnitRate(Integer unitRate) {
	this.unitRate = unitRate;
    }

    /**
     * Gets the sales price t.
     *
     * @return the sales price t
     */
    public Long getSalesPriceT() {
	return salesPriceT;
    }

    /**
     * Sets the sales price t.
     *
     * @param salesPriceT the sales price t
     */
    public void setSalesPriceT(Long salesPriceT) {
	this.salesPriceT = salesPriceT;
    }

    /**
     * Gets the sales price l.
     *
     * @return the sales price l
     */
    public Long getSalesPriceL() {
	return salesPriceL;
    }

    /**
     * Sets the sales price l.
     *
     * @param salesPriceL the sales price l
     */
    public void setSalesPriceL(Long salesPriceL) {
	this.salesPriceL = salesPriceL;
    }

    /**
     * Gets the qty stock.
     *
     * @return the qty stock
     */
    public Integer getQtyStock() {
	return qtyStock;
    }

    /**
     * Sets the qty stock.
     *
     * @param qtyStock the qty stock
     */
    public void setQtyStock(Integer qtyStock) {
	this.qtyStock = qtyStock;
    }

    /**
     * Gets the sls tax.
     *
     * @return the sls tax
     */
    public Long getSlsTax() {
	return slsTax;
    }

    /**
     * Sets the sls tax.
     *
     * @param slsTax the sls tax
     */
    public void setSlsTax(Long slsTax) {
	this.slsTax = slsTax;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
	return status;
    }

    /**
     * Sets the status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
	this.status = status;
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

}
