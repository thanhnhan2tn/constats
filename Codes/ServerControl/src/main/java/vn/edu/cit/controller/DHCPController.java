package vn.edu.cit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dhcp.ConfigChung;
import model.dhcp.DHCP;
import model.dhcp.DHCPConfig;
import model.dhcp.HostFixIP;
import model.dhcp.Subnet;
import model.server.ServerConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.cit.dao.ServerDAO;
import vn.edu.cit.dao.UserDAO;
import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;

@Controller
public class DHCPController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ServerDAO serverDAO;

	/**
	 * Install New DHCP Service
	 * 
	 */
	@RequestMapping(value = "/serviceconfig/dhcpinstall/{ip}/{cc}", method = RequestMethod.GET)
	public String dhcpSetup(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			DHCPConfig dhcpconfig = new DHCPConfig();
			ServerConfig serverConf = new ServerConfig();
			if (serverConf.checkSudoer(sv)) {
				if (dhcpconfig.Install(server)) { // return true
					_log.info("Install DHCP service ");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "(Install DHCP Success!)");
				} else {
					_log.info("Install DHCP service Failed");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message", "(Install DHCP failed!)");
				}
				return "redirect:/services/" + ip + "/" + c;
			} else {// check sudoer user
				return "redirect:/";
			}
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Transfer to DHCP Controller screen page
	 */

	@RequestMapping(value = "/serviceconfig/dhcp/{ip}/{cc}", method = RequestMethod.GET)
	public String dhctSetup(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			if (session.getAttribute("sudouser") != null) {
				Server server = serverDAO.getServer(user, ip);
				Server sv = new Server(server);
				sv.setServerUsername((String) session.getAttribute("sudouser"));
				sv.setServerPassword((String) session.getAttribute("sudopass"));
				_log.info(sv.getServerAddress() + sv.getServerPassword());
				// ServerConfig serverConf = new ServerConfig();
				DHCPConfig dhcp = new DHCPConfig();

				if (dhcp.checkInstall(sv) == true) {
					// Neu server da cai dat dhct
					try {
						DHCP d = dhcp.convertConfigToObjectDHCP(sv);
						mm.put("dhcp", d);
						mm.put("configchung", d.getConfigchung());
						session.setAttribute("dhcp", d);
					} catch (IOException e) {
						_log.info("Fail load Config from server ");
						redirectAtt.addFlashAttribute("display", "block");
						redirectAtt.addFlashAttribute("message", "Khong the lay thong tin tu server!");
					}
				} else {
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message", "Chua cai dat dich vu ISC-DHCP-SERVER!");
				}
				mm.put("server", server);
				return "dhcp-config";
			}// test user sudoer
			else {
				return "redirect:/";
			}
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Cau hinh Subnet cua DHCP
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/subnets/{ip}/{cc}", method = RequestMethod.GET)
	public String dhctSetupSubnets(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, ModelMap mm,
			RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);
			if (session.getAttribute("sudouser") != null) {
				sv.setServerUsername((String) session.getAttribute("sudouser"));
				sv.setServerPassword((String) session.getAttribute("sudopass"));
				_log.info(sv.getServerAddress() + sv.getServerPassword());
				DHCPConfig dhcp = new DHCPConfig();

				if (dhcp.checkInstall(sv) == true) {
					// Neu server da cai dat dhct
					try {
						DHCP d = dhcp.convertConfigToObjectDHCP(sv);
						mm.put("dhcp", d);
						mm.put("subnets", d.getSubnets());
						session.setAttribute("dhcp", d);
						// Create Object to add subnet
						mm.put("subnetNew", new Subnet());

					} catch (IOException e) {
						_log.info("Fail load Config from server ");
						redirectAtt.addFlashAttribute("display", "block");
						redirectAtt.addFlashAttribute("message", "Khong the lay thong tin tu server!");
						return "dhcp-config";
					}
				} else {
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message", "Chua cai dat dich vu ISC-DHCP-SERVER!");
				}
				mm.put("server", server);
				return "dhcp-subnets-config";
			}// check Sudoer server user
			else {
				return "redirect:/";
			}
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Cau hinh Subnet cua DHCP
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/hostfixs/{ip}/{cc}", method = RequestMethod.GET)
	public String dhctSetupHostfixs(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, ModelMap mm,
			RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			_log.info(sv.getServerAddress() + sv.getServerPassword());
			DHCPConfig dhcp = new DHCPConfig();

			if (dhcp.checkInstall(sv) == true) {
				// Neu server da cai dat dhct
				try {
					DHCP d = dhcp.convertConfigToObjectDHCP(sv);
					mm.put("dhcp", d);
					mm.put("hostNew", new HostFixIP());
					mm.put("hostfixs", d.getHosts());
					session.setAttribute("dhcp", d);
				} catch (IOException e) {
					_log.info("Fail load Config from server ");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message", "Khong the lay thong tin tu server!");
					return "dhcp-config";
				}
			} else {
				redirectAtt.addFlashAttribute("display", "block");
				redirectAtt.addFlashAttribute("message", "Chua cai dat dich vu ISC-DHCP-SERVER!");
				return "dhcp-config";
			}
			mm.put("server", server);
			return "dhcp-hostfixs-config";
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Save DHCP config chung and upload tu Server controller
	 * 
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/save/{ip}/{cc}", method = RequestMethod.POST)
	public String dhctSaveConfigChung(
			@ModelAttribute(value = "configchung") ConfigChung configchung,
			// @ModelAttribute(value = "subnets") List<Subnet> subnets,
			// @ModelAttribute(value = "hostfixs") List<HostFixIP> hostfixs,
			HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			// Get dhcp in Session
			DHCP dhcpToConfig = (DHCP) session.getAttribute("dhcp");
			// Xoa ss sau khi tao doi tuong
			session.removeAttribute("dhcp");
			DHCPConfig dConfig = new DHCPConfig();
			// Save General config
			if (configchung != null) {
				dhcpToConfig.setConfigchung(configchung);
			}

			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			try {
				if (dConfig.uploadConfigToDHCPServer(sv, dhcpToConfig.getSubnets(), dhcpToConfig.getHosts(),
						dhcpToConfig.getConfigchung())) {
					_log.info("Upload DHCP Config to server");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "Save and Tranfer DHCP Config Success!");
				} else {
					_log.info("Fail upload DHCP Config to server ");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message",
							"Khong the cap nhat len server (Cannot update DHCP to server)!");
				}
			} catch (IOException e) {
				_log.info("Fail upload DHCP Config to server ");
				redirectAtt.addFlashAttribute("display", "block");
				redirectAtt.addFlashAttribute("message",
						"Khong the cap nhat len server (Cannot update DHCP to server)!");
			}
			mm.put("server", server);
			return "redirect:/serviceconfig/dhcp/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Save DHCP Subnets and upload tu Server controller
	 * 
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/subnets/save/{ip}/{cc}", method = RequestMethod.POST)
	public String dhctSaveSubnets(
			// @ModelAttribute(value = "configchung") ConfigChung configchung,
			@ModelAttribute(value = "dhcp") DHCP dhcp,
			// @ModelAttribute(value = "hostfixs") List<HostFixIP> hostfixs,
			HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			// Get dhcp in Session
			DHCP dhcpToConfig = (DHCP) session.getAttribute("dhcp");
			// Xoa ss sau khi tao doi tuong
			// session.removeAttribute("dhcp");

			DHCPConfig dConfig = new DHCPConfig();
			// Save ListSN
			if (dhcp.getSubnets() != null) {
				dhcpToConfig.setSubnets(dhcp.getSubnets());
			}

			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			try {
				if (dConfig.uploadConfigToDHCPServer(sv, dhcpToConfig.getSubnets(), dhcpToConfig.getHosts(),
						dhcpToConfig.getConfigchung())) {
					_log.info("Upload DHCP Config to server");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "Save and Tranfer Subnets Config Success!");
				} else {
					_log.info("Fail upload DHCP Config to server ");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message",
							"Khong the cap nhat len server (Cannot update DHCP Config to server)!");
				}
			} catch (IOException e) {
				_log.info("Fail upload DHCP Config to server ");
				redirectAtt.addFlashAttribute("display", "block");
				redirectAtt.addFlashAttribute("message",
						"Khong the cap nhat len server (Cannot update DHCP Config to server)!");
			}
			mm.put("server", server);
			return "redirect:/serviceconfig/dhcp/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * add DHCP Subnet and upload tu Server controller
	 * 
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/subnets/addsubnet/{ip}/{cc}", method = RequestMethod.POST)
	public String dhctAddSubnet(@ModelAttribute(value = "subnetNew") Subnet subnet, HttpServletRequest request,
			HttpSession session, @PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c,
			ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			// Get dhcp in Session
			// DHCP dhcpToConfig = (DHCP) session.getAttribute("dhcp");
			// Xoa ss sau khi tao doi tuong
			session.removeAttribute("dhcp");
			DHCPConfig dConfig = new DHCPConfig();

			// Save ListSN
			if (subnet != null) {
				Server server = serverDAO.getServer(user, ip);
				Server sv = new Server(server);
				sv.setServerUsername((String) session.getAttribute("sudouser"));
				sv.setServerPassword((String) session.getAttribute("sudopass"));
				if (dConfig.createSubnet(sv, subnet)) {
					_log.info("Upload DHCP Config to server");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "Save and Tranfer Subnets Config Success!");
				} else {
					_log.info("Fail upload DHCP Config to server ");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message",
							"Khong the cap nhat len server (Cannot update DHCP Config to server)!");
				}
				mm.put("server", server);
				return "redirect:/serviceconfig/dhcp/" + ip + "/" + c;
			}// subnet null
			return "redirect:/serviceconfig/dhcp/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Save DHCP Hostfixs and upload tu Server controller
	 * 
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/hostfixs/save/{ip}/{cc}", method = RequestMethod.POST)
	public String dhctSaveHostfixs(
			// @ModelAttribute(value = "configchung") ConfigChung configchung,
			// @ModelAttribute(value = "subnets") List<Subnet> subnets,
			@ModelAttribute(value = "dhcp") DHCP dhcp, HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, ModelMap mm,
			RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			// Get dhcp in Session
			DHCP dhcpToConfig = (DHCP) session.getAttribute("dhcp");
			// Xoa ss sau khi tao doi tuong
			session.removeAttribute("dhcp");
			DHCPConfig dConfig = new DHCPConfig();

			// Save ListSN
			if (dhcp.getHosts() != null) {
				dhcpToConfig.setHosts(dhcp.getHosts());
			}

			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			try {
				if (dConfig.uploadConfigToDHCPServer(sv, dhcpToConfig.getSubnets(), dhcpToConfig.getHosts(),
						dhcpToConfig.getConfigchung())) {
					_log.info("Upload DHCP Config to server");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "Save and Tranfer DHCP Hostfixs Config Success!");
				} else {
					_log.info("Fail upload DHCP Config to server ");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message",
							"Khong the cap nhat len server (Cannot update DHCP Config to server)!");
				}
			} catch (IOException e) {
				_log.info("Fail upload DHCP Config to server ");
				redirectAtt.addFlashAttribute("display", "block");
				redirectAtt.addFlashAttribute("message",
						"Khong the cap nhat len server (Cannot update DHCP Config to server)!");
			}
			mm.put("server", server);
			return "redirect:/serviceconfig/dhcp/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * add DHCP Subnet and upload tu Server controller
	 * 
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/hostfixs/addhostfix/{ip}/{cc}", method = RequestMethod.POST)
	public String dhctAddHostfix(@ModelAttribute(value = "hostfixNew") HostFixIP hostfix, HttpServletRequest request,
			HttpSession session, @PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c,
			ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			// Get dhcp in Session
			// DHCP dhcpToConfig = (DHCP) session.getAttribute("dhcp");
			// Xoa ss sau khi tao doi tuong
			session.removeAttribute("dhcp");
			DHCPConfig dConfig = new DHCPConfig();

			// Save ListSN
			if (hostfix != null) {
				Server server = serverDAO.getServer(user, ip);
				Server sv = new Server(server);
				sv.setServerUsername((String) session.getAttribute("sudouser"));
				sv.setServerPassword((String) session.getAttribute("sudopass"));
				if (dConfig.createHost(sv, hostfix)) {
					_log.info("Upload DHCP Config to server");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "Save and Tranfer Subnets Config Success!");
				} else {
					_log.info("Fail upload DHCP Config to server ");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message",
							"Khong the cap nhat len server (Cannot update DHCP Config to server)!");
				}
				mm.put("server", server);
				return "redirect:/serviceconfig/dhcp/" + ip + "/" + c;
			}// hostfix null
			return "redirect:/serviceconfig/dhcp/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
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
	@RequestMapping(value = "/serviceconfig/dhcp/file/{ip}/{cc}", method = RequestMethod.GET)
	public String editDHCPConfigFile(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, ModelMap mm,
			RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// Lay doi tuong server trong CSDL
		// Khoi tao doi tuong Server
		// Server sv = new Server();
		// Xet user dang nhap va token
		if (user != null && c.equals(cc)) {
			// duyet danh sach server cua user
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);

			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			DHCPConfig dhcpConf = new DHCPConfig();
			try {
				String config = dhcpConf.loadConfigToPlainText(sv);
				mm.put("config", config);
			} catch (IOException e) {
				_log.info("Fail get DHCP Config from server ");
				redirectAtt.addFlashAttribute("display", "block");
				redirectAtt.addFlashAttribute("message", "Khong the lay thong tin Config tu Server!");
			}
			// Call function
			mm.put("cc", c);
			mm.put("title", "Edit DHCP File config - Server Control");
			mm.put("user", user);
			// mm.put("nics", nic);
			mm.put("server", sv);
			return "dhcp-file-config";

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
	@RequestMapping(value = "/serviceconfig/dhcp/file/{ip}/{cc}", method = RequestMethod.POST)
	public String saveConfigFile(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "ip") String ip, @PathVariable(value = "cc") String c, RedirectAttributes redirectAtt) {
		String cc = (String) session.getAttribute("cc");
		User user = (User) session.getAttribute("user");
		if (user != null && c.equals(cc)) { // check user login
			String config = (String) request.getParameter("config");
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server); // khoi tao server
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			DHCPConfig dhcpConf = new DHCPConfig();
			if (dhcpConf.uploadStringConfigToDHCPServer(sv, config)) {
				_log.info("Edit file DHCP service ");
				redirectAtt.addFlashAttribute("displaysuccess", "block");
				redirectAtt.addFlashAttribute("message", "Save File and Upload to Server Success!");
			} else {
				_log.info("Fail upload DHCP Config to server ");
				redirectAtt.addFlashAttribute("display", "block");
				redirectAtt.addFlashAttribute("message", "Fail upload DHCP Config to server!");
			}
		} else {
			session.invalidate();
			return "redirect:/login";
		} // end check user
		return "redirect:/serviceconfig/dhcp/" + ip + "/" + cc;
	}
	
	@RequestMapping(value = "/serviceconfig/dhcp/logs/{ip}/{cc}", method = RequestMethod.GET)
	public String dhcpLogs(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm){
		String cc = (String) session.getAttribute("cc");
		User user = (User) session.getAttribute("user");
		if (user != null && c.equals(cc)) { // check user login
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server); // khoi tao server
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			DHCPConfig dhcpConf = new DHCPConfig();
			String logs = dhcpConf.getLog(sv);
			
			if (logs != null) {
				mm.put("logs",logs);
				return "dhcp-logs";
			} else {
				mm.put("logs","Khong lay duoc thong tin");
				return "dhcp-logs";
			}
		} else {
			session.invalidate();
			return "redirect:/login";
		} // end check user
		
	}
	
	/**
	 * Lay log DHCP
	 * 
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @param redirectAtt
	 * @return
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/getlogs/{ip}/{cc}", method = RequestMethod.GET)
	@ResponseBody
	public String getDhcpLogs(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, RedirectAttributes redirectAtt) {
		String cc = (String) session.getAttribute("cc");
		User user = (User) session.getAttribute("user");
		if (user != null && c.equals(cc)) { // check user login
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server); // khoi tao server
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			DHCPConfig dhcpConf = new DHCPConfig();
			String logs = dhcpConf.getLog(sv);
			if (logs != null) {
				return logs;
			} else {
				return "Khong lay duoc thong tin";
			}
		} else {
			return "Khong lay duoc thong tin";
		} // end check user
	}

	private static final Logger _log = Logger.getLogger(DHCPController.class);
}
