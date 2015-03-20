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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.cit.dao.UserDAO;
import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;
import vn.edu.cit.services.MongoDBService;
import vn.edu.cit.services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// @Autowired
	// public ApplicationContext ctx; //
	// public UserService userService = new UserService();
	// public MongoOperations mongo = MongoDBService.getMongoService();
	@Autowired
	private UserDAO userDAO;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpSession session,
			ModelMap mm) {
		// Lay thong tin user tu Session
		String username = (String) session.getAttribute("username");
		// Su dung thong tin tu session de lay Doi tuong
		User user = userDAO.getUser(username);
		// Neu user tong tai, thi tra ve file home, set doi tuong server
		if (user != null) {
			mm.put("title", "Home - Server Control");
			mm.put("Server", new Server());
			mm.put("user", user);
			return "home";
		} else {
			// Neu user khong ton tai, xoa het session dang co, va redirect ve
			// Login
			session.invalidate();
			return "redirect:/login";
		}
	}

	@RequestMapping("/errorPage")
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String showErrorPage() {
		return "errorPage";
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
		// Nhan vao thong tin dang ki tai khoan
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String passWord = request.getParameter("passwd");
		// Ma hoa MD5 cho password
		String hashPassWord = Calculator.MD5(passWord);
		int role = 1; // role mac dinh khi dang ki l� 1 (member)
		List<Server> servers = new ArrayList<Server>();
		// Tim kim va khoi tao User neu co san trong DB
		User avaiable = userDAO.getUser(email);
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
			User user = new User(email, hashPassWord, role, firstName,
					lastName, servers);
			// Chen vao DB
			// mongoOperation.insert(user, "users");
			userDAO.createUser(user);
			// Tra ve thong bao dang ki thanh cong, yeu cau dang nhap
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"Account created successfully!");
			// Kiem tra, tra ve login neu user da ton tai
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap mm) {
		mm.put("User", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute(value = "User") User user,
			ModelMap mm, HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAtt) {
		// Lay thong tin IP cua nguoi dung
		String remoteAddress = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest().getRemoteAddr();
		// Get thong tin user tu Database
		User avaiable = userDAO.getUser(user.getEmail());
		if (avaiable == null) {
			// Neu khong co user nao co email dang nhap
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"An email is not registered!");
			return "redirect:/login";
		} else if (Calculator.MD5(user.getPassWord()).equals(
				avaiable.getPassWord())) {
			// kiem tra so sanh password neu dung
			session.setAttribute("username", avaiable.getEmail());
			session.setAttribute("cc",
					Calculator.MD5(avaiable.getEmail() + remoteAddress));
			_log.info("user login success. userEmail = " + user.getEmail());
			return "redirect:/";
		} else {
			// neu sai password
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"Email or Password dose not match!");
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request, ModelMap mm,
			HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public String forgot(HttpServletRequest request,
			RedirectAttributes redirectAtt) {
		String email = (String) request.getAttribute("email");
		// MongoOperations mongoOperation = (MongoOperations) ctx
		// .getBean("mongoTemplate");
		// // query to search user
		// Query searchQuery = new Query(Criteria.where("email").is(email));
		// User avaiable = mongoOperation.findOne(searchQuery, User.class);
		// Lay thong tin user
		User avaiable = userDAO.getUser(email);
		if (avaiable == null) {
			redirectAtt.addFlashAttribute("display", "block");
			redirectAtt.addFlashAttribute("message",
					"An email is not registered!");
			// request.setAttribute("message", "An email is not registered!");
			return "redirect:/login";
		} else {
			// Ham gui email
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
	public String addServer(@ModelAttribute(value = "Server") Server server,
			HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAtt) {
		String sessionUser = (String) session.getAttribute("username");

		if (sessionUser != null && !sessionUser.isEmpty()) {
			User user = userDAO.getUser(sessionUser);

			if (user != null) {
				List<Server> listServer = user.getServers();
				listServer.add(server);// Add Server to list
				user.setServers(listServer);// Set list server to user
				// Save user info
				userDAO.updateUser(user);
				redirectAtt.addFlashAttribute("message", "AddServer");
			}
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}

	/*
	 * Add Server controller
	 */
	@RequestMapping(value = "/removeserver/{ip}/{cc}", method = RequestMethod.GET)
	public String removeServer(@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, HttpServletRequest request,
			HttpSession session, RedirectAttributes redirectAtt) {
		String username = (String) session.getAttribute("username");
		if (username != null) {
			User user = userDAO.getUser(username);
			if (user != null) {
				List<Server> listServer = user.getServers();
				if (!listServer.isEmpty()) {
					for (int i = 0; i < listServer.size(); i++) {
						if (listServer.get(i).getServerAddress().equals(ip)) {
							// Xoa mot server trong list
							listServer.remove(i);
						}
					}
				}
				// dua danh sach server da sua chua vao user
				user.setServers(listServer);
				// Save user info
				userDAO.updateUser(user);
			}// end check
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}

	private static final Logger _log = Logger.getLogger(HomeController.class);
}
