/*
 * Class name: HomeControllerTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE             AUTHOR                    DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014    Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.controller;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.htqlbh.controller.HomeController;

/**
 * The Class HomeControllerTest.
 * 
 * @author: Pham Hoang Dieu
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

	/** The request1. */
	@Mock private HttpServletRequest request1;
	
	/** The request2. */
	@Mock private HttpServletRequest request2;
	
	/** The request3. */
	@Mock private HttpServletRequest request3;
	
	/** The request4. */
	@Mock private HttpServletRequest request4;
	
	/** The request5. */
	@Mock private HttpServletRequest request5;
	
	/** The request6. */
	@Mock private HttpServletRequest request6;
	
	/** The session1. */
	@Mock private HttpSession session1;
	
	/** The session2. */
	@Mock private HttpSession session2;
	
	/** The session3. */
	@Mock private HttpSession session3;
	
	/** The session4. */
	@Mock private HttpSession session4;
	
	/** The session5. */
	@Mock private HttpSession session5;
	
	/** The session6. */
	@Mock private HttpSession session6;
    
	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		when(request1.getSession()).thenReturn(session1);
		when(request2.getSession()).thenReturn(session2);
		when(request3.getSession()).thenReturn(session3);
		when(request4.getSession()).thenReturn(session4);
		when(request5.getSession()).thenReturn(session5);
		when(request6.getSession()).thenReturn(session6);
		
		when(session1.getAttribute("/")).thenReturn("index");
		when(session2.getAttribute("User")).thenReturn("home");
		
		when(session3.getAttribute("/index")).thenReturn("index");
		when(session4.getAttribute("User")).thenReturn("home");
		
		when(session5.getAttribute("/home")).thenReturn("index");
		when(session6.getAttribute("User")).thenReturn("home");
	}
	
	/**
	 * Test main.
	 */
	@Test
	public void testMain() {
		HomeController hc = new HomeController();
		Assert.assertEquals("index", hc.main(request1));
		Assert.assertEquals("home", hc.main(request2));
	}

	/**
	 * Test index.
	 */
	@Test
	public void testIndex() {
		HomeController hc = new HomeController();
		Assert.assertEquals("index", hc.index(request3));
		Assert.assertEquals("home", hc.index(request4));
	}

	/**
	 * Test home.
	 */
	@Test
	public void testHome() {
		HomeController hc = new HomeController();
		Assert.assertEquals("index", hc.home(request5));
		Assert.assertEquals("home", hc.home(request6));
	}

}
