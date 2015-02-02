package com.example.hello;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		return "hello";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/Hello", method = RequestMethod.POST)
	public String hello(HttpServletRequest rs)
			throws IOException {
		String name = rs.getParameter("name");
		System.out.println(name);
		rs.setAttribute("name",name);
		return "result";
	}

}
