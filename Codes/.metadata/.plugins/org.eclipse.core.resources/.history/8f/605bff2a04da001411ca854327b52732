package model.apache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.ftp.Ftp;
import model.server.Server;
import model.ssh.SSH;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class ApacheConfig {

	// Start
	public Boolean Start(Server sv) {
		String command = "sudo service vsftpd start";
		String boo = LoadOrUpConfigFromServer(sv, command);
		if (!boo.equals(null)) {
			System.out.println("Start Suscess!!!\n");
			System.out.println(boo);

			return true;
		} else {
			System.out.println("Start Failed!!!");

			return false;
		}
	}

	// Stop
	public Boolean Stop(Server sv) {
		String command = "sudo service vsftpd stop";
		String boo = LoadOrUpConfigFromServer(sv, command);
		if (!boo.equals(null)) {
			System.out.println("Stop Suscess!!!\n");
			System.out.println(boo);

			return true;
		} else {
			System.out.println("Stop Failed!!!");

			return false;
		}
	}

	// Restart
	public Boolean Restart(Server sv) {
		String command = "sudo service vsftpd restart";
		String boo = LoadOrUpConfigFromServer(sv, command);
		if (!boo.equals(null)) {
			System.out.println("Restart Suscess!!!\n");
			System.out.println(boo);

			return true;
		} else {
			System.out.println("Restart Failed!!!");

			return false;
		}
	}

	// State
	public Boolean getState(Server sv) {
		String command = "sudo service vsftpd status";
		String boo = LoadOrUpConfigFromServer(sv, command);
		if (!boo.equals(null)) {
			System.out.println(boo);
			return true;

		} else {
			System.out.println(boo);
			return false;

		}
	}

	// a2ensite to enable VitualHost
	public boolean enableVirtualHost(Server sv, String fileNameVitual) {
		String command = "sudo a2ensite " + fileNameVitual;
		LoadOrUpConfigFromServer(sv, command);

		return true;
	}

	// Tao thu muc chua file web moi khi them vao 1 document root
	public boolean createDirectory(Server sv, Directory direc) {
		String config_direc = "";
		if (direc.getPathFile() != null && !direc.getPathFile().equals("")) {
			config_direc = config_direc + "'<Directory '" + direc.getPathFile()
					+ "'>'" + "'\n'";
		}

		if (direc.getOptions() != null && !direc.getOptions().equals("")) {
			config_direc = config_direc + "Options " + direc.getOptions()
					+ "'\n'";
		}

		if (direc.getAllowOverride() != null
				&& !direc.getAllowOverride().equals("")) {
			config_direc = config_direc + "AllowOverride "
					+ direc.getAllowOverride() + "'\n'";
		}

		if (direc.getRequireAll() != null && !direc.getRequireAll().equals("")) {
			config_direc = config_direc + "Require " + direc.getRequireAll()
					+ "'\n'";
		}

		if (direc.getOrder() != null && !direc.getOrder().equals("")) {
			config_direc = config_direc + "Order " + direc.getOrder() + "'\n'";
		}

		if (direc.getAllow() != null && !direc.getAllow().equals("")) {
			config_direc = config_direc + "Allow " + direc.getAllow() + "'\n'";
		}

		if (direc.getDeny() != null && !direc.getDeny().equals("")) {
			config_direc = config_direc + "Deny " + direc.getDeny() + "'\n'";
		}
		config_direc = config_direc + "'</Directory>'" + "'\n'";
		config_direc = config_direc + "'\n'";

		String command = "sudo echo -e >> /etc/apache2/apache2.conf  "
				+ config_direc;
		LoadOrUpConfigFromServer(sv, command);

		return true;
	}

	// Create VirtualHost
	public Boolean createVirtualHost(Server sv, VirtualHost vth) {
		String config_vth = "";

		if (vth.getVitualhost() != null && !vth.getVitualhost().equals("")) {
			config_vth = config_vth + "'<VirtualHost '" + vth.getVitualhost()
					+ "'>'" + "'\n'";
		}
		if (vth.getServername() != null && !vth.getServername().equals("")) {

			config_vth = config_vth + "ServerName " + vth.getServername()
					+ "'\n'";
		}
		if (vth.getServeradmin() != null && !vth.getServeradmin().equals("")) {

			config_vth = config_vth + "ServerAdmin " + vth.getServeradmin()
					+ "'\n'";
		}
		if (vth.getDocumentRoot() != null && !vth.getDocumentRoot().equals("")) {

			config_vth = config_vth + "DocumentRoot " + vth.getDocumentRoot()
					+ "'\n'";
		}

		if (vth.getAlias() != null && !vth.getAlias().equals("")) {
			config_vth = config_vth + "Alias " + vth.getAlias() + "'\n'";
		}
		if (vth.getErrorLog() != null && !vth.getErrorLog().equals("")) {

			config_vth = config_vth + "ErrorLog " + vth.getErrorLog() + "'\n'";
		}
		if (vth.getCustomLog() != null && !vth.getCustomLog().equals("")) {

			config_vth = config_vth + "CustomLog " + vth.getCustomLog()
					+ "'\n'";
		}

		config_vth = config_vth + "'</VirtualHost>'" + "'\n'";
		System.out.println(config_vth);
		String cmd = "sudo echo -e >> /etc/apache2/sites-available/000-default.conf "
				+ config_vth;
		LoadOrUpConfigFromServer(sv, cmd);
		return true;

	}

	// Upload cmd / file to server
	public String LoadOrUpConfigFromServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			String chuoilay = "";
			String tong = "";
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(cmd);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					chuoilay = new String(tmp, 0, i);
					// System.out.print(chuoilay);
					tong = tong + chuoilay;

				}
				if (channel.isClosed()) {
					System.out.println("exit-status: "
							+ channel.getExitStatus());
					if (channel.getExitStatus() != 1) {
						System.out.println("Process Success !!!");
					} else {
						System.out.println("Process Failed !!!");

					}
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			return tong;
		} catch (Exception e) {
			return null;
		}
	}

	// load Config from /etc/apache2/apache2.conf to plainText
	public String loadConfigToPlainText(Server sv) {
		String kq = LoadOrUpConfigFromServer(sv,
				"cat /etc/apache2/apache2.conf");
		return kq;
	}

	// load config VitualHost to text
	public String loadConfigVirtualHostToPlainText(Server sv) {
		String kq = LoadOrUpConfigFromServer(sv,
				"cat /etc/apache2/sites-available/000-default.conf");
		return kq;
	}

	public List<VirtualHost> convertTextToVirtualHostObject(Server sv) {
		HashMap<String, String> hm1 = new HashMap<String, String>();
		List<VirtualHost> vitual_multi = new ArrayList<VirtualHost>();
		String chuoi = loadConfigVirtualHostToPlainText(sv);
		chuoi = chuanhoaChuoiVitualHost(chuoi);
		// System.out.println("In ra Chuoi da chuan hoa: \n" + chuoi);
		StringReader str = new StringReader(chuoi);
		BufferedReader br = new BufferedReader(str);
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				if (line.startsWith("VirtualHost")
						|| line.indexOf("ServerName") != -1
						|| line.indexOf("ServerAdmin") != -1
						|| line.indexOf("DocumentRoot") != -1
						|| line.indexOf("Alias") != -1
						|| line.indexOf("ErrorLog") != -1
						|| line.indexOf("CustomLog") != -1

				) {
					hm1.put(line.substring(0, line.indexOf(" ")).trim(), line
							.substring(line.indexOf(" ") + 1).trim());
				}

				if (line.endsWith("VirtualHost")) {
					VirtualHost vitualhost = new VirtualHost(
							hm1.get("VirtualHost"), hm1.get("ServerName"),
							hm1.get("ServerAdmin"), hm1.get("DocumentRoot"),
							hm1.get("Alias"), hm1.get("ErrorLog"),
							hm1.get("CustomLog"));
					hm1.put("VitualHost", null);
					hm1.put("ServerName", null);
					hm1.put("ServerAdmin", null);
					hm1.put("DocumentRoot", null);
					hm1.put("Alias", null);
					hm1.put("ErrorLog", null);
					hm1.put("CustomLog", null);

					vitual_multi.add(vitualhost);
				}

			}
			return vitual_multi;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String chuanhoaChuoiVitualHost(String chuoiCH) {

		try {

			StringReader str = new StringReader(chuoiCH);
			BufferedReader bufferedReader = new BufferedReader(str);
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				// Xoa bo nhung line la dong trong
				if (line.isEmpty()) {

					line = line.replaceAll("\\s+", "");

				}

				// xu ly ki tu < and >
				if (line.indexOf("<") != -1 && line.indexOf(">") != -1) {

					line = line.replaceAll("<", "");
					line = line.replaceAll(">", "");

				}
				// Cat bo line chua "#" dau dong
				if (line.indexOf("#") != -1) {
					line = "";
					// line = line.trim();
					// line = line.replaceAll("\\s+", null);
					// chuoilay = chuoilay + line;

				} else {
					chuoilay = chuoilay + line + "\n";
				}
			}
			str.close();

			return chuoilay.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;

	}

	// Chuan hoa PlainText tra ve Chuoi
	public String ChuanHoaChuoi(Server sv) {
		try {

			StringReader str = new StringReader(loadConfigToPlainText(sv));
			BufferedReader bufferedReader = new BufferedReader(str);
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				// Xoa bo nhung line la dong trong
				if (line.isEmpty()) {

					line = line.replaceAll("\\s+", "");

				}
				if (line.indexOf("<") != -1 && line.indexOf(">") != -1) {

					line = line.replaceAll("<", "");
					line = line.replaceAll(">", "");

				}
				// Cat bo line chua "#" dau dong
				if (line.indexOf("#") != -1) {
					line = "";
					// line = line.trim();
					// line = line.replaceAll("\\s+", null);
					// chuoilay = chuoilay + line;

				} else {
					chuoilay = chuoilay + line + "\n";
				}
			}
			str.close();

			return chuoilay.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	// Convert chuoi chuan hoa to Object Directory
	public List<Directory> convertTextToDirectoryObject(Server sv) {
		List<Directory> multi_direct = new ArrayList<Directory>();
		HashMap<String, String> hm1 = new HashMap<String, String>();
		try {

			StringReader str = new StringReader(ChuanHoaChuoi(sv));
			BufferedReader bufferedReader = new BufferedReader(str);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				// System.out.println(line);

				if (line.startsWith("Directory")
						|| line.indexOf("Options") != -1
						|| line.indexOf("AllowOverride") != -1
						|| line.indexOf("Require") != -1
						|| line.indexOf("Order") != -1
						|| line.indexOf("Deny") != -1
						|| line.indexOf("Allow") != -1) {
					hm1.put(line.substring(0, line.indexOf(" ")).trim(), line
							.substring(line.indexOf(" ") + 1).trim());
				}
				if (line.endsWith("Directory")) {
					Directory direc = new Directory(hm1.get("Directory"),
							hm1.get("Options"), hm1.get("AllowOverride"),
							hm1.get("Require"), hm1.get("Order"),
							hm1.get("Deny"), hm1.get("Allow"));
					// chuyen tat ca key ve null
					hm1.put("Directory", null);
					hm1.put("Options", null);
					hm1.put("AllowOverride", null);
					hm1.put("Require", null);
					hm1.put("Order", null);
					hm1.put("Deny", null);
					hm1.put("Allow", null);

					multi_direct.add(direc);
				}

			}
			str.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException str) {

		}
		// ----------------------------------------
		return multi_direct;

	}

	// Convert chuoi chuan hoa to Object Config Chung
	public ConfigChung convertTextToObjectConfigChung(Server sv) {

		try {
			StringReader str = new StringReader(ChuanHoaChuoi(sv));
			BufferedReader br = new BufferedReader(str);
			String line = "";
			HashMap<String, String> hm1 = new HashMap<String, String>();

			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.indexOf("Timeout") != -1
						|| line.indexOf("KeepAlive") != -1
						|| line.indexOf("MaxKeepAliveRequests") != -1
						|| line.indexOf("KeepAliveTimeout") != -1
						|| line.indexOf("ErrorLog") != -1
						|| line.indexOf("LogLevel") != -1) {
					hm1.put(line.substring(0, line.indexOf(" ")).trim(), line
							.substring(line.indexOf(" ") + 1).trim());
				}

			}
			str.close();
			ConfigChung cf_chung = new ConfigChung(null, hm1.get("Timeout"),
					hm1.get("KeepAlive"), hm1.get("MaxKeepAliveRequests"),
					hm1.get("KeepAliveTimeout"), hm1.get("ErrorLog"),
					hm1.get("LogLevel"));
			return cf_chung;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Upload and Xoa config to /etc/apache2/apache2.conf - upload/xoa pathFile
	// Directory
	public Boolean uploadConfigToApacheConfig(Server sv, ConfigChung cfchung,
			List<Directory> list_direc, String pathFile) {
		String config_tong = "";
		String config = "";
		String config_direc = "";
		System.out
				.println("------------------Uploading ConfigChung && Directory--------------- ");
		// in ra config chung
		if (cfchung.getPort() != null && !cfchung.getPort().equals("")) {
			config = config + "Port " + cfchung.getPort() + "'\n'";
		}
		if (cfchung.getTime_out() != null && !cfchung.getTime_out().equals("")) {

			config = config + "Timeout " + cfchung.getTime_out() + "'\n'";
		}
		if (cfchung.getPathErrorLog() != null
				&& !cfchung.getPathErrorLog().equals("")) {

			config = config + "ErrorLog " + cfchung.getPathErrorLog() + "'\n'";
		}
		if (cfchung.getLogLevel() != null && !cfchung.getLogLevel().equals("")) {

			config = config + "Loglevel " + cfchung.getLogLevel() + "'\n'";
		}
		if (cfchung.getKeepAlive() != null
				&& !cfchung.getKeepAlive().equals("")) {
			config = config + "KeepAlive " + cfchung.getKeepAlive() + "'\n'";
		}
		if (cfchung.getKeepAliveTimeout() != null
				&& !cfchung.getKeepAliveTimeout().equals("")) {

			config = config + "KeepAliveTimeout "
					+ cfchung.getKeepAliveTimeout() + "'\n'";
		}
		if (cfchung.getMaxKeepAliveRequest() != null
				&& !cfchung.getMaxKeepAliveRequest().equals("")) {

			config = config + "MaxKeepAliveRequests "
					+ cfchung.getMaxKeepAliveRequest() + "'\n'";
			config = config + "'\n'";
		}

		for (Directory direc : list_direc) {
			if (direc.getPathFile().equals(pathFile)) {
				continue;
			}
			if (direc.getPathFile() != null && !direc.getPathFile().equals("")) {
				config_direc = config_direc + "'<Directory '"
						+ direc.getPathFile() + "'>'" + "'\n'";
			}

			if (direc.getOptions() != null && !direc.getOptions().equals("")) {
				config_direc = config_direc + "Options " + direc.getOptions()
						+ "'\n'";
			}

			if (direc.getAllowOverride() != null
					&& !direc.getAllowOverride().equals("")) {
				config_direc = config_direc + "AllowOverride "
						+ direc.getAllowOverride() + "'\n'";
			}

			if (direc.getRequireAll() != null
					&& !direc.getRequireAll().equals("")) {
				config_direc = config_direc + "Require "
						+ direc.getRequireAll() + "'\n'";
			}

			if (direc.getOrder() != null && !direc.getOrder().equals("")) {
				config_direc = config_direc + "Order " + direc.getOrder()
						+ "'\n'";
			}

			if (direc.getAllow() != null && !direc.getAllow().equals("")) {
				config_direc = config_direc + "Allow " + direc.getAllow()
						+ "'\n'";
			}

			if (direc.getDeny() != null && !direc.getDeny().equals("")) {
				config_direc = config_direc + "Deny " + direc.getDeny()
						+ "'\n'";
			}
			config_direc = config_direc + "'</Directory>'" + "'\n'";
			config_direc = config_direc + "'\n'";
		}
		String config_include = "AccessFileName .htaccess " + "'\n'"
				+ "PidFile '${APACHE_PID_FILE}'" + "'\n'"
				+ "Mutex file:'${APACHE_LOCK_DIR}' default" + "'\n'"
				+ "Include ports.conf " + "'\n'"
				+ "IncludeOptional conf-enabled/*.conf" + "'\n'"
				+ "IncludeOptional sites-enabled/*.conf" + "'\n'"
				+ "IncludeOptional mods-enabled/*.load" + "'\n'"
				+ "IncludeOptional mods-enabled/*.conf" + "'\n'" + "'\n'";
		config_tong = "sudo echo -e  > /etc/apache2/apache2.conf "
				+ config_include + config + config_direc;
		// System.out.println("Config tong" + config_tong);
		LoadOrUpConfigFromServer(sv, config_tong);

		return true;
	}

	// Upload config to /etc/apache2/sites-available/000-default.conf
	public Boolean uploadConfigToVirtualHostConfig(Server sv,
			List<VirtualHost> list_vitul) {
		System.out
				.println("------------------Uploading Vitualhost--------------- ");

		String config_vth = "";
		for (VirtualHost vth : list_vitul) {
			if (vth.getVitualhost() != null && !vth.getVitualhost().equals("")) {
				config_vth = config_vth + "'<VirtualHost '"
						+ vth.getVitualhost() + "'>'" + "'\n'";
			}
			if (vth.getServername() != null && !vth.getServername().equals("")) {

				config_vth = config_vth + "ServerName " + vth.getServername()
						+ "'\n'";
			}
			if (vth.getServeradmin() != null
					&& !vth.getServeradmin().equals("")) {

				config_vth = config_vth + "ServerAdmin " + vth.getServeradmin()
						+ "'\n'";
			}
			if (vth.getDocumentRoot() != null
					&& !vth.getDocumentRoot().equals("")) {

				config_vth = config_vth + "DocumentRoot "
						+ vth.getDocumentRoot() + "'\n'";
			}

			if (vth.getAlias() != null && !vth.getAlias().equals("")) {
				config_vth = config_vth + "Alias " + vth.getAlias() + "'\n'";
			}
			if (vth.getErrorLog() != null && !vth.getErrorLog().equals("")) {

				config_vth = config_vth + "ErrorLog " + vth.getErrorLog()
						+ "'\n'";
			}
			if (vth.getCustomLog() != null && !vth.getCustomLog().equals("")) {

				config_vth = config_vth + "CustomLog " + vth.getCustomLog()
						+ "'\n'";
			}

			config_vth = config_vth + "'</VirtualHost>'" + "'\n'";

		}
		config_vth = "sudo echo -e  > /etc/apache2/sites-available/000-default.conf "
				+ config_vth;

		// config_vth = "sudo echo -e  > /home/mayb/vitul.txt " + config_vth;
		LoadOrUpConfigFromServer(sv, config_vth);

		return true;
	}

	// Xoa vitual host
	// Upload config to /etc/apache2/sites-available/000-default.conf
	public Boolean XoaVitulHost(Server sv, List<VirtualHost> list_vitul,
			String serverName) {
		System.out
				.println("------------------Uploading Vitualhost--------------- ");

		String config_vth = "";
		for (VirtualHost vth : list_vitul) {
			System.out.println(vth.getServername());
			if (vth.getServername() == null) {
			} else {
				if (vth.getServername().equals(serverName)) {
					continue;
				}
			}

			if (vth.getVitualhost() != null && !vth.getVitualhost().equals("")) {
				config_vth = config_vth + "'<VirtualHost '"
						+ vth.getVitualhost() + "'>'" + "'\n'";
			}
			if (vth.getServername() != null && !vth.getServername().equals("")) {

				config_vth = config_vth + "ServerName " + vth.getServername()
						+ "'\n'";
			}
			if (vth.getServeradmin() != null
					&& !vth.getServeradmin().equals("")) {

				config_vth = config_vth + "ServerAdmin " + vth.getServeradmin()
						+ "'\n'";
			}
			if (vth.getDocumentRoot() != null
					&& !vth.getDocumentRoot().equals("")) {

				config_vth = config_vth + "DocumentRoot "
						+ vth.getDocumentRoot() + "'\n'";
			}

			if (vth.getAlias() != null && !vth.getAlias().equals("")) {
				config_vth = config_vth + "Alias " + vth.getAlias() + "'\n'";
			}
			if (vth.getErrorLog() != null && !vth.getErrorLog().equals("")) {

				config_vth = config_vth + "ErrorLog " + vth.getErrorLog()
						+ "'\n'";
			}
			if (vth.getCustomLog() != null && !vth.getCustomLog().equals("")) {

				config_vth = config_vth + "CustomLog " + vth.getCustomLog()
						+ "'\n'";
			}

			config_vth = config_vth + "'</VirtualHost>'" + "'\n'";

		}

		config_vth = "sudo echo -e  > /etc/apache2/sites-available/000-default.conf "
				+ config_vth;

		// config_vth = "sudo echo -e  > /home/mayb/vitul.txt " + config_vth;
		LoadOrUpConfigFromServer(sv, config_vth);

		return true;
	}

	public void inApache(Server sv) {
		ConfigChung configChung = convertTextToObjectConfigChung(sv);
		List<Directory> direc = convertTextToDirectoryObject(sv); //

		List<VirtualHost> list_vitual = convertTextToVirtualHostObject(sv);

		Apache apache_general = new Apache(configChung, direc, list_vitual);
		System.out.println("------------------Chung--------------- "); // In ra
		System.out.println("Port " + apache_general.getConfigchung().getPort());
		System.out.println("Timeout "
				+ apache_general.getConfigchung().getTime_out());
		System.out.println("PathErrorLog "
				+ apache_general.getConfigchung().getPathErrorLog());
		System.out.println("Loglevel "
				+ apache_general.getConfigchung().getLogLevel());
		System.out.println("KeepAlive "
				+ apache_general.getConfigchung().getKeepAlive());
		System.out.println("KeepAliveTimeout "
				+ apache_general.getConfigchung().getKeepAliveTimeout());
		System.out.println("KeepAliveRequest "
				+ apache_general.getConfigchung().getMaxKeepAliveRequest());

		System.out.println("-------------------Directory-------------- ");
		for (Directory dr : apache_general.getDirectorys()) {
			System.out.println("<Directory " + dr.getPathFile() + ">");
			System.out.println("Options " + dr.getOptions());
			System.out.println("AllowOverride " + dr.getAllowOverride());
			System.out.println("Require " + dr.getRequireAll());
			System.out.println("Order " + dr.getOrder());
			System.out.println("Allow " + dr.getAllow());
			System.out.println("Deny " + dr.getDeny());
			System.out.println("</Directory>");
			System.out.println("\n");
			System.out.println("--------------------------------- ");

		}

		//

		System.out.println("------------VitualHost----------------\n");

		for (VirtualHost vth : apache_general.getVitualhosts()) {
			System.out.println("<Vitualhost " + vth.getVitualhost() + ">");
			System.out.println("ServerName " + vth.getServername());
			System.out.println("ServerAdmin " + vth.getServeradmin());
			System.out.println("DocumentRoot " + vth.getDocumentRoot());
			System.out.println("Alias " + vth.getAlias());
			System.out.println("ErrorLog " + vth.getErrorLog());
			System.out.println("CustomLog " + vth.getCustomLog());
			System.out.println("</Vitualhost>");
			System.out.println("----------------------------\n");

		}
	}

	public static void main(String[] args) {
		ApacheConfig apache_c = new ApacheConfig();

		Server sv = new Server(1, "192.168.0.105", 22, "mayb", "root", "root");

		// VirtualHost vth = new VirtualHost("192.168.0.105:80",
		// "www.hoclamgiau.com", "hieuminh@yahoo.com", "/var/www/html",
		// null, null, null);
		// apache_c.createVirtualHost(sv, vth);
		// apache_c.inApache(sv);
		/*
		 * apache_c.uploadConfigToApacheConfig(sv,
		 * apache_c.convertTextToObjectConfigChung(sv),
		 * apache_c.convertTextToDirectoryObject(sv));
		 * 
		 * // ---vtual host upload apache_c.uploadConfigToVirtualHostConfig(sv,
		 * apache_c.convertTextToVirtualHostObject(sv));
		 */
		// Them vitual host
		/*
		 * VirtualHost vth1 = new VirtualHost("192.168.10.100:80",
		 * "www.server1.com", "admin@yahoo.com", "/var/www/html/server1", null,
		 * "/home/mayb/error.log", null);
		 * 
		 * apache_c.createVirtualHost(sv, vth1);
		 */
		// Xoa 1 vitual Host
		// apache_c.XoaVitulHost(sv,
		// apache_c.convertTextToVirtualHostObject(sv),
		// "www.hoclamgiau.com");
		apache_c.uploadConfigToApacheConfig(sv,
				apache_c.convertTextToObjectConfigChung(sv),
				apache_c.convertTextToDirectoryObject(sv), null);
	}
}
