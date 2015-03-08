package vn.edu.cit.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	public ApplicationContext ctx;

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
	public String register(HttpServletRequest request, ModelMap mm) {
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String passWord = request.getParameter("passwd");
		String hashPassWord = Calculator.MD5(passWord);
		int role = 1;
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		// query to search user
		Query searchQuery = new Query(Criteria.where("email").is(email));
		User avaiable = mongoOperation.findOne(searchQuery, User.class);
		if (avaiable != null) {
			mm.addAttribute("error", "Email is already exist!");
			return "redirect:/login#available";
		} else {
			User user = new User(email, hashPassWord, role, firstName, lastName);
			mongoOperation.insert(user, "users");
			return "redirect:/login#success";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		request.setAttribute("page", "login");
		return "home";
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		String err = null;
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		// query to search user
		Query searchQuery = new Query(Criteria.where("email").is(email));
		User avaiable = mongoOperation.findOne(searchQuery, User.class);
		if (avaiable == null) {
			err = "An email is not registered!";
			return "redirect:login#invalid-email";
		}

		if (Calculator.MD5(passwd).equals(avaiable.getPassWord())) {
			session.setAttribute("email", email);
			session.setAttribute("logined", true);
			return "redirect:/";
		} else {
			err = "Email or Password dose not match!";
			return "redirect:login#invalid-pass";
		}
	}
}
