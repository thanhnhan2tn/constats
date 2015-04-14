package vn.edu.cit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ftp.Ftp;
import model.ftp.FtpConfig;

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
public class FTPController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ServerDAO serverDAO;

	/**
	 * Function ftpSetup
	 * 
	 * @author ThanhNhan
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @param mm
	 * @return String
	 */
	@RequestMapping(value = "/serviceconfig/ftpinstall/{ip}/{cc}", method = RequestMethod.GET)
	public String ftpSetup(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			for (Server server : user.getServers()) {
				if (server.getServerAddress().equals(ip)) {
					FtpConfig fconfig = new FtpConfig();
					fconfig.Install(server); // return true
				}
			}
			return "redirect:/services/" + ip + "/" + c;
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * Ftp Configuation
	 * 
	 * @return ftp-config
	 */
	@RequestMapping(value = "/serviceconfig/ftp/{ip}/{cc}", method = RequestMethod.GET)
	public String ftpConfig(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// Kiem tra user va token
		if (user != null && cc.equals(c)) {
			Server server = serverDAO.getServer(user, ip);
			server.setServerUsername((String) session.getAttribute("sudouser"));
			server.setServerPassword((String) session.getAttribute("sudopass"));
			System.out.println(server.getServerUsername());
			FtpConfig ftp = new FtpConfig();
			if (ftp.checkInstall(server) == true) {
				// Neu server da cai dat FTP
				mm.put("Ftp", ftp.convertTextToObject(server));
			}
			mm.put("server", server);
			return "ftp-config";
		} else {
			// neu chua login
			return "redirect:/login";
		}
	}

	/**
	 * Ftp Save, luu thong tin cua FTP len server
	 * 
	 * @return ftp-config
	 */
	@RequestMapping(value = "/serviceconfig/ftp/save/{ip}/{cc}", method = RequestMethod.POST)
	public String ftpSaveConfig(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, @ModelAttribute(value = "Ftp") Ftp ftp,
			RedirectAttributes redirectAtt) {
		// Lay thong tin user và token tren session
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// lay thong tin server cua user
		Server server = serverDAO.getServer(user, ip);
		// doi thong tin server sang sudoer user
		server.setServerUsername((String) session.getAttribute("sudouser"));
		server.setServerPassword((String) session.getAttribute("sudopass"));
		_log.info("Set new Sudoer password");
		// kiem tra thong tin user dang nhap
		if (user != null && cc.equals(c)) {
			FtpConfig ftpconfig = new FtpConfig();
			// kiem tra dich vu ftp
			if (ftpconfig.checkInstall(server) == true) {
				// Neu server da cai dat FTP
				mm.put("server", server);
				//
				try {
					ftpconfig.uploadConfigToServer(server, ftp);
					_log.info("Upload Config to server ");
					redirectAtt.addFlashAttribute("displaysuccess", "block");
					redirectAtt.addFlashAttribute("message", "Cập nhật thành công! (Update Success!)");
				} catch (IOException e) {
					_log.info("Fail upload Config to server ");
					redirectAtt.addFlashAttribute("display", "block");
					redirectAtt.addFlashAttribute("message", "Khong the cap nhat len server (Cannot update to server)!");
				}
				return "redirect:/services/" + ip + "/" + c;
			} else {
				mm.put("server", server);
				// neu chua cai dat, chuyen ve trang install
				return "ftp-config";
			}

		} else {
			return "redirect:/login";
		}
	}

	private static final Logger _log = Logger.getLogger(FTPController.class);
}
