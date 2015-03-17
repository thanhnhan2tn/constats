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
 * The Class SalesOrder.
 */
public class SalesOrder extends Order implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The customer. */
    private Customer customer;
    
    /** The invoice type. */
    private InvoiceType invoiceType;
    
    /** The order disc. */
    private Long orderDisc;
    
    /** The payment. */
    private Long payment;
    
    /** The debt. */
    private Long debt;
    
    /** The description. */
    private String description;
    
    /** The sls order details. */
    private Set<SlsOrderDetail> slsOrderDetails = new HashSet<SlsOrderDetail>(0);

    /**
     * The Constructor.
     */
    public SalesOrder() {
    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
	return customer;
    }

    /**
     * Sets the customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    /**
     * Gets the invoice type.
     *
     * @return the invoice type
     */
    public InvoiceType getInvoiceType() {
	return invoiceType;
    }

    /**
     * Sets the invoice type.
     *
     * @param invoiceType the invoice type
     */
    public void setInvoiceType(InvoiceType invoiceType) {
	this.invoiceType = invoiceType;
    }

    /**
     * Gets the order disc.
     *
     * @return the order disc
     */
    public Long getOrderDisc() {
	return orderDisc;
    }

    /**
     * Sets the order disc.
     *
     * @param orderDisc the order disc
     */
    public void setOrderDisc(Long orderDisc) {
	this.orderDisc = orderDisc;
    }

    /**
     * Gets the payment.
     *
     * @return the payment
     */
    public Long getPayment() {
	return payment;
    }

    /**
     * Sets the payment.
     *
     * @param payment the payment
     */
    public void setPayment(Long payment) {
	this.payment = payment;
    }

    /**
     * Gets the debt.
     *
     * @return the debt
     */
    public Long getDebt() {
	return debt;
    }

    /**
     * Sets the debt.
     *
     * @param debt the debt
     */
    public void setDebt(Long debt) {
	this.debt = debt;
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
     * Gets the sls order details.
     *
     * @return the sls order details
     */
    public Set<SlsOrderDetail> getSlsOrderDetails() {
	return slsOrderDetails;
    }

    /**
     * Sets the sls order details.
     *
     * @param slsOrderDetails the sls order details
     */
    public void setSlsOrderDetails(Set<SlsOrderDetail> slsOrderDetails) {
	this.slsOrderDetails = slsOrderDetails;
    }

}
