package vn.edu.cit.servercontrol.ssh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class SSHConfig {

	// Upload cmd / file to server
	public boolean uploadToServer(Server sv, String cmd) {
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
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Start
	public Boolean Start(Server sv) {
		String command = "sudo /etc/init.d/ssh start";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Stop
	public Boolean Stop(Server sv) {
		String command = "sudo /etc/init.d/ssh stop";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Restart
	public Boolean Restart(Server sv) {
		String command = "sudo /etc/init.d/ssh restart";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// State
	public Boolean getState(Server sv) {
		String command = "sudo service openssh-server status";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// upload Config to Server
	public boolean uploadConfigToServer(Server sv, String kq) {
		String command = "";
		return true;
	}

	// load file config tu server thanh plaintext
	public String loadConfigToPlainText(Server sv) {

		Session ss = sv.getSession(sv);
		String chuoilay = "";
		String tong = "";

		try {

			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(" sudo cat /etc/ssh/sshd_config");
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
					chuoilay = new String(tmp, 0, i);
					tong = tong + chuoilay;
					// System.out.print(chuoilay);

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

		} catch (Exception e) {
			return null;
		}
		return tong;

	}

	// Convert Text sang Object SSH
	public SSH convertTextToObject(Server sv) {
		HashMap<String, String> hm_ssh = new HashMap<String, String>();
		try {

			StringReader str = new StringReader(loadConfigToPlainText(sv));
			BufferedReader bufferedReader = new BufferedReader(str);
			// StringBuffer stringBuffer = new StringBuffer();
			String line = "";
			// String chuoilay = "";
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
					hm_ssh.put(line.substring(0, line.indexOf(" ")), line.substring(line.indexOf(" ") + 1));
				}

				// chuoilay = chuoilay + line + "\n";
			}
			str.close();
			SSH ssh1 = new SSH(hm_ssh.get("Port"), hm_ssh.get("ListenAddress"), hm_ssh.get("LoginGraceTime"),
					hm_ssh.get("PermitRootLogin"), hm_ssh.get("PasswordAuthentication"),
					hm_ssh.get("PermitEmptyPasswords"), hm_ssh.get("AllowUsers"));
			return ssh1;

			// return chuoilay.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	public SSH getEthFromAdd(String index, Server sv) throws IOException {
		return null;
	}

}
