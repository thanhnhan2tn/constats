package vn.edu.cit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.cit.model.Server;
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
	public String home(HttpServletRequest request, HttpSession session,
			ModelMap mm) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			request.setAttribute("page", "home");
			mm.put("title", "Home - Server Control");
			mm.put("Server", new Server());
			return "home";
		} else {
			return "redirect:/login";
		}

	}

	/**
	 * Dang ki tai khoan Controller
	 * 
	 * @param request
	 * @param mm
	 * @return refirect Attributes:
	 *         http://docs.spring.io/spring/docs/3.2.x/javadoc
	 *         -api/org/springframework
	 *         /web/servlet/mvc/support/RedirectAttributes.html
	 *
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, ModelMap mm,
			RedirectAttributes redirectAtt) {
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String passWord = request.getParameter("passwd");
		String hashPassWord = Calculator.MD5(passWord);
		int role = 1;
		/*
		 * MongoOperation lay du lieu tu Bean xml, tu Aplication Context
		 */
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		// query to search user with Email
		Query searchQuery = new Query(Criteria.where("email").is(email));
		// Tim kim va khoi tao User neu co san trong DB
		User avaiable = mongoOperation.findOne(searchQuery, User.class);
		// Neu tim thay thong tin, tra ve thong bao tai khoan da co
		if (avaiable != null) {
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt
					.addFlashAttribute(
							"message",
							"Email is already exist, Are you "
									+ "	<a href=\"#\" onClick=\"$('#loginbox').hide();"
									+ " $('#fogotpassword').show()\">Forgot password?</a>?");
			// Kiem tra, tra ve login neu user da ton tai
			return "redirect:/login";
		} else {
			// Khoi tao Doi tuong User voi thong tin dang ki moi
			User user = new User(email, hashPassWord, role, firstName, lastName);
			// Chen vao DB
			mongoOperation.insert(user, "users");
			// Tra ve thong bao dang ki thanh cong, yeu cau dang nhap
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"Account created successfully!");
			// Kiem tra, tra ve login neu user da ton tai
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap mm,
			RedirectAttributes redirectAtt) {
		mm.put("User", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute(value = "User") User user,
			ModelMap mm, HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAtt) {
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		// query to search user
		Query searchQuery = new Query(Criteria.where("email").is(
				user.getEmail()));
		User avaiable = mongoOperation.findOne(searchQuery, User.class);
		if (avaiable == null) {
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"An email is not registered!");
			return "redirect:/login";
		} else if (Calculator.MD5(user.getPassWord()).equals(
				avaiable.getPassWord())) {
			session.setAttribute("user", avaiable);
			System.out.println("Login success!");
			_log.info("user login success. userEmail = " + user.getEmail());
			return "redirect:/";
		} else {
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"Email or Password dose not match!");
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request, ModelMap mm,
			HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/login";
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public String forgot(HttpServletRequest request,
			RedirectAttributes redirectAtt) {
		String email = (String) request.getAttribute("email");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		// query to search user
		Query searchQuery = new Query(Criteria.where("email").is(email));
		User avaiable = mongoOperation.findOne(searchQuery, User.class);
		if (avaiable == null) {
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"An email is not registered!");
			// request.setAttribute("message", "An email is not registered!");
			return "redirect:/login";
		} else {

			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"Password has been sent to your email!");
			return "redirect:/login";
		}
	}

	/*
	 * Add Server controller
	 */
	@RequestMapping(value = "/addserver", method = RequestMethod.POST)
	public ModelAndView addServer(
			@ModelAttribute(value = "Server") Server server,
			HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAtt) {
		ModelAndView mav = new ModelAndView();
		List<Server> listServer = new ArrayList<Server>();
		listServer.add(server);

		User sessionUser = (User) session.getAttribute("user");
		MongoOperations mongoOperations =(MongoOperations)ctx.getBean("mongoTemplate");
		//
		Query searchQuery = new Query(Criteria.where("email").is(sessionUser.getEmail()));
		User user = mongoOperations.findOne(searchQuery, User.class);
		if (user != null) {
			user.setServer(listServer);
			mongoOperations.save(user);
			redirectAtt.addFlashAttribute("message","AddServer Cu");
		}
		mav.addObject("list", listServer);
		mav.setViewName("");
		return mav;
	}
	
	private static final Logger _log = Logger.getLogger(HomeController.class);
}
