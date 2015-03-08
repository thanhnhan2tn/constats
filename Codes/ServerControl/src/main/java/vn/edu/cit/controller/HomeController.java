package vn.edu.cit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		if (username != null) {
			request.setAttribute("page", "home");
			return "home";
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
//		UserRepository repository = null;
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
//		String firstName = request.getParameter("firstname");
//		String lastName = request.getParameter("lastname");
//		String passWord = request.getParameter("passwd");

		return "";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		request.setAttribute("page", "login");
		return "home";
	}

//	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
//	public String loginCheck(HttpServletRequest request) {
//		UserRepository repository = null;
//		HttpSession session = request.getSession();
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		repository.count();
//		boolean result = true;// = User.check(username, password);
//		if (result == true) {
//			session.setAttribute("username", username);
//			session.setAttribute("logined", true);
//			return "redirect:/home";
//		} else {
//			return "redirect:/";
//		}
//	}

}
