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
 * The Class Unit.
 */
public class Unit implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7912575903961381175L;

    /** The unit id. */
    private int unitId;

    /** The unit name. */
    private String unitName;

    /**
     * The Constructor.
     */
    public Unit() {
    }

    /**
     * The Constructor.
     * 
     * @param unitName
     *            the unit name
     */
    public Unit(String unitName) {
	this.unitName = unitName;
    }

    /**
     * Gets the unit id.
     * 
     * @return the unit id
     */
    public int getUnitId() {
	return unitId;
    }

    /**
     * Sets the unit id.
     * 
     * @param unitId
     *            the unit id
     */
    public void setUnitId(int unitId) {
	this.unitId = unitId;
    }

    /**
     * Gets the unit name.
     * 
     * @return the unit name
     */
    public String getUnitName() {
	return unitName;
    }

    /**
     * Sets the unit name.
     * 
     * @param unitName
     *            the unit name
     */
    public void setUnitName(String unitName) {
	this.unitName = unitName;
    }

}
