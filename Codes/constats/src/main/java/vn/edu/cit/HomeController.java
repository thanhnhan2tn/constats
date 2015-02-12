package vn.edu.cit;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.model.Server;
import vn.edu.cit.servercontrol.Power;
import vn.edu.cit.servercontrol.nics_controller.Nic;
import vn.edu.cit.servercontrol.nics_controller.Nics;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "home";
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "home";
	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.GET)
	public String loginCheck(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean result = true;// = User.check(username, password);
		if (result == true) {
			session.setAttribute("username", username);
			session.setAttribute("logined", true);
			return "redirect:/home";
		} else {
			return "redirect:/";
		}
	}

}
