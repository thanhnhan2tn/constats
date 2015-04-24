package vn.edu.cit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dhcp.ConfigChung;
import model.dhcp.DHCP;
import model.dhcp.DHCPConfig;
import model.dhcp.Subnet;
import model.dhcp.HostFixIP;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					DHCPConfig dhcpconfig = new DHCPConfig();
					if (dhcpconfig.Install(server)) { // return true
						_log.info("Install DHCP service ");
						redirectAtt.addFlashAttribute("displaysuccess", "block");
						redirectAtt.addFlashAttribute("message", "(Install DHCP Success!)");
					} else {
						_log.info("Install DHCP service Failed");
						redirectAtt.addFlashAttribute("display", "block");
						redirectAtt.addFlashAttribute("message", "(Install DHCP failed!)");
					}

				}
			}
			return "redirect:/services/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Transfer to DHCP Controller screen page
	 */

	@RequestMapping(value = "/serviceconfig/dhcp/{ip}/{cc}", method = RequestMethod.GET)
	public String ftpSetup(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, RedirectAttributes redirectAtt) {
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
				// Neu server da cai dat FTP
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
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Save DHCP config and upload tu Server controller
	 * 
	 */
	@RequestMapping(value = "/serviceconfig/dhcp/save/{ip}/{cc}", method = RequestMethod.GET)
	public String ftpSaveSetup(@ModelAttribute(value = "configchung") ConfigChung configchung,
			@ModelAttribute(value = "subnets") List<Subnet> subnets,
			@ModelAttribute(value = "hostfixs") List<HostFixIP> hostfixs,
			HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		if (user != null && cc.equals(c)) {
			// Get dhcp in Session
			DHCP dhcpToConfig = (DHCP) session.getAttribute("dhcp");
			DHCPConfig dConfig = new DHCPConfig();
			// Save General config
			if (configchung != null) {
				dhcpToConfig.setConfigchung(configchung);
			}
			//Save ListSN
			if(subnets!=null){
				dhcpToConfig.setSubnets(subnets);
			}
			//Save ListSN
			if(hostfixs!=null){
				dhcpToConfig.setHosts(hostfixs);
			}
			
			Server server = serverDAO.getServer(user, ip);
			Server sv = new Server(server);
			sv.setServerUsername((String) session.getAttribute("sudouser"));
			sv.setServerPassword((String) session.getAttribute("sudopass"));
			try {
				if(dConfig.uploadConfigToDHCPServer(sv, subnets, hostfixs, dhcpToConfig.getConfigchung())){
					_log.info("Upload DHCP Config to server");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "Setup VSFTPD Success!");
				}else{
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
			
			return "redirect:/services/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
	}

	private static final Logger _log = Logger.getLogger(DHCPController.class);
}
