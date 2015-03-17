package com.thanhnhantn.generate;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thanhnhantn.generate.components.Theme;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String filePath = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/")
				+ "/Theme-1.xml";
		Theme theme = null;
		try {
			theme = XmlThemeInstaller.xmlToTheme(new File(filePath));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("theme", theme);
		return "home";
	}
	
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(HttpServletRequest request){
		String str = (String) request.getParameter("input");
		System.out.println(str);
		request.setAttribute("output", str);
		return "home";
	}
}
