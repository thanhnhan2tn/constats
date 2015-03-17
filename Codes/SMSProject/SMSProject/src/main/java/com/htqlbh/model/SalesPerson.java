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

//

import java.util.HashSet;
import java.util.Set;

/**
 * The Class SalesPerson.
 */
public class SalesPerson implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The sales person id. */
    private String salesPersonId;
    
    /** The sales person name. */
    private String salesPersonName;
    
    /** The address. */
    private String address;
    
    /** The over due. */
    private Integer overDue;
    
    /** The status. */
    private String status;
    
    /** The description. */
    private String description;
    
    /** The inventory vouchers. */
    private Set<InventoryVoucher> inventoryVouchers = new HashSet<InventoryVoucher>(
	    0);
    
    /** The payments. */
    private Set<Payment> payments = new HashSet<Payment>(0);

    /**
     * The Constructor.
     */
    public SalesPerson() {
    }

    /**
     * Gets the sales person id.
     *
     * @return the sales person id
     */
    public String getSalesPersonId() {
	return salesPersonId;
    }

    /**
     * Sets the sales person id.
     *
     * @param salesPersonId the sales person id
     */
    public void setSalesPersonId(String salesPersonId) {
	this.salesPersonId = salesPersonId;
    }

    /**
     * Gets the sales person name.
     *
     * @return the sales person name
     */
    public String getSalesPersonName() {
	return salesPersonName;
    }

    /**
     * Sets the sales person name.
     *
     * @param salesPersonName the sales person name
     */
    public void setSalesPersonName(String salesPersonName) {
	this.salesPersonName = salesPersonName;
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
     * Gets the over due.
     *
     * @return the over due
     */
    public Integer getOverDue() {
	return overDue;
    }

    /**
     * Sets the over due.
     *
     * @param overDue the over due
     */
    public void setOverDue(Integer overDue) {
	this.overDue = overDue;
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

    /**
     * Gets the inventory vouchers.
     *
     * @return the inventory vouchers
     */
    public Set<InventoryVoucher> getInventoryVouchers() {
	return inventoryVouchers;
    }

    /**
     * Sets the inventory vouchers.
     *
     * @param inventoryVouchers the inventory vouchers
     */
    public void setInventoryVouchers(Set<InventoryVoucher> inventoryVouchers) {
	this.inventoryVouchers = inventoryVouchers;
    }

    /**
     * Gets the payments.
     *
     * @return the payments
     */
    public Set<Payment> getPayments() {
	return payments;
    }

    /**
     * Sets the payments.
     *
     * @param payments the payments
     */
    public void setPayments(Set<Payment> payments) {
	this.payments = payments;
    }

}
