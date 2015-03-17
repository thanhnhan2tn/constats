/*
 * Class name: ItemController
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE             AUTHOR                       DESCRIPTION
 *  --------------------------------------------------------
 * 1-August-2014   Tran Trong Nghia           Conltroller for ItemManager
 */
package com.htqlbh.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htqlbh.business.ItemManagerBO;
import com.htqlbh.model.Inventory;

/**
 * The Class ItemController. Handles requests for the application home page.
 * 
 * @author Tran Trong Nghia
 */

@Controller
public class ItemController {

	/**
	 * Return list of item - Tra ve danh sach mat hang.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */

	@RequestMapping(value = "/itemList", method = RequestMethod.GET)
	public String itemList(Model model) {
		ItemManagerBO itemManager = new ItemManagerBO();
		// lay danh sach mat hang
		ArrayList<Inventory> listItem = itemManager.getItemList();
		// them danh sach vao model
		model.addAttribute("listItem", listItem);
		return "mathang/danhsachmathang";
	}

	/**
	 * ENG: Redirect to add items page VN: Chuyen den form them mat hang.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */

	@RequestMapping(value = "/addItemForm", method = RequestMethod.GET)
	public String addItemForm() {
		return "mathang/themmathang";
	}

	// them mot mat hang

	/**
	 * Adds the item - Them mot mat hang.
	 * 
	 * @param model
	 *            the model
	 * @param invtId
	 *            the invt id
	 * @param invtName
	 *            the invt name
	 * @param className
	 *            the class name
	 * @param unitT
	 *            the unit t
	 * @param unitRate
	 *            the unit rate
	 * @param salesPriceT
	 *            the sales price t
	 * @param unitL
	 *            the unit l
	 * @param salesPriceL
	 *            the sales price l
	 * @param slsTax
	 *            the sls tax
	 * @return the string
	 */

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(Model model, @RequestParam("invtId") String invtId,
			@RequestParam("invtName") String invtName,
			@RequestParam("className") String className,
			@RequestParam("unitT") String unitT,
			@RequestParam("unitRate") int unitRate,
			@RequestParam("salesPriceT") Long salesPriceT,
			@RequestParam("unitL") String unitL,
			@RequestParam("salesPriceL") Long salesPriceL,
			@RequestParam("slsTax") Long slsTax) {
		ItemManagerBO itemManager = new ItemManagerBO();
		try {
			itemManager.addItem(invtId, invtName, className, unitT, unitRate,
					salesPriceT, unitL, salesPriceL, slsTax);
			model.addAttribute("SUCCESS", "Thêm mặt hàng thành công");
			return "mathang/themmathang";
		} catch (Exception e) {
			model.addAttribute("ERROR", "Thêm mặt hàng thất bại");
			return "mathang/themmathang";
		}
	}

	/**
	 * Delete item - Xoa mot mat hang.
	 * 
	 * @param model
	 *            the model
	 * @param invtId
	 *            the invt id
	 * @return the string
	 */
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public String deleteItem(Model model, @RequestParam("invtId") String invtId) {
		ItemManagerBO itemManager = new ItemManagerBO();
		boolean result = itemManager.deleteItem(invtId);
		if (result) {
			model.addAttribute("SUCCESS", "Xóa mặt hàng thành công");
		} else {
			model.addAttribute("ERROR", "Xóa mặt hàng thất bại");
		}
		return "mathang/themmathang";
	}

	/**
	 * Get item by ID - Lay thong tin mat hang theo id.
	 * 
	 * @param invtId
	 *            the invt id
	 * @return the string - JSON
	 */
	@RequestMapping(value = "/autoFillItem", method = RequestMethod.POST)
	@ResponseBody
	public String autoFillItem(@RequestParam("invtId") String invtId) {
		ItemManagerBO itemManager = new ItemManagerBO();
		System.out.println("OK");
		return itemManager.getJSONItemById(invtId);
	}

}
