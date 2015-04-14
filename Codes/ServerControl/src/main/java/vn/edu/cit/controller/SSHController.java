package vn.edu.cit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ssh.SSH;
import model.ssh.SSHConfig;

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
public class SSHController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ServerDAO serverDAO;

	/**
	 * sshConfig, chuyen sang config page
	 * 
	 * @param request
	 * @param session
	 * @param ip
	 * @param c
	 * @param mm
	 * @param redirectAtt
	 * @return
	 */
	@RequestMapping(value = "/serviceconfig/ssh/{ip}/{cc}", method = RequestMethod.GET)
	public String sshConfig(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, RedirectAttributes redirectAtt) {
		User user = (User) session.getAttribute("user");
		String cc = (String) session.getAttribute("cc");
		// Kiem tra user va token
		if (user != null && cc.equals(c)) {
			// Lay thong tin server cua user
			Server server = serverDAO.getServer(user, ip);
			// Kiem tra thong tin Server
			if (server != null) {
				// Set sudo user cho server
				server.setServerUsername((String) session.getAttribute("sudouser"));
				server.setServerPassword((String) session.getAttribute("sudopass"));
				SSHConfig sshconfig = new SSHConfig();
				_log.info("Lay thong tin SSH config");
				_log.info("Doi user:" + server.getServerUsername());
				SSH ssh = sshconfig.convertTextToObjectSSH(server);

				mm.put("SSH", ssh);

				mm.put("server", server);
				return "ssh-config";
			} else {
				_log.info("Khong co server de hien thi");
				redirectAtt.addFlashAttribute("display", "block");
				redirectAtt.addFlashAttribute("message", "Vui lòng thêm Server để quản lý!");
				return "redirect:/";
			}
		} else {
			// neu chua login
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/serviceconfig/ssh/save/{ip}/{cc}", method = RequestMethod.POST)
	public String sshSaveConfig(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm, @ModelAttribute(value = "SSH") SSH ssh,
			RedirectAttributes redirectAtt) throws IOException {
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
			SSHConfig sshconfig = new SSHConfig();
			// kiem tra dich vu ftp

			mm.put("server", server);
			sshconfig.uploadConfigToServer(server, ssh);
			_log.info("Upload SSH Config to server ");
			redirectAtt.addFlashAttribute("displaysuccess", "block");
			redirectAtt.addFlashAttribute("message", "Cập nhật thành công! (Update Success!)");
			// chuyen ve trang
			return "redirect:/services/" + ip + "/" + c;

		} else {
			return "redirect:/login";
		}
	}

	private static final Logger _log = Logger.getLogger(SSHController.class);
}
