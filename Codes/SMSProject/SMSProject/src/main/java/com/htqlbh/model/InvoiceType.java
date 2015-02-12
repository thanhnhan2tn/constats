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
 * The Class InvoiceType.
 */
public class InvoiceType implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8195060395979338551L;

	/** The invoice type. */
    private String invoiceType;
    
    /** The type name. */
    private String typeName;
    
    /** The sales orders. */
    private Set<SalesOrder> salesOrders = new HashSet<SalesOrder>(0);

    /**
     * The Constructor.
     */
    public InvoiceType() {
    }

    /**
     * Gets the invoice type.
     *
     * @return the invoice type
     */
    public String getInvoiceType() {
	return invoiceType;
    }

    /**
     * Sets the invoice type.
     *
     * @param invoiceType the invoice type
     */
    public void setInvoiceType(String invoiceType) {
	this.invoiceType = invoiceType;
    }

    /**
     * Gets the type name.
     *
     * @return the type name
     */
    public String getTypeName() {
	return typeName;
    }

    /**
     * Sets the type name.
     *
     * @param typeName the type name
     */
    public void setTypeName(String typeName) {
	this.typeName = typeName;
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

}
