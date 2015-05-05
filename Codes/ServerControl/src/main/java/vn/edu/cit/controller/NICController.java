package vn.edu.cit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.nic.Eth;
import model.nic.Nic;
import model.nic.NicConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.cit.dao.UserDAO;
import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;

@Controller
public class NICController {
	@Autowired
	private UserDAO userDAO;

	/**
	 * NetworkInterfaces
	 * 
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @param mm
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/serviceconfig/nic/interfaces/{ip}/{cc}", method = RequestMethod.GET)
	public String networkInterfaces(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, ModelMap mm)
			throws IOException {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// Lay doi tuong server trong CSDL

		// Khoi tao doi tuong Server
		Server sv = new Server();
		// Xet user dang nhap va token
		if (user != null && c.equals(cc)) {
			// duyet danh sach server cua user
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					sv = new Server(server);
					break;
				}
			}
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			System.out.println(sv.getServerUsername());
			NicConfig nicConfig = new NicConfig();
			Nic nic = nicConfig.convertXMLToObject(sv); // Call function
			mm.put("cc", c);
			mm.put("title", "Home - Server Control");
			mm.put("user", user);
			session.setAttribute("nics", nic);
			mm.put("server", sv);
			Nic nicForm = new Nic(); // put a nic object to form
			nicForm.setEth(nic.getEth()); // truyen vao nicForm danh sach cac
											// eth
			mm.put("nicForm", nicForm);
			return "nic-config";
		} else {
			// Neu user khong co trong session hoac token sai
			session.invalidate();
			return "redirect:/login";
		}
	}

	/**
	 * Change NameServer Function
	 * 
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @param mm
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/serviceconfig/nic/nameservers/{ip}/{cc}", method = RequestMethod.GET)
	public String nameServers(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) throws IOException {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// Lay doi tuong server trong CSDL
		// Khoi tao doi tuong Server
		Server sv = new Server();
		// Xet user dang nhap va token
		if (user != null && c.equals(cc)) {
			// duyet danh sach server cua user
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					sv = new Server(server);
					break;
				}
			}
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			System.out.println(sv.getServerUsername());
			NicConfig nicConfig = new NicConfig();

			Nic nic = nicConfig.convertXMLToObject(sv);
			// Call function
			mm.put("cc", c);
			mm.put("title", "Home - Server Control");
			mm.put("user", user);
			// mm.put("nics", nic);
			mm.put("server", sv);
			session.setAttribute("nics", nic);
			Nic nicForm = new Nic(); // put a nic object to form
			nicForm.setDns_nameservers(nic.getDns_nameservers());
			// truyen vao
			mm.put("nicForm", nicForm);
			return "nameservers-config";
		} else {
			// Neu user khong co trong session hoac token sai
			session.invalidate();
			return "redirect:/login";
		}
	}

	/**
	 * ServiceConfig, basic control to service: stop, start..
	 * 
	 * @param request
	 * @param session
	 * @param action
	 * @param ip
	 * @param iface
	 * @param c
	 * @param mm
	 * @return
	 */
	@RequestMapping(value = "/serviceconfig/nic/{action}/{ip}/{if}/{cc}", method = RequestMethod.GET)
	public String controlNIC(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "action") String action, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "if") String iface, @PathVariable(value = "cc") String c, ModelMap mm) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// Lay doi tuong server trong CSDL
		// check User and token
		if (user != null && c.equals(cc)) {
			// Khoi tao doi tuong Server
			Server server = user.getServerByIp(ip);
			if (server != null) {
				Server sv = new Server(server);
				sv.setServerUsername((String) session.getAttribute("sudouser"));
				sv.setServerPassword((String) session.getAttribute("sudopass"));
				NicConfig nicConfig = new NicConfig();
				if (action.equals("stop")) {
					nicConfig.Stop(sv);
					// Log
					System.out.println("Stop : " + ip + ",iface: " + iface);
				} else if (action.equals("start")) {
					nicConfig.Start(sv);
					// Log
					System.out.println("Start : " + ip + ",iface: " + iface);
				} else if (action.equals("restart")) {
					nicConfig.Stop(sv);
					nicConfig.Start(sv);
					// Log
					System.out.println("Restart : " + ip + ",iface: " + iface);
				} else if (action.equals("remove")) {
					try {
						nicConfig.removeEthOrDNS(sv, nicConfig.convertXMLToObject(sv), null, iface);
						System.out.println("Delete : " + ip + ",iface: " + iface);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Delete : " + ip + ",iface: " + iface);
				} else {
					return "redirect:/serviceconfig/nic/" + ip + "/" + c;
				}
				return "redirect:/serviceconfig/nic/interfaces/" + ip + "/" + c;
			}
			return "redirect:/serviceconfig/nic/interfaces/" + ip + "/" + c;
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/serviceconfig/nic/save/{ip}/{cc}", method = RequestMethod.POST)
	public String saveNIC(@ModelAttribute(value = "nicForm") Nic nic, HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c,RedirectAttributes redirectAtt) {
		String cc = (String) session.getAttribute("cc");
		User user = (User) session.getAttribute("user");
		if (user != null) { // check user login
			if (c.equals(cc)) {
				Nic nicToConfig = (Nic) session.getAttribute("nics");

				List<Eth> eths = nic.getEth();
				// Save Network Interface
				if (eths != null && eths.size() > 0) {
					nicToConfig.setEth(eths);
				}
				// Save DNS NameServer
				List<String> dnsNameservers = nic.getDns_nameservers();
				if (dnsNameservers != null && dnsNameservers.size() > 0) {
					nicToConfig.setDns_nameservers(dnsNameservers);
				}
				for (Server server : user.getServers()) {
					if (server.getServerAddress().equals(ip)) {
						Server sv = new Server(server);
						NicConfig nicConfig = new NicConfig();
						try {
							sv.setServerUsername((String) session.getAttribute("sudouser"));
							sv.setServerPassword((String) session.getAttribute("sudopass"));
							nicConfig.uploadConfigToServer(sv, nicToConfig);
							_log.info("NIC Config save to server ");
							redirectAtt.addFlashAttribute("displaysuccess", "block");
							redirectAtt.addFlashAttribute("message",
									"Save File and Upload network/interfaces to Server Success!");
						} catch (IOException e) {
							_log.info("NIC Config save to server ");
							redirectAtt.addFlashAttribute("display", "block");
							redirectAtt.addFlashAttribute("message",
									"Fail to Upload network/interfaces to Server!");
							return "redirect:/services/" + ip + "/" + cc;
							// Thong bao khong the upload
						}
					}
				}

				session.removeAttribute("nics"); // remove session for nics
			} else {
				session.invalidate();
				return "redirect:/login";
			} // end check token
		} // end check user
		return "redirect:/services/" + ip + "/" + cc;
	}

	/**
	 * Redirect to Edit File
	 * 
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @return
	 */
	@RequestMapping(value = "/serviceconfig/nic/edit-file-nic/{ip}/{cc}", method = RequestMethod.GET)
	public String editConfigFile(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, ModelMap mm) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// Lay doi tuong server trong CSDL
		// Khoi tao doi tuong Server
		// Server sv = new Server();
		// Xet user dang nhap va token
		if (user != null && c.equals(cc)) {
			// duyet danh sach server cua user
			Server sv = new Server();
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					sv = new Server(server);
					sv.setServerUsername((String) session.getAttribute("sudouser"));
					sv.setServerPassword((String) session.getAttribute("sudopass"));
					NicConfig nicConfig = new NicConfig();
					//System.out.println(sv.getServerUsername());
					String config = nicConfig.loadConfigToPlainText(sv);
					mm.put("config", config);
					break;
				}
			}

			// Call function
			mm.put("cc", c);
			mm.put("title", "Home - Server Control");
			mm.put("user", user);
			// mm.put("nics", nic);
			mm.put("server", sv);

			return "nic-edit-config-file";

		} else {
			session.invalidate();
			return "redirect:/login";
		}
	}

	/**
	 * Save File to Config controller
	 * 
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @return
	 */
	@RequestMapping(value = "/serviceconfig/nic/edit-file-nic/{ip}/{cc}", method = RequestMethod.POST)
	public String saveConfigFile(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, RedirectAttributes redirectAtt) {
		String cc = (String) session.getAttribute("cc");
		User user = (User) session.getAttribute("user");
		if (user != null && c.equals(cc)) {
			// Nic nicToConfig = (Nic) session.getAttribute("nics");
			String config = (String) request.getParameter("config");

			// duyet danh sach server cua user
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					Server sv = new Server(server); // get server Object
					NicConfig nicConfig = new NicConfig();
					sv.setServerUsername((String) session.getAttribute("sudouser"));
					sv.setServerPassword((String) session.getAttribute("sudopass"));
					try {
						nicConfig.uploadStringConfigToServer(sv, config);
						_log.info("NIC Config save to server ");
						redirectAtt.addFlashAttribute("displaysuccess", "block");
						redirectAtt.addFlashAttribute("message",
								"Save File and Upload network/interfaces to Server Success!");
					} catch (IOException e) {
						_log.info("Fail load Config from server ");
						redirectAtt.addFlashAttribute("display", "block");
						redirectAtt.addFlashAttribute("message", "Khong the lay thong tin tu server!");
						return "redirect:/services/" + ip + "/" + cc;
						// Thong bao khong the upload
					}
				}
			}
			session.removeAttribute("nics"); // remove session for nics
		} else {
			session.invalidate();
			return "redirect:/login";
		} // end check token
		return "redirect:/services/" + ip + "/" + cc;
	}

	private static final Logger _log = Logger.getLogger(NICController.class);
}
