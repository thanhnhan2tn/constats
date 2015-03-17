/*
 * Class name: LoginController
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE            AUTHOR                      DESCRIPTION
 *  --------------------------------------------------------
 * 1-August-2014   Tran Trong Nghia               Controller Login
 */
package com.htqlbh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.htqlbh.business.LoginServiceBO;

/**
 * The LoginController class. Handles requests for the application home page.
 * 
 * @author Tran Trong Nghia
 */
@Controller
public class LoginController {

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @param userName
	 *            the user name
	 * @param password
	 *            the password
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginServiceBO loginService = new LoginServiceBO();
		if (loginService.validateUser(userName, password)) {
			session.setAttribute("User", userName);
			String redirectUrl = "/home";
			return "redirect:" + redirectUrl;
		}
		String redirectUrl = "/index";
		return "redirect:" + redirectUrl;
	}

	/**
	 * Logout.
	 * 
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("User") != null) {
			session.removeAttribute("User");
		}
		String redirectUrl = "/index";
		return "redirect:" + redirectUrl;
	}

}
