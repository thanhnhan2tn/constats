
package vn.edu.cit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.dao.UserDAO;
import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;
import vn.edu.cit.servercontrol.Power;

@Controller
public class PowerController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/shutdown/{ip}/{cc}", method = RequestMethod.GET)
	public String shutdown(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c) {
		String username = (String) session.getAttribute("username");
		String cc = (String) session.getAttribute("cc");
		User user = userDAO.getUser(username);
		if (user != null && c.equals(cc)) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					Power.Shutdown(server);
				}
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/restart/{ip}/{cc}", method = RequestMethod.GET)
	public String restart(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		String username = (String) session.getAttribute("username");
		String cc = (String) session.getAttribute("cc");
		User user = userDAO.getUser(username);
		if (user != null && c.equals(cc)) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					Power.Restart(server);
				}
			}
		}
		return "redirect:/";
	}
}
