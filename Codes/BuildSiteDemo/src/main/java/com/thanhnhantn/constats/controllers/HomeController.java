package com.thanhnhantn.constats.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.thanhnhantn.constats.components.Theme;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	public ServletContext ctx;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		request.setAttribute("message", "");
		return "home";
	}

	@RequestMapping(value = "/themes", method = RequestMethod.GET)
	public String Theme(Model model) {
		return "theme";
	}

	@RequestMapping(value = "/themes/install", method = RequestMethod.GET)
	public ModelAndView themeInstall(HttpServletRequest request,
			HttpSession session) {
		String filePath = (String) session.getAttribute("filePath");
		session.removeAttribute("filePath");
		System.out.println(filePath);
		Theme theme;
		try {
			theme = XmlThemeInstaller.xmlToTheme(new File(filePath));
			XmlThemeInstaller.themeToFiles(theme, request);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/");
	}
}
