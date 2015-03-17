/*
 * Class name: ItemManagerBO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE            AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 * 1-August-2014  Tran Trong Nghia           Use for Manager Item
 */
package com.htqlbh.business;

import java.util.ArrayList;

import com.htqlbh.dao.InventoryDAO;
import com.htqlbh.dao.UnitDAO;
import com.htqlbh.model.Inventory;
import com.htqlbh.value.IConstant;

/**
 * The Class ItemManagerBO.
 * 
 * @author Tran Trong Nghia
 */
public class ItemManagerBO {

	/** The inventory dao. */
	private InventoryDAO inventoryDAO;

	/** The unit dao. */
	private UnitDAO unitDAO;

	/**
	 * The Constructor.
	 */
	public ItemManagerBO() {
		this.inventoryDAO = new InventoryDAO();
		this.unitDAO = new UnitDAO();
	}

	/**
	 * Gets the item list.
	 * 
	 * @return the item list
	 */
	public ArrayList<Inventory> getItemList() {
		return (ArrayList<Inventory>) inventoryDAO.getListItem();
	}

	/**
	 * Adds the item - Them mat hang
	 * 
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
	 */
	public void addItem(String invtId, String invtName, String className,
			String unitT, int unitRate, Long salesPriceT, String unitL,
			Long salesPriceL, Long slsTax) {
		// kiem tra ma hang
		Inventory inventory = inventoryDAO.findById(invtId);
		if (inventory == null) {
			inventory = new Inventory();
			inventory.setStatus(IConstant.UNACTIVE);
		}
		inventory.setInvtId(invtId);
		inventory.setInvtName(invtName);
		inventory.setClassName(className);

		// neu unitT chua ton tai
		if (unitDAO.getFristByUnitName(unitT) == null) {
			unitDAO.addUnit(unitT);
		}
		// neu unitL chua ton tai
		if (unitDAO.getFristByUnitName(unitL) == null) {
			unitDAO.addUnit(unitL);
		}
		inventory.setUnitIdT(unitDAO.getFristByUnitName(unitT));
		inventory.setUnitIdL(unitDAO.getFristByUnitName(unitL));
		inventory.setSalesPriceT(salesPriceT);
		inventory.setSalesPriceL(salesPriceL);
		inventory.setUnitRate(unitRate);
		inventory.setSlsTax(slsTax);

		// luu vao CSDL
		inventoryDAO.addItem(inventory);
	}

	/**
	 * Delete item - Xoa mat hang
	 * 
	 * @param invtId
	 *            the invt id
	 * @return true, if delete item
	 */
	public boolean deleteItem(String invtId) {
		Inventory inventory = inventoryDAO.findById(invtId);

		if ((inventory != null)
				&& !IConstant.ACTIVE.equals(inventory.getStatus())) {
			// truong hop inventory khac null va khong co giao dich
			inventoryDAO.deleteItem(inventory);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the json item by id.
	 * 
	 * @param id
	 *            the id
	 * @return the String JSON item by id
	 */
	public String getJSONItemById(String id) {
		Inventory inventory = inventoryDAO.findById(id);
		String result = "";
		if (inventory != null) {
			result += "{";
			result += "\"invtId\": " + "\"" + inventory.getInvtId() + "\", ";
			result += "\"invtName\": " + "\"" + inventory.getInvtName()
					+ "\", ";
			;
			result += "\"className\": " + "\"" + inventory.getClassName()
					+ "\", ";
			;
			result += "\"unitT\": " + "\""
					+ inventory.getUnitIdT().getUnitName() + "\", ";
			;
			result += "\"unitRate\": " + "\"" + inventory.getUnitRate()
					+ "\", ";
			;
			result += "\"salesPriceT\": " + "\"" + inventory.getSalesPriceT()
					+ "\", ";
			;
			result += "\"unitL\": " + "\""
					+ inventory.getUnitIdL().getUnitName() + "\", ";
			;
			result += "\"salesPriceL\": " + "\"" + inventory.getSalesPriceL()
					+ "\", ";
			;
			result += "\"slsTax\": " + "\"" + inventory.getSlsTax() + "\"";
			;
			result += "}";
		}
		return result;
	}

}
