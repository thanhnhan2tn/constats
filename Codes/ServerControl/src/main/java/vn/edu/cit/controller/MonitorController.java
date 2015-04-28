package vn.edu.cit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.server.ServerConfig;

import org.apache.log4j.Logger;
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
public class MonitorController {
	@Autowired
	public ApplicationContext ctx; //
	public UserService userService = new UserService();
	public MongoOperations mongo = MongoDBService.getMongoService();
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/monitor/{action}/{ip}/{cc}", method = RequestMethod.GET)
	public String monitorAction(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "action") String action, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		String cc = (String) session.getAttribute("cc");
		User user = (
				User) session.getAttribute("user");

		// Server sv = new Server();
		if (user != null && c.equals(cc)) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					ServerConfig sf = new ServerConfig();
					if (action.equals("start")) {
						sf.startMonitor(server, 5);
					} else {
						try {
							sf.stopMonitor(server);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						}
					}
				}
			}
		} else {
			session.invalidate();
		}
		return "/monitor/" + ip + "/" + cc;
	}

	@RequestMapping(value = "/monitor/{ip}/{cc}", method = RequestMethod.GET)
	public String monitor(HttpServletRequest request, HttpSession session, 
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, ModelMap mm) {
		String cc = (String) session.getAttribute("cc");
		User user = (User) session.getAttribute("user");
		if (user != null && cc.equals(c)) {
			mm.put("ip",ip);
			return "monitor";
		}else{
			return "redirect:/login";
		}
	}

	private static final Logger _log = Logger.getLogger(MonitorController.class);
}
