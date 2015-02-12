/*
 * Class name: WMControllerTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE            AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.controller;


import org.junit.Assert;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

import com.htqlbh.controller.WarehouseManagerController;

/**
 * The Class WMControllerTest.
 * 
 * @author Pham Hoang Dieu
 */
public class WMControllerTest {

	/**
	 * Test ds kiem ke.
	 */
	@Test
	public void testDsKiemKe() {
		WarehouseManagerController wic = new WarehouseManagerController();
		Assert.assertEquals("quanlykho/danhsachkiemke", wic.dsKiemKe(new ExtendedModelMap()));
	}

	/**
	 * Test tra ve.
	 */
	@Test
	public void testTraVe() {
		WarehouseManagerController wic = new WarehouseManagerController();
		Assert.assertEquals("quanlykho/nhapkiemke", wic.traVe(new ExtendedModelMap()));
	}

	/**
	 * Test nhap phieu kiem ke.
	 */
	@Test
	public void testNhapPhieuKiemKe() {
		WarehouseManagerController wic = new WarehouseManagerController();
		Assert.assertEquals("quanlykho/nhapkiemke", wic.nhapPhieuKiemKe(new ExtendedModelMap(), "4123", "2013-01-02", "1", "001", 1, 3));
	}

}
