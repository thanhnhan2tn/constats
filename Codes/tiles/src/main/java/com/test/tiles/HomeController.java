package com.test.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String index() {
		return "home";
	}

	@RequestMapping(value = "index")
	public ModelAndView index(Model model) {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "list")
	public ModelAndView viewPersons(Model model) {
		return new ModelAndView("list");
	}

}