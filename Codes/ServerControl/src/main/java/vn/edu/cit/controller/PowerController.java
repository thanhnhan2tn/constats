
package vn.edu.cit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.server.ServerConfig;

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
	
	/**
	 * Shudown server
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @return
	 */
	@RequestMapping(value = "/services/shutdown/{ip}/{cc}", method = RequestMethod.GET)
	public String shutdown(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		//User user = userDAO.getUser(username);
		if (user != null && c.equals(cc)) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					Server sv = new Server(server);
					sv.setServerUsername((String) session.getAttribute("sudouser"));
					sv.setServerPassword((String) session.getAttribute("sudopass"));
					//Power.Shutdown(sv);
					ServerConfig config = new ServerConfig();
					config.Stop(sv);
				}
			}
		}
		return "redirect:/";
	}
	
	/**
	 * Khoi dong lai server
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @param mm
	 * @return
	 */
	@RequestMapping(value = "/services/restart/{ip}/{cc}", method = RequestMethod.GET)
	public String restart(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		//User user = userDAO.getUser(username);
		if (user != null && c.equals(cc)) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					Server sv = new Server(server);
					sv.setServerUsername((String) session.getAttribute("sudouser"));
					sv.setServerPassword((String) session.getAttribute("sudopass"));
					//Power.Restart(sv);
					ServerConfig config = new ServerConfig();
					config.Restart(sv);
				}
			}
		}
		return "redirect:/services/"+ip+"/"+cc;
	}
}
