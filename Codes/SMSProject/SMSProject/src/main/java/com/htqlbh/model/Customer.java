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
 * The Class Customer.
 */
public class Customer implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4803406585447876729L;

	/** The cust id. */
    private String custId;
    
    /** The cust name. */
    private String custName;
    
    /** The address. */
    private String address;
    
    /** The phone. */
    private String phone;
    
    /** The fax. */
    private String fax;
    
    /** The email. */
    private String email;
    
    /** The over due. */
    private Integer overDue;
    
    /** The amount. */
    private Long amount;
    
    /** The over due amt. */
    private Long overDueAmt;
    
    /** The due amt. */
    private Long dueAmt;
    
    /** The status. */
    private String status;
    
    /** The description. */
    private String description;
    
    /** The sales orders. */
    private Set<SalesOrder> salesOrders = new HashSet<SalesOrder>(0);
    
    /** The payments. */
    private Set<Payment> payments = new HashSet<Payment>(0);

    /**
     * The Constructor.
     */
    public Customer() {
    }

    /**
     * Gets the cust id.
     *
     * @return the cust id
     */
    public String getCustId() {
	return custId;
    }

    /**
     * Sets the cust id.
     *
     * @param custId the cust id
     */
    public void setCustId(String custId) {
	this.custId = custId;
    }

    /**
     * Gets the cust name.
     *
     * @return the cust name
     */
    public String getCustName() {
	return custName;
    }

    /**
     * Sets the cust name.
     *
     * @param custName the cust name
     */
    public void setCustName(String custName) {
	this.custName = custName;
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
     * Gets the sales orders.
     *
     * @return the sales orders
     */
    public Set<SalesOrder> getSalesOrders() {
	return salesOrders;
    }

    /**
     * Sets the sales orders.
     *
     * @param salesOrders the sales orders
     */
    public void setSalesOrders(Set<SalesOrder> salesOrders) {
	this.salesOrders = salesOrders;
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
