package model.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;

import model.nic.NicConfig;

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
					System.out.print(chuoilay);
					tong = tong + chuoilay;
				}
				if (channel.isClosed()) {
					// System.out.println("exit-status: "
					// + channel.getExitStatus());
					if (channel.getExitStatus() == 0) {
						System.out.println("Loading...");
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
			return tong;
		} catch (Exception e) {
			return null;
		}
	}

	// Create User with SSH
	public Boolean createUser(String tenUser, String password) {
		return null;
	}

	// Upload test
	public ServerStatus getServerStatus(Server sv) throws InterruptedException {
		Session ss = sv.getSession(sv);

		try {

			HashMap<String, String> hm1 = new HashMap<String, String>();
			String multi_cmd[] = { "hostname",
					"cat /etc/lsb-release | grep 'DISTRIB_DESCRIPTION='",
					"uname -a", "cat /etc/webmin/version", "date",
					"cat /proc/cpuinfo | grep 'model name'",
					"cat /proc/uptime", "cat /proc/meminfo | grep MemTotal ",
					"free | grep Mem | awk '{print $3/$2 * 100.0}'",
					"free | grep Mem | awk '{print $4/$2 * 100.0}'",
					"cat /proc/meminfo | grep Cached ", "cat /proc/loadavg",
					"df -h | grep /dev/mapper/ubuntu--vg-root" };
			String index_cmd[] = { "hostname", "osversion", "kernel",
					"webmin_version", "timeonsys", "processor_info", "uptime",
					"memtotal", "memused", "memfree", "memcached",
					"cpu_loadaverage", "local_disk" };

			String chuoilay = "";
			// option -e giup nhan dang ki tu xuong dong
			int j = 0;

			while (j < multi_cmd.length) {
				String tong = "";

				Channel channel = ss.openChannel("exec");

				String cmd = multi_cmd[j];

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
						chuoilay = new String(tmp, 0, i).trim();
						chuoilay = chuoilay.replaceAll("\\s+", " ");
						chuoilay = chuoilay.replace(":", "");
						chuoilay = chuoilay.replace("model name", "");
						chuoilay = chuoilay.replace("DISTRIB_DESCRIPTION=", "");
						chuoilay = chuoilay.replace("\"", "");
						chuoilay = chuoilay.replace(
								"/dev/mapper/ubuntu--vg-root", "");
						chuoilay = chuoilay.replace("MemTotal", "");
						chuoilay = chuoilay.replace("MemFree", "");
						chuoilay = chuoilay.replace("Cached", "");

						chuoilay = chuoilay.trim();
						// chuoilay = chuoilay + "\n";

						// System.out.print(chuoilay);
						tong = tong + chuoilay + "\n";
						if (index_cmd[j].equals("uptime")) {
							tong = tong.substring(0, tong.indexOf(" "));
							hm1.put(index_cmd[j],
									convertStoH(Float.parseFloat(tong)));

						} else {
							hm1.put(index_cmd[j], tong);
						}
					}
					if (channel.isClosed()) {
						// System.out.println("\nexit-status: "
						// + channel.getExitStatus());
						// if (channel.getExitStatus() == 0) {
						// System.out.println("Loading...");
						// } else {
						//
						// System.out.println("Loading Failed!!!...");
						//
						// }
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
			// System.out.print(hm1);
			ServerStatus svst = new ServerStatus(hm1.get("hostname"),
					hm1.get("osversion"), hm1.get("kernel"),
					hm1.get("webmin_version"), hm1.get("timeonsys"),
					hm1.get("processor_info"), hm1.get("uptime"),
					hm1.get("memtotal"), hm1.get("memused"),
					hm1.get("memfree"), hm1.get("memcached"),
					hm1.get("cpu_loadaverage"), hm1.get("local_disk"));

			return svst;

		} catch (Exception e) {

			return null;
		}

	}

	// in theo dinh ki
	public ServerStatus hienthiStatusDinhKy(Server sv, int sleep)
			throws InterruptedException {
		ServerStatus svtt = getServerStatus(sv);
		System.out.println("-----Create Onject-------");

		System.out.println("Host name: " + svtt.getHostname());
		System.out.println("Kernel: " + svtt.getKernel());
		System.out.println("OSVersion: " + svtt.getOsversion());
		System.out.println("Processor Info: " + svtt.getProcessor_info());
		System.out.println("Uptime: " + svtt.getUptime());
		System.out.println("Time On Sys: " + svtt.getTimeonsys());
		System.out.println("Cpu Loadaverage: " + svtt.getCpu_loadaverage());
		System.out.println("Mem Total: " + svtt.getMemtotal());
		System.out.println("Mem Free: " + svtt.getMemfree());

		System.out.println("Mem Used: " + svtt.getMemused());
		System.out.println("Mem Cached: " + svtt.getMemcached());
		System.out.println("Local Disk: " + svtt.getLocal_disk());

		Thread.sleep(sleep);
		hienthiStatusDinhKy(sv, sleep);
		return svtt;
	}

	// Check all service on Server
	public String showAllPS(Server sv) throws InterruptedException {
		String chuoi = uploadToServer(sv, "sudo ps");
		System.out.println(chuoi);

		Thread.sleep(2000);
		chuoi = showAllPS(sv);

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
		Server sv = new Server(1, "192.168.0.104", 22, "mayb", "mayb", "mayb");
		// svc.checkAllPS(sv);

		// System.out.println("----------------------------");
		// System.out.println(svc.ServerInformation(sv));
		// svc.checkAllPS(sv);
		svc.hienthiStatusDinhKy(sv,3000);
		// svc.showAllService(sv);
	}
}
