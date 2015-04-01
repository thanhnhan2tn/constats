package vn.edu.cit.servercontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ServerConfig {

	// Get Session
	public Session connect(Server sv) {

		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			// Khoi tao doi tuong Session
			Session session = jsch.getSession(sv.getServerUsername(),
					sv.getServerAddress(), sv.getPort());
			session.setPassword(sv.getServerPassword());
			session.setConfig(config);
			session.connect();
			System.out.println("Connected to Server Success !!!!");
			return session;
		} catch (Exception e) {
			System.out.println("Khong the connect den server");
		}
		return null;
	}

	public boolean Shutdown(Server sv) {
		Session ss = sv.getSession(sv);
		try {
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand("shutdown -P 0");
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);
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
					System.out.println("exit-status: "
							+ channel.getExitStatus());
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

	public boolean InstallService(Server sv) {
		Session ss = sv.getSession(sv);
		try {
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand("sudo apt-get install php5");
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);
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
					System.out.println("exit-status: "
							+ channel.getExitStatus());
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

	public boolean Restart(Server sv) {
		Session ss = sv.getSession(sv);
		try {
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand("sudo reboot");
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);
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
					System.out.println("exit-status: "
							+ channel.getExitStatus());
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

	public String uploadToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			String chuoilay = "";
			String tong = "";
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");

			((ChannelExec) channel).setCommand(cmd);
			((ChannelExec) channel).setErrStream(System.err);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
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

	// Check all service on Server
	public String checkAllPS(Server sv) throws InterruptedException {
		String chuoi = uploadToServer(sv, "sudo ps");
		System.out.println(chuoi);

		Thread.sleep(2000);
		chuoi = checkAllPS(sv);

		return chuoi;
	}

	// Check Version on Server
	public String checkVersion(Server sv) {
		String chuoi = uploadToServer(sv, "sudo lsb_release -d");
		return chuoi;
	}

	// Show Service run or stop
	public String showAllService(Server sv) {
		String services = "";
		String mang[] = { "apache2", "vsftpd", "isc-dhcp-server", "bind9",
				"squid3" };
		int i = 0;
		while (i < mang.length) {
			services = services
					+ uploadToServer(sv, "service " + mang[i] + " status")
					+ "\n";
			i++;
		}
		return services;
	}

	// Show Server Information
	public String ServerInformation(Server sv) {
		String info = "";
		String timefull = uploadToServer(sv, "cat /proc/uptime");
		String second = timefull.substring(0, timefull.indexOf(" "));
		System.out.println(second);
		float so = Float.parseFloat(second);
		// System.out.println(so + "");
		String time = convertStoH(so);

		info = info
				+ "*Hostname:"
				+ uploadToServer(sv, "hostname")
				+ "\n"
				+ "*OS Version:"
				+ checkVersion(sv)
				+ "\n"
				+ "*Kernel: "
				+ uploadToServer(sv, "uname -a")
				+ "\n"
				+ "*Webmin Version:"
				+ uploadToServer(sv, "cat /etc/webmin/version")
				+ "\n"
				+ "*Time on System:"
				+ uploadToServer(sv, "date")
				+ "\n"
				+ "*Processor information:"
				+ uploadToServer(sv, "cat /proc/cpuinfo | grep 'model name'")
						.trim()
				+ "\n"
				+ "*Uptime "
				+ time
				+ "\n"
				+ "*MemTotal/MemFree/Cached: \n"
				+ uploadToServer(sv,
						"cat /proc/meminfo | egrep '^(MemTotal|MemFree|Cached)' ")
				+ "CPU LoadAverage: "
				+ uploadToServer(sv, "cat /proc/loadavg")
				+ "*Local Disk Space:"
				+ uploadToServer(sv, "df -h | grep /dev/mapper/ubuntu--vg-root")
				+ "\n";
		;

		return info;
	}

	// Convert h to s
	public String convertStoH(float secs) {
		String tong = "";
		int hours = (int) secs / 3600, remainder = (int) secs % 3600, minutes = remainder / 60, seconds = remainder % 60;

		String disHour = (hours < 10 ? "0" : "") + hours, disMinu = (minutes < 10 ? "0"
				: "")
				+ minutes, disSec = (seconds < 10 ? "0" : "") + seconds;

		tong = tong + disHour + ":" + disMinu + ":" + disSec;
		return tong;
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {

		ServerConfig svc = new ServerConfig();
		Server sv = new Server("104.199.135.203", 22, "mayb", "root", "123456aA@");
		// svc.checkAllPS(sv);
		// System.out.println(svc.uploadToServer(sv, "ifconfig"));
		// System.out.println("----------------------------");
		System.out.println(svc.ServerInformation(sv));
		//svc.checkAllPS(sv);
	}
}
