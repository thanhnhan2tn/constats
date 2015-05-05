package vn.edu.cit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.dao.UserDAO;
import vn.edu.cit.model.User;

@Controller
public class AdminController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/admincp", method = RequestMethod.GET)
	public String admin(ModelMap m, HttpSession session) {
		m.put("title", "AdminCP");
		User user = (User) session.getAttribute("user");
		if (user != null) {
			if (user.getRole() == 2) {
				m.put("overview", "active");
				return "admincp";
			} else {
				return "redirect:/login";
			}
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/admincp/user/{cc}", method = RequestMethod.GET)
	public String manager(ModelMap m, @PathVariable("cc") String c, HttpSession session) {
		m.put("title", "AdminCP");
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			List<User> users = userDAO.getUsers();
			m.put("users", users);
			m.put("user", "active");
			return "user";
		} else {
			return "redirect:/login";
		}
	}

	private static final Logger _log = Logger.getLogger(AdminController.class);
}
