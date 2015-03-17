/*
 * Class name: WarehouseManagerController
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE             AUTHOR                  DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014   Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.htqlbh.business.StockBO;
import com.htqlbh.business.WarehouseInventoryBO;
import com.htqlbh.model.Stock;
import com.htqlbh.model.WarehouseInventory;

/**
 * The Class WarehouseManagerController. 
 * Handles requests for the application home page.
 * 
 * @author Pham Hoang Dieu
 */
@Controller
public final class WarehouseManagerController {

	/**
	 * Ds kiem ke.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/danhsachkiemke", method = RequestMethod.GET)
	public String dsKiemKe(Model model) {
		WarehouseInventoryBO warehouseInvtBO = new WarehouseInventoryBO();
		ArrayList<WarehouseInventory> wiList = warehouseInvtBO.getList();
		model.addAttribute("wiList", wiList);
		return "quanlykho/danhsachkiemke";
	}

	/**
	 * Tra ve danh sach kiem ke.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/nhapkiemke", method = RequestMethod.GET)
	public String traVe(Model model) {
		StockBO stockBO = new StockBO();
		ArrayList<Stock> stoList = stockBO.getList();
		model.addAttribute("stoList", stoList);
		return "quanlykho/nhapkiemke";
	}

	/**
	 * Nhap phieu kiem ke.
	 *
	 * @param model
	 *            the model
	 * @param maKiemKe
	 *            the ma kiem ke
	 * @param ngayKiemKe
	 *            the ngay kiem ke
	 * @param maKho
	 *            the ma kho
	 * @param maHang1
	 *            the ma hang1
	 * @param dvt1
	 *            the dvt1
	 * @param soLuong1
	 *            the so luong1
	 * @return the string
	 */
	@RequestMapping(value = "/nhapPhieuKiemKe", method = RequestMethod.POST)
	public String nhapPhieuKiemKe(Model model,
			@RequestParam(value = "maKiemKe") String maKiemKe,
			@RequestParam(value = "ngayKiemKe") String ngayKiemKe,
			@RequestParam(value = "maKho") String maKho,
			@RequestParam(value = "maHang1") String maHang1,
			@RequestParam(value = "dvt1") int dvt1,
			@RequestParam(value = "soLuong1") int soLuong1) {
		System.out.println(maKiemKe + " || " + ngayKiemKe + " || " + maKho
				+ " || " + maHang1 + " || " + dvt1 + " || " + soLuong1);

		WarehouseInventoryBO warehouseInvtBO = new WarehouseInventoryBO(
				maKiemKe, maKho, ngayKiemKe);
		warehouseInvtBO.add();

		return "quanlykho/nhapkiemke";
	}

}
