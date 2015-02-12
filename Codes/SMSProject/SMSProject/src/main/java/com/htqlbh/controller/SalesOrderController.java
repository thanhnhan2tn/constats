/*
 * Class name: SalesOrderController
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
package com.htqlbh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htqlbh.business.CustomerBO;
import com.htqlbh.business.SalesOrderManagerBO;
import com.htqlbh.dao.CustomerDAO;
import com.htqlbh.model.Customer;
import com.htqlbh.model.SalesOrder;

/**
 * The Class SalesOrderController.
 * 
 * @author Nguyen Nam Nhi
 */
@Controller
public class SalesOrderController {

	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Sales order list.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/SalesOrder", method = RequestMethod.GET)
	public String SalesOrderList(Model model) {
		SalesOrderManagerBO saleOrderManager = new SalesOrderManagerBO();
		ArrayList<SalesOrder> list = saleOrderManager.getAllOrder();
		model.addAttribute("list", list);

		return "hoadonban/order";
	}

	/**
	 * Adds the item form.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/createNewSalesOrderForm", method = RequestMethod.GET)
	public String addItemForm() {
		return "hoadonban/newSalesOrder";
	}

	/**
	 * Creates the new order.
	 *
	 * @param model
	 *            the model
	 * @param orderId
	 *            the order id
	 * @param custId
	 *            the cust id
	 * @param date
	 *            the date
	 * @param overDate
	 *            the over date
	 * @param note
	 *            the note
	 * @return the string
	 */
	@RequestMapping(value = "/createNewSalesOrder", method = RequestMethod.POST)
	public String createNewOrder(Model model,
			@RequestParam("orderId") String orderId,
			@RequestParam("custId") String custId,
			@RequestParam("date") String date,
			@RequestParam("overDate") String overDate,
			@RequestParam("note") String note) {
		// get customer by ID
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.findById(custId);
		System.out.println(date + "----" + overDate);
		// create saleOrder
		SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
		Date vDate = null;
		try {
			vDate = pattern.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date OverDate = null;
		try {
			OverDate = pattern.parse(overDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * Date vDate = new Date(pattern.format(date)); Date OverDate = new
		 * Date(pattern.format(overDate));
		 */
		SalesOrder saleOrder = new SalesOrder();
		saleOrder.setOrderNo(orderId);
		saleOrder.setCustomer(customer);
		saleOrder.setOrderDate(vDate);
		saleOrder.setOverDueDate(OverDate);
		saleOrder.setDescription(note);
		SalesOrderManagerBO salesOrderBO = new SalesOrderManagerBO();
		try {
			salesOrderBO.addSalesOrder(saleOrder);
			model.addAttribute("SUCCESS", "Thêm hóa đơn bán hàng thành công");
			return "hoadonban/newSalesOrder";
		} catch (Exception e) {
			model.addAttribute("ERROR", "Thêm hóa đơn bán hàng thất bại");
			return "hoadonban/newSalesOrder";
		}

	}

	/**
	 * Auto fill item.
	 *
	 * @param custId
	 *            the cust id
	 * @return the string
	 */
	@RequestMapping(value = "/autoFillCustName", method = RequestMethod.GET)
	@ResponseBody
	public String autoFillItem(@RequestParam("custId") String custId) {
		CustomerBO customer = new CustomerBO(custId);
		System.out.println("OK");
		System.out.println(customer.getJSONCustId(custId));
		return customer.getJSONCustId(custId);

	}
}