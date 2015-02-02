package com.edu.vn;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(HttpServletRequest request) {
		// logger.info("Welcome home! The client locale is {}.", locale);
		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
		 * locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 */
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"Beans.xml"));

		Button obj = (Button) factory.getBean("button");
		String chuoi = obj.getChuoi();

		request.setAttribute("name", chuoi);

		// --------------
		XmlBeanFactory factory1 = new XmlBeanFactory(new ClassPathResource(
				"Beans.xml"));

		Button obj1 = (Button) factory1.getBean("button2");
		String chuoi1 = obj1.getChuoi();

		request.setAttribute("name1", chuoi1);

		// tra loi goi ve file khac home.jsp se chay dc nhe
		return "index0";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String ConvertXmlToObject(HttpServletRequest request) {
		// -----------XML to Object------------------
		Button btn1 = JAXBExample.jaxbXMLToObject();

		request.setAttribute("name2", btn1.getChuoi());
		return "index";

	}
}
