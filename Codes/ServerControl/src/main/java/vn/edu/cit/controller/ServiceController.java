package vn.edu.cit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.dao.UserDAO;
import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;
import vn.edu.cit.services.MongoDBService;
import vn.edu.cit.services.UserService;

@Controller
public class ServiceController {
	@Autowired
	public ApplicationContext ctx; //
	public UserService userService = new UserService();
	public MongoOperations mongo = MongoDBService.getMongoService();
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/shutdown/{ip}/{cc}", method = RequestMethod.GET)
	public String shutdown(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c) {
		User user = userDAO.getUser(username);
		if (user != null && c.equals(cc)) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					sv = server;
					break;
				}
			}
			mm.put("server", sv);
			return "service-config";
		} else {

		}
		return "redirect:/";
	}

	@RequestMapping(value = "/restart/{ip}/{cc}", method = RequestMethod.GET)
	public String restart(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		System.out.println(ip);
		return "redirect:/";
	}

	@RequestMapping(value = "/serviceconfig/{name}/{ip}/{cc}", method = RequestMethod.GET)
	public String service(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "name") String configname,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		String username = (String) session.getAttribute("username");
		String cc = (String) session.getAttribute("cc");
		User user = userDAO.getUser(username);
		Server sv = new Server();
		if (user != null && c.equals(cc)) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					sv = server;
					break;
				}
			}
			mm.put("server", sv);
			return "service-config";
		} else {
			return "redirect:/";
		}
	}
}
