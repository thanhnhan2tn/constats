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
 * The Class InventoryVoucher.
 */
public class InventoryVoucher implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 151953094040979326L;

	/** The i voucher no. */
    private String iVoucherNo;
    
    /** The sales person. */
    private SalesPerson salesPerson;
    
    /** The unit. */
    private Unit unit;
    
    /** The i voucher date. */
    private Date iVoucherDate;
    
    /** The i voucher type. */
    private String iVoucherType;
    
    /** The inventory voucher details. */
    private Set<InventoryVoucherDetail> inventoryVoucherDetails = new HashSet<InventoryVoucherDetail>(
	    0);

    /**
     * The Constructor.
     */
    public InventoryVoucher() {
    }

    /**
     * Geti voucher no.
     *
     * @return the i voucher no
     */
    public String getiVoucherNo() {
	return iVoucherNo;
    }

    /**
     * Seti voucher no.
     *
     * @param iVoucherNo the i voucher no
     */
    public void setiVoucherNo(String iVoucherNo) {
	this.iVoucherNo = iVoucherNo;
    }

    /**
     * Gets the sales person.
     *
     * @return the sales person
     */
    public SalesPerson getSalesPerson() {
	return salesPerson;
    }

    /**
     * Sets the sales person.
     *
     * @param salesPerson the sales person
     */
    public void setSalesPerson(SalesPerson salesPerson) {
	this.salesPerson = salesPerson;
    }

    /**
     * Gets the unit.
     *
     * @return the unit
     */
    public Unit getUnit() {
	return unit;
    }

    /**
     * Sets the unit.
     *
     * @param unit the unit
     */
    public void setUnit(Unit unit) {
	this.unit = unit;
    }

    /**
     * Geti voucher date.
     *
     * @return the i voucher date
     */
    public Date getiVoucherDate() {
	return iVoucherDate;
    }

    /**
     * Seti voucher date.
     *
     * @param iVoucherDate the i voucher date
     */
    public void setiVoucherDate(Date iVoucherDate) {
	this.iVoucherDate = iVoucherDate;
    }

    /**
     * Geti voucher type.
     *
     * @return the i voucher type
     */
    public String getiVoucherType() {
	return iVoucherType;
    }

    /**
     * Seti voucher type.
     *
     * @param iVoucherType the i voucher type
     */
    public void setiVoucherType(String iVoucherType) {
	this.iVoucherType = iVoucherType;
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
