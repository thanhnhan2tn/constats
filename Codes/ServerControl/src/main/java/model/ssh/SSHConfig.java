package model.ssh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class SSHConfig {

	// Chuan hoa lan 1
	public String chuanhoaChuoi1(String chuoiCH) {

		try {

			StringReader str = new StringReader(chuoiCH);
			BufferedReader bufferedReader = new BufferedReader(str);
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {

				line = line.trim();
				// Replace nhieu khoang trang ve mot khoang trang
				line = line.replaceAll("\\s+", " ");

				// Cat bo line chua "#" dau dong
				if (line.indexOf("#") != -1) {
					continue;
				}

				chuoilay = chuoilay + line + "\n";

			}
			str.close();

			return chuoilay.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;

	}

	// Chuan hoa lan 2
	public String chuanhoaChuoi2(String chuoiCH) throws IOException {

		String chuoilay = chuoiCH;
		String tong = "";
		String regex_array[] = { "Port \\d+", "PermitRootLogin [yesno]+", "PermitEmptyPasswords [yesno]+",
				"PasswordAuthentication [yesno]+", "ListenAddress [\\d.]+", "LoginGraceTime \\d+\n", "AllowUsers .+" };
		int i = 0;
		while (i < regex_array.length) {
			Pattern pt = Pattern.compile(regex_array[i]);
			Matcher matcher = pt.matcher(chuoilay);
			while (matcher.find()) {
				tong = tong + matcher.group() + "\n";

			}
			i++;
		}

		return tong;

	}

	// Xoa tat ca dong trong
	public String chuanhoaChuoi3(String chuoiCH) throws IOException {

		String chuoilay = chuoiCH;

		String line2 = "";
		String kq_lay = "";
		StringReader str2 = new StringReader(chuoilay);
		BufferedReader br = new BufferedReader(str2);
		while ((line2 = br.readLine()) != null) {
			line2 = line2.trim();
			// Ham xu ly ";"
			// ham xu ly dau ";"
			if (line2.indexOf(" ;") != -1) {
				line2 = line2.replace(" ;", ";");

			}

			if (line2.indexOf("; ") != -1) {
				line2 = line2.replace("; ", ";");

			}

			if (line2.indexOf(" ; ") != -1) {
				line2 = line2.replace(" ; ", ";");

			}

			// Ham xoa tat ca khoang trong tren line
			if (line2.isEmpty()) {
				continue;
			}
			kq_lay = kq_lay + line2 + "\n";
		}
		str2.close();

		return kq_lay;

	}

	// Upload cmd / file to server phuc vu start/stop and
	// load config file
	public String uploadToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(cmd);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			String tong = "";
			String lay = "";
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					lay = new String(tmp, 0, i);
					tong = tong + lay;
				}
				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());

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

	// Upload cmd / file to server phuc vu start/stop/ va upload
	public boolean sendCMDToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(cmd);
			((ChannelExec) channel).setErrStream(System.err);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			if (channel.getExitStatus() == 0) {
				return true;
			} else {
				if (channel.getExitStatus() == 1) {
					System.out.println("Kiem tra lai tai khoan dang dung");
					return false;
				}
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param sv
	 * @return Boolean
	 */
	// Start
	public Boolean Start(Server sv) {
		String command = "service ssh start";
		return sendCMDToServer(sv, command);

	}

	/**
	 * 
	 * @param sv
	 * @return Boolean
	 */
	// Stop
	public Boolean Stop(Server sv) {
		String command = "service ssh stop";
		return sendCMDToServer(sv, command);

	}

	/**
	 * 
	 * @param sv
	 * @return Boolean
	 */
	// Restart
	public Boolean Restart(Server sv) {
		String command = "service ssh restart";
		return sendCMDToServer(sv, command);

	}

	/**
	 * 
	 * @param sv
	 * @return Boolean
	 */
	// check Install
	public Boolean checkInstall(Server sv) {
		String command = "echo " + sv.getServerPassword() + " |sudo -S "
				+ "dpkg --get-selections | grep 'openssh-server' | awk '{print $2}'";
		String kq = uploadToServer(sv, command);
		if (kq.startsWith("install")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param sv
	 * @return Boolean
	 */
	// checkRunning - check server dang running hay stoped
	public Boolean checkRunning(Server sv) {
		String command = "sudo service ssh status";
		String kq = uploadToServer(sv, command);
		if (kq.indexOf("not running") != -1 || kq.indexOf("stop") != -1 || kq.indexOf("waiting") != -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @param sv
	 * @return Boolean
	 */
	// Install
	public Boolean Install(Server sv) {
		String command = "sudo apt-get -y install openssh-server";
		return sendCMDToServer(sv, command);

	}

	/**
	 * 
	 * @param sv
	 * @return Boolean
	 */
	// Remove Service
	public Boolean Remove(Server sv) {
		String command = "sudo apt-get -y --purge remove openssh-server";
		return sendCMDToServer(sv, command);

	}

	// upload Config to Server
	public boolean uploadConfigToServer(Server sv, SSH ssh) {
		String command = "";
		if (ssh.getPort() != null && !ssh.getPort().equals("")) {
			command = command + "Port " + ssh.getPort() + "\n";
		}

		if (ssh.getPermitRootLogin() != null && !ssh.getPermitRootLogin().equals("")) {
			if (ssh.getPermitRootLogin() == true) {
				command = command + "PermitRootLogin " + "yes" + "\n";
			} else {
				command = command + "PermitRootLogin " + "no" + "\n";

			}
		}

		if (ssh.getPermitEmptyPassword() != null && !ssh.getPermitEmptyPassword().equals("")) {
			if (ssh.getPermitEmptyPassword() == true) {
				command = command + "PermitEmptyPasswords " + "yes" + "\n";
			} else {
				command = command + "PermitEmptyPasswords " + "no" + "\n";

			}
		}

		if (ssh.getPasswordAu() != null && !ssh.getPasswordAu().equals("")) {
			if (ssh.getPasswordAu() == true) {
				command = command + "PasswordAuthentication " + "yes" + "\n";
			} else {
				command = command + "PasswordAuthentication " + "no" + "\n";

			}
		}

		if (ssh.getListenAdd() != null && !ssh.getListenAdd().equals("")) {
			command = command + "ListenAddress " + ssh.getListenAdd() + "\n";
		}

		if (ssh.getLoginGraceTime() != null && !ssh.getLoginGraceTime().equals("")) {
			command = command + "LoginGraceTime " + ssh.getLoginGraceTime() + "\n";
		}

		if (ssh.getAllowUsers() != null && !ssh.getAllowUsers().equals("")) {
			command = command + "AllowUsers " + ssh.getAllowUsers() + "\n";
		}
		command = "echo " + sv.getServerPassword() + " | sudo -S bash -c " + "' echo -e \"" + command
				+ "\" > /etc/ssh/sshd_config'";
		Boolean boo = sendCMDToServer(sv, command);
		if (boo == true) {
			System.out.println("Uploaded Success...OK");
			return true;
		} else {
			System.out.println("Uploaded Failed !!!");

			return false;
		}
	}

	// upload String to Server
	public Boolean uploadStringToServer(Server sv, String sshString) {

		String command = "echo " + sv.getServerPassword() + " | sudo -S bash -c " + "' echo -e \"" + sshString
				+ "\" > /etc/vsftpd.conf'";
		Boolean boo = sendCMDToServer(sv, command);
		if (boo == true) {
			System.out.println("Uploaded Success...OK");
			return true;
		} else {
			System.out.println("Uploaded Failed !!!");

			return false;
		}

	}

	// load file config tu server thanh plaintext
	public String loadConfigToPlainText(Server sv) throws IOException {
		String cmd = "cat /etc/ssh/sshd_config";
		String kq = uploadToServer(sv, cmd);
//		kq = chuanhoaChuoi1(kq);
//		kq = chuanhoaChuoi2(kq);
//		kq = chuanhoaChuoi3(kq);
		return kq;
	}

	// getLog
	public String getLog(Server sv) {
		Restart(sv);
		String kq = uploadToServer(sv, "echo " + sv.getServerPassword() + "| sudo -S " + " tail -10 /var/log/auth.log");

		return kq;
	}

	// getError
	public String getError(Server sv) throws InterruptedException {
		Session ss = sv.getSession(sv);

		try {

			HashMap<String, String> hm1 = new HashMap<String, String>();
			String multi_cmd[] = {
					"echo " + sv.getServerPassword() + " |sudo -S " + " chmod 771 /home/" + sv.getServerUsername(),
					"echo " + sv.getServerPassword() + "| sudo -S "
							+ "  echo -e 'var=$(sshd -t 2>&1) \n echo $var > /etc/sshd.txt '> /home/"
							+ sv.getServerUsername() + "/sshd.sh ",
					"echo " + sv.getServerPassword() + "| sudo -S " + " bash /home/" + sv.getServerUsername()
							+ "/sshd.sh ", "echo " + sv.getServerPassword() + " |sudo -S " + " cat /etc/sshd.txt",
					"echo " + sv.getServerPassword() + " |sudo -S " + " rm /etc/sshd.txt" };

			String chuoilay = "";
			// option -e giup nhan dang ki tu xuong dong
			int j = 0;
			String tong = "";

			while (j < multi_cmd.length) {
				Channel channel = ss.openChannel("exec");
				String cmd = multi_cmd[j];
				((ChannelExec) channel).setCommand(cmd);
				((ChannelExec) channel).setErrStream(System.err);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				InputStream in = channel.getInputStream();
				channel.connect();
				byte[] tmp = new byte[1024];
				while (true) {
					while (in.available() > 0) {
						int i = in.read(tmp, 0, 1024);
						if (i < 0)
							break;

						if (j == multi_cmd.length - 2) {
							chuoilay = new String(tmp, 0, i);

							tong = tong + chuoilay + "\n";
						}
					}
					if (channel.isClosed()) {
						// System.out.println("\nexit-status: "
						// + channel.getExitStatus());
						if (channel.getExitStatus() == 0) {
							System.out.println("Loading...OK");
						} else {

							System.out.println("Loading Failed!!!...");

						}
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (Exception ee) {
					}
				}
				channel.disconnect();
				j++;
			}
			return tong;

			// return

		} catch (Exception e) {

			return null;
		}

	}

	// Convert Text sang Object SSH
	public SSH convertTextToObjectSSH(Server sv) {
		HashMap<String, String> hm_ssh1 = new HashMap<String, String>();
		HashMap<String, Boolean> hm_ssh2 = new HashMap<String, Boolean>();

		try {

			StringReader str = new StringReader(loadConfigToPlainText(sv));
			BufferedReader bufferedReader = new BufferedReader(str);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				if (line.indexOf("#") != -1) {
					line = "";
				}
				if (line.indexOf("\\s+") != -1) {
					line = line.replaceAll("\\s+", " ");
				}
				if (line.indexOf("Port") != -1 || line.indexOf("ListenAddress") != -1
						|| line.indexOf("LoginGraceTime") != -1 || line.indexOf("PermitRootLogin") != -1
						|| line.indexOf("PasswordAuthentication") != -1 || line.indexOf("PermitEmptyPasswords") != -1
						|| line.indexOf("AllowUsers") != -1) {

					hm_ssh1.put(line.substring(0, line.indexOf(" ")), line.substring(line.indexOf(" ") + 1));
				}

				if (line.indexOf("PermitRootLogin") != -1 || line.indexOf("PermitEmptyPasswords") != -1
						|| line.indexOf("PasswordAuthentication") != -1) {
					if (line.substring(line.indexOf(" ") + 1).trim().equals("yes")) {

						hm_ssh2.put(line.substring(0, line.indexOf(" ")), true);

					} else {

						hm_ssh2.put(line.substring(0, line.indexOf(" ")), false);
					}
				}
				// chuoilay = chuoilay + line + "\n";
			}
			str.close();
			SSH ssh1 = new SSH(hm_ssh1.get("Port"), hm_ssh1.get("ListenAddress"), hm_ssh1.get("LoginGraceTime"),
					hm_ssh2.get("PermitRootLogin"), hm_ssh2.get("PasswordAuthentication"),
					hm_ssh2.get("PermitEmptyPasswords"), hm_ssh1.get("AllowUsers"));
			return ssh1;

			// return chuoilay.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	public void inSSH(Server sv, SSH ssh2) {
		System.out.println("----------------------------");

		System.out.println("Port " + ssh2.getPort());
		System.out.println("AllowUsers " + ssh2.getAllowUsers());
		System.out.println("ListenAddress " + ssh2.getListenAdd());
		System.out.println("LoginGraceTime " + ssh2.getLoginGraceTime());
		System.out.println("PasswordAuthentication " + ssh2.getPasswordAu());
		System.out.println("PermitEmptyPassword " + ssh2.getPermitEmptyPassword());
		System.out.println("PermitRootLogin " + ssh2.getPermitRootLogin());
	}

	public static void main(String[] args) throws IOException {
		//SSHConfig ssh_c = new SSHConfig();
		//Server sv = new Server("192.168.0.19", 22, "ubuntu", "ubuntu","ubuntu");
		// // ssh_c.uploadConfigToServer(sv, ssh_c.convertTextToObjectSSH(sv));
		// // ssh_c.inSSH(sv, ssh_c.convertTextToObjectSSH(sv));
		// // System.out.println(ssh_c.checkRunning(sv));
		// // ssh_c.inSSH(sv, ssh_c.convertTextToObjectSSH(sv));
		//System.out.println(ssh_c.loadConfigToPlainText(sv));
		// ssh_c.inSSH(sv, ssh_c.convertTextToObjectSSH(sv));
	}
}
