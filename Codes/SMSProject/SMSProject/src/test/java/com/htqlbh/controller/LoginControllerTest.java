/*
 * Class name: LoginControllerTest
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *      DATE           AUTHOR                    DESCRIPTION
 *  --------------------------------------------------------
 *  1-August-2014  Tran Trong Nghia          Create java class file
 */

package com.htqlbh.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The Class LoginControllerTest.
 *
 * @author Tran Trong Nghia
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    /** The login controller. */
    LoginController loginController;

    /** The request. */
    @Mock
    private HttpServletRequest request;

    /** The session. */
    @Mock
    private HttpSession session;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
	when(request.getSession()).thenReturn(session);
	loginController = new LoginController();
    }

    /**
     * Test method for
     * {@link com.htqlbh.controller.LoginController#login(java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest)}
     * .
     */
    @Test
    public void testLogin() {
	assertEquals(loginController.login("nghia", "nghia", request),
		"redirect:/home");
	assertEquals(loginController.login("nghia", "1234", request),
		"redirect:/index");
    }

    /**
     * Test method for
     * {@link com.htqlbh.controller.LoginController#logout(javax.servlet.http.HttpServletRequest)}
     * .
     */
    @Test
    public void testLogout() {
	Assert.assertEquals(loginController.logout(request), "redirect:/index");
    }
}
