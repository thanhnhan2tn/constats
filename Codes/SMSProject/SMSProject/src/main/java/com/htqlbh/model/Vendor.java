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
 * The Class Vendor.
 */
public class Vendor implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4361792641994127307L;

	/** The vendor id. */
    private String vendorId;
    
    /** The vendor name. */
    private String vendorName;
    
    /** The address. */
    private String address;
    
    /** The email. */
    private String email;
    
    /** The phone. */
    private String phone;
    
    /** The fax. */
    private String fax;
    
    /** The due amt. */
    private Long dueAmt;
    
    /** The amount. */
    private Long amount;
    
    /** The over due amt. */
    private Long overDueAmt;
    
    /** The status. */
    private String status;
    
    /** The description. */
    private String description;
    
    /** The purchase orders. */
    private Set<PurchaseOrder> purchaseOrders = new HashSet<PurchaseOrder>(0);
    
    /** The distributor payments. */
    private Set<DistributorPayment> distributorPayments = new HashSet<DistributorPayment>(
	    0);

    /**
     * The Constructor.
     */
    public Vendor() {
    }

    /**
     * Gets the vendor id.
     *
     * @return the vendor id
     */
    public String getVendorId() {
	return vendorId;
    }

    /**
     * Sets the vendor id.
     *
     * @param vendorId the vendor id
     */
    public void setVendorId(String vendorId) {
	this.vendorId = vendorId;
    }

    /**
     * Gets the vendor name.
     *
     * @return the vendor name
     */
    public String getVendorName() {
	return vendorName;
    }

    /**
     * Sets the vendor name.
     *
     * @param vendorName the vendor name
     */
    public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
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
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
	return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
	this.phone = phone;
    }

    /**
     * Gets the fax.
     *
     * @return the fax
     */
    public String getFax() {
	return fax;
    }

    /**
     * Sets the fax.
     *
     * @param fax the fax
     */
    public void setFax(String fax) {
	this.fax = fax;
    }

    /**
     * Gets the due amt.
     *
     * @return the due amt
     */
    public Long getDueAmt() {
	return dueAmt;
    }

    /**
     * Sets the due amt.
     *
     * @param dueAmt the due amt
     */
    public void setDueAmt(Long dueAmt) {
	this.dueAmt = dueAmt;
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

    /**
     * Gets the over due amt.
     *
     * @return the over due amt
     */
    public Long getOverDueAmt() {
	return overDueAmt;
    }

    /**
     * Sets the over due amt.
     *
     * @param overDueAmt the over due amt
     */
    public void setOverDueAmt(Long overDueAmt) {
	this.overDueAmt = overDueAmt;
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
     * Gets the purchase orders.
     *
     * @return the purchase orders
     */
    public Set<PurchaseOrder> getPurchaseOrders() {
	return purchaseOrders;
    }

    /**
     * Sets the purchase orders.
     *
     * @param purchaseOrders the purchase orders
     */
    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
	this.purchaseOrders = purchaseOrders;
    }

    /**
     * Gets the distributor payments.
     *
     * @return the distributor payments
     */
    public Set<DistributorPayment> getDistributorPayments() {
	return distributorPayments;
    }

    /**
     * Sets the distributor payments.
     *
     * @param distributorPayments the distributor payments
     */
    public void setDistributorPayments(
	    Set<DistributorPayment> distributorPayments) {
	this.distributorPayments = distributorPayments;
    }

}
