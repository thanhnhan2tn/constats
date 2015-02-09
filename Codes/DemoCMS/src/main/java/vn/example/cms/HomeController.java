package vn.example.cms;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.example.cms.components.Form;

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
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"demoCMS.xml"));

		Form form = (Form) factory.getBean("Form");
		// System.out.println(form.makeForm());
		String str = form.makeForm();
		request.setAttribute("str", str);
		return "home";
	}

}