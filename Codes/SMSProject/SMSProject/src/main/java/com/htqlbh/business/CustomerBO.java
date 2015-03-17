/*
 * Class name: Nguyen Nam Nhi
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE             AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Nguyen Nam Nhi          Create java class file
 */
package com.htqlbh.business;

import com.htqlbh.dao.CustomerDAO;
import com.htqlbh.model.Customer;

/**
 * The Class CustomerBO.
 * 
 * @author Nguyen Nam Nhi
 */
public class CustomerBO {
	
	/** The customer dao. */
	private CustomerDAO customerDAO;
	
	/** The cust id. */
	@SuppressWarnings("unused")
	private String custId;

	/**
	 * The Constructor.
	 *
	 * @param custId the cust id
	 */
	public CustomerBO(String custId) {
		customerDAO = new CustomerDAO();
		this.custId = custId;
	}

	/**
	 * Gets the json cust id.
	 *
	 * @param id the id
	 * @return the JSON cust id
	 */
	public String getJSONCustId(String id) {
		Customer customer = customerDAO.findById(id);
		String result = "";
		if (customer != null) {
			result += "{";
			result += "\"custId\": " + "\"" + customer.getCustId() + "\", ";
			result += "\"custName\": " + "\"" + customer.getCustName() + "\" ";
			;
			result += "}";
		}
		return result;
	}
}
