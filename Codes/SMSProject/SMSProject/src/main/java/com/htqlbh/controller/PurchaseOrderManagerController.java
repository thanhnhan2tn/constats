/*
 * Class name: PurchaseOrderManagerController.java
 * 
 * Version information: 1.0
 *
 * Date: 1-Aug-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE         AUTHOR             DESCRIPTION
 *  --------------------------------------------------------
 *  1-Aug-2014    Nguyen Gia Trang    Controller purchase order
 */
package com.htqlbh.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.htqlbh.business.DistributorPaymentBO;
import com.htqlbh.business.PurchaseOrderManagerBO;
import com.htqlbh.model.DistributorPayment;
import com.htqlbh.model.PurchaseOrder;

/**
 * The Class PurchaseOrderManagerController.
 * 
 * @author Nguyen Gia Trang
 */
@Controller
public class PurchaseOrderManagerController {

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */

	@RequestMapping(value = "/PurchaseOrder", method = RequestMethod.GET)
	public String purchaseOrder(Model model) {
		return "hoadonmua/nhapHD";
	}

	/**
	 * Adds the purchase order.
	 *
	 * @param model
	 *            the model
	 * @param orderNo
	 *            the order no
	 * @param orderDate
	 *            the order date
	 * @param discAmt
	 *            the disc amt
	 * @param taxAmt
	 *            the tax amt
	 * @param totalAmt
	 *            the total amt
	 * @return the string
	 */
	@RequestMapping(value = "/addPurchaseOrder", method = RequestMethod.POST)
	public String addPurchaseOrder(Model model,
			@RequestParam("orderNo") String orderNo,
			@RequestParam("orderDate") String orderDate,
			@RequestParam("discAmt") Long discAmt,
			@RequestParam("taxAmt") Long taxAmt,
			@RequestParam("totalAmt") Long totalAmt) {
		PurchaseOrderManagerBO orderBO = new PurchaseOrderManagerBO(orderNo,
				orderDate, discAmt, taxAmt, totalAmt);
		orderBO.addPurchaseOrder();
		model.addAttribute("Success", "Lưu hóa đơn thành công");
		return "hoadonmua/nhapHD";

	}

	/**
	 * Purchase order list.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/PurchaseOrderList", method = RequestMethod.GET)
	public String PurchaseOrderList(Model model) {

		PurchaseOrderManagerBO orderManager = new PurchaseOrderManagerBO();
		ArrayList<PurchaseOrder> listOrder = orderManager
				.getPurchaseOrderList();
		model.addAttribute("listOrder", listOrder);

		return "hoadonmua/dsHD";
	}

	/**
	 * Distributor payment.
	 *
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/DistributorPayment", method = RequestMethod.GET)
	public String DistributorPayment(Model model) {

		return "hoadonmua/ttNPP";
	}

	/**
	 * Adds the distributor payment.
	 *
	 * @param model
	 *            the model
	 * @param dPaymentNo
	 *            the d payment no
	 * @param dPaymentDate
	 *            the d payment date
	 * @param dPaymentAmt
	 *            the d payment amt
	 * @return the string
	 */
	@RequestMapping(value = "/addDistributorPayment", method = RequestMethod.POST)
	public String addDistributorPayment(Model model,
			@RequestParam("dPaymentNo") String dPaymentNo,
			@RequestParam("dPaymentDate") String dPaymentDate,
			@RequestParam("dPaymentAmt") Long dPaymentAmt) {
		DistributorPaymentBO distributorBO = new DistributorPaymentBO(
				dPaymentNo, dPaymentDate, dPaymentAmt);
		distributorBO.addDistributorPayment();
		model.addAttribute("Success", "Lưu hóa đơn thành công");
		return "hoadonmua/ttNPP";
	}

	/**
	 * Distributor payment list.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/DistributorPaymentList", method = RequestMethod.GET)
	public String DistributorPaymentList(Model model) {

		DistributorPaymentBO disPayment = new DistributorPaymentBO();
		ArrayList<DistributorPayment> listPayment = disPayment
				.getDistributorPaymentList();
		model.addAttribute("listPayment", listPayment);

		return "hoadonmua/dsHDTT";
	}

	/**
	 * Distributor return product.
	 *
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/DistributorReturnProduct", method = RequestMethod.GET)
	public String DistributorReturnProduct(Model model) {

		return "hoadonmua/nppTraHang";
	}

}
