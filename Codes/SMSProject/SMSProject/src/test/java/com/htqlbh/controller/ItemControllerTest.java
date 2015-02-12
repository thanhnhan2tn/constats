/*
 * Class name: ItemControllerTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *       DATE             AUTHOR                    DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014     Tran Trong Nghia         Create java class file
 */

package com.htqlbh.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

/**
 * The Class ItemControllerTest.
 *
 * @author Tran Trong Nghia
 */
public class ItemControllerTest {

    /** The item controller. */
    private ItemController itemController;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
	itemController = new ItemController();
    }

    /**
     * Test method for
     * {@link com.htqlbh.controller.ItemController#itemList(org.springframework.ui.Model)}
     * .
     */
    @Test
    public void testItemList() {
	assertEquals(itemController.itemList(new ExtendedModelMap()),
		"mathang/danhsachmathang");
    }

    /**
     * Test method for
     * {@link com.htqlbh.controller.ItemController#addItemForm()}.
     */
    @Test
    public void testAddItemForm() {
	assertEquals(itemController.addItemForm(), "mathang/themmathang");
    }

    /**
     * Test method for
     * {@link com.htqlbh.controller.ItemController#addItem(org.springframework.ui.Model, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long)}
     * .
     */
    @Test
    public void testAddItem() {
	assertEquals(itemController.addItem(new ExtendedModelMap(), "testNo",
		"testName", "testclass", "testunitt", 434000000, new Long(
			"4323123456"), "testunitl", new Long(567),
		new Long(567)), "mathang/themmathang");
    }

    /**
     * Test method for
     * {@link com.htqlbh.controller.ItemController#deleteItem(org.springframework.ui.Model, java.lang.String)}
     * .
     */
    @Test
    public void testDeleteItem() {
	assertEquals(
		itemController.deleteItem(new ExtendedModelMap(), "testNo"),
		"mathang/themmathang");
	assertEquals(
		itemController.deleteItem(new ExtendedModelMap(), "testNoEror"),
		"mathang/themmathang");
    }

    /**
     * Test method for
     * {@link com.htqlbh.controller.ItemController#autoFillItem(java.lang.String)}
     * .
     */
    @Test
    public void testAutoFillItem() {
	assertEquals(
		itemController.autoFillItem("4InviId1"),
		"{\"invtId\": \"4InviId1\", \"invtName\": \"2Inventory Name\", \"className\": \"Class Nam3e\", \"unitT\": \"lon\", \"unitRate\": \"100\", \"salesPriceT\": \"155\", \"unitL\": \"thung\", \"salesPriceL\": \"122\", \"slsTax\": \"10\"}");
    }

}
