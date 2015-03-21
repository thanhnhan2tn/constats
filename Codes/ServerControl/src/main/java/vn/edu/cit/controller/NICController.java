package vn.edu.cit.controller;

import java.io.IOException;

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
import vn.edu.cit.servercontrol.nic.Nic;
import vn.edu.cit.servercontrol.nic.NicConfig;

@Controller
public class NICController {
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/serviceconfig/nic/{ip}/{cc}", method = RequestMethod.GET)
	public String service(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm)
			throws IOException {
		String username = (String) session.getAttribute("username");
		String cc = (String) session.getAttribute("cc");
		// Lay doi tuong server trong CSDL
		User user = userDAO.getUser(username);
		// Khoi tao doi tuong Server
		Server sv = new Server();
		// Xet user dang nhap va token
		if (user != null && c.equals(cc)) {
			// duyet danh sach server cua user
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					sv = server;
					break;
				}
			}
			NicConfig nic_c = new NicConfig();
			Nic nic = nic_c.convertXMLToObject(sv);
			mm.put("cc", c);
			mm.put("title", "Home - Server Control");
			mm.put("user", user);
			mm.put("nics", nic);
			mm.put("server", sv);
			return "nic-config";
		} else {
			// Neu user khong co trong session hoac token sai
			session.invalidate();
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/serviceconfig/nic/{action}/{ip}/{if}/{cc}", method = RequestMethod.GET)
	public String controlNIC(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "action") String action,
			@PathVariable(value = "ip") String ip,
			@PathVariable(value = "if") String iface,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		if (action.equals("stop")) {
			System.out.println("Stop : " + ip + ",iface: " + iface);
		} else if (action.equals("start")) {
			System.out.println("Start : " + ip + ",iface: " + iface);
		} else if (action.equals("restart")) {
			System.out.println("Restart : " + ip + ",iface: " + iface);
		} else {
			return "redirect:/serviceconfig/nic/" + ip + "/" + c;
		}
		return "redirect:/serviceconfig/nic/" + ip + "/" + c;
	}

	@RequestMapping(value = "/serviceconfig/nic/save/{ip}", method = RequestMethod.POST)
	public String saveNIC(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip) {
		String iface = request.getParameter("iface");
		String inet = request.getParameter("iface");
		String address = request.getParameter("address");
		String netmask = request.getParameter("netmask");
		String gateway = request.getParameter("gateway");
		String network = request.getParameter("network");
		String broadcast = request.getParameter("broadcast");
		String dns_nameservers = request.getParameter("dns_nameservers");

		String cc = request.getParameter("cc");
		System.out.println(ip + "," + iface + "," + inet + "," + address + ","
				+ gateway + "," + cc);
		return "redirect:/serviceconfig/nic/" + ip + "/" + cc;
	}
}
