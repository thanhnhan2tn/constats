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

/**
 * The Class WarehouseInventoryDetail.
 */
public class WarehouseInventoryDetail implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6860215658164889656L;

	/** The id. */
    private int id;
    
    /** The inventory. */
    private Inventory inventory;
    
    /** The warehouse inventory. */
    private WarehouseInventory warehouseInventory;
    
    /** The unit. */
    private Unit unit;
    
    /** The qty. */
    private Integer qty;

    /**
     * The Constructor.
     */
    public WarehouseInventoryDetail() {
    }

    /**
     * The Constructor.
     *
     * @param id the id
     */
    public WarehouseInventoryDetail(int id) {
	this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Gets the inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory() {
	return inventory;
    }

    /**
     * Sets the inventory.
     *
     * @param inventory the inventory
     */
    public void setInventory(Inventory inventory) {
	this.inventory = inventory;
    }

    /**
     * Gets the warehouse inventory.
     *
     * @return the warehouse inventory
     */
    public WarehouseInventory getWarehouseInventory() {
	return warehouseInventory;
    }

    /**
     * Sets the warehouse inventory.
     *
     * @param warehouseInventory the warehouse inventory
     */
    public void setWarehouseInventory(WarehouseInventory warehouseInventory) {
	this.warehouseInventory = warehouseInventory;
    }

    /**
     * Gets the unit.
     *
     * @return the unit
     */
    public Unit getUnit() {
	return unit;
    }

    /**
     * Sets the unit.
     *
     * @param unit the unit
     */
    public void setUnit(Unit unit) {
	this.unit = unit;
    }

    /**
     * Gets the qty.
     *
     * @return the qty
     */
    public Integer getQty() {
	return qty;
    }

    /**
     * Sets the qty.
     *
     * @param qty the qty
     */
    public void setQty(Integer qty) {
	this.qty = qty;
    }

}
