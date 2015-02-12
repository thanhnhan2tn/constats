/*
 * Class name: HomeController
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
 *  1-August-2014  Pham Hoang Dieu          Create java class file
 */
package com.htqlbh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class HomeController. Handles requests for the application home page.
 * 
 * @author Pham Hoang Dieu
 */
@Controller
public class HomeController {

	/**
	 * Main.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String redirectUrl = new String();
		// kiem tra session
		if (session.getAttribute("User") == null) {
			redirectUrl = "index";
		} else {
			redirectUrl = "home";
		}
		return redirectUrl;
	}

	/**
	 * Index.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		// get session
		HttpSession session = request.getSession();
		String redirectUrl = new String();
		// kiem tra session
		if (session.getAttribute("User") == null) {
			redirectUrl = "index";
		} else {
			redirectUrl = "home";
		}
		return redirectUrl;
	}

	/**
	 * Home.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		// get session
		HttpSession session = request.getSession();
		String redirectUrl = new String();
		// kiem tra session
		if (session.getAttribute("User") == null) {
			redirectUrl = "index";
		} else {
			redirectUrl = "home";
		}
		return redirectUrl;
	}

}
