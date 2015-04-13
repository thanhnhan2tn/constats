package vn.edu.cit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ftp.Ftp;
import model.ftp.FtpConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		Server server = serverDAO.getServer(user, ip);
		server.setServerUsername((String)session.getAttribute("sudouser"));
		server.setServerPassword((String)session.getAttribute("sudopass"));
		System.out.println(server.getServerUsername());
		FtpConfig ftp = new FtpConfig();
		if(ftp.checkInstall(server)==true){
			//Neu server da cai dat FTP
			mm.put("Ftp", ftp.convertTextToObject(server));
		}
		mm.put("server", server);
		return "ftp-config";
	}
	
	/**
	 * Ftp Save
	 * 
	 * @return ftp-config
	 */
	@RequestMapping(value = "/serviceconfig/ftp/save/{ip}/{cc}", method = RequestMethod.POST)
	public String ftpSaveConfig(HttpServletRequest request, HttpSession session, @PathVariable(value = "ip") String ip,
			@PathVariable(value = "cc") String c, ModelMap mm) {
		User user = (User) session.getAttribute("user");
		Server server = serverDAO.getServer(user, ip);
		server.setServerUsername((String)session.getAttribute("sudouser"));
		server.setServerPassword((String)session.getAttribute("sudopass"));
		System.out.println(server.getServerUsername());
		FtpConfig ftp = new FtpConfig();
		if(ftp.checkInstall(server)==true){
			//Neu server da cai dat FTP
			mm.put("Ftp", ftp.convertTextToObject(server));
		}
		mm.put("server", server);
		return "ftp-config";
	}

}
