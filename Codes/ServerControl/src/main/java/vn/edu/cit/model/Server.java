package vn.edu.cit.model;

import java.io.InputStream;
import java.util.List;

import model.server.ServerStatus;

import org.springframework.data.mongodb.core.mapping.Document;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Server object with JSCH and Server table in DB
 * 
 * @author Thanh
 *
 */
@Document(collection = "servers")
public class Server {
	private String serverAddress;
	private int port = 22;
	private String serverName;
	private String serverUsername;
	private String serverPassword;
	private List<ServerStatus> status;

	public Server() {
		super();
	}

	public Server(Server another) {
		this.serverAddress = another.serverAddress;
		this.serverName = another.serverName;
		this.serverUsername = another.serverUsername;
		this.serverPassword = another.serverPassword;
		this.port = another.port;
		this.status = another.status;
	}

	public List<ServerStatus> getStatus() {
		return status;
	}

	public void setStatus(List<ServerStatus> status) {
		this.status = status;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Server(String serverAddress, int port, String serverName, String serverUsername, String serverPassword) {
		super();
		this.serverAddress = serverAddress;
		this.port = port;
		this.serverName = serverName;
		this.serverUsername = serverUsername;
		this.serverPassword = serverPassword;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerUsername() {
		return serverUsername;
	}

	public void setServerUsername(String serverUsername) {
		this.serverUsername = serverUsername;
	}

	public String getServerPassword() {
		return serverPassword;
	}

	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

	/**
	 * Check Server Status
	 * 
	 * @param sv
	 * @return
	 */
	public boolean checkStatus() {
		return (getSession(this) != null);
	}

	/**
	 * Get Session
	 * 
	 * @param sv
	 * @return
	 */
	public Session getSession(Server sv) {

		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			// Khoi tao doi tuong Session
			Session session = jsch.getSession(sv.getServerUsername(), sv.getServerAddress(), sv.getPort());
			session.setPassword(sv.getServerPassword());
			session.setConfig(config);
			// session.setTimeout(10000);
			session.connect();
			// System.out.println("Connected to Server Success !!!!");
			return session;
		} catch (Exception e) {
			return null;
		}
	}

	// StopMonitor
	// public ServerStatus stopMonitor(Server sv) throws InterruptedException {
	// ServerStatus svtt = getServerStatus(sv);
	// System.out.println("-----Create Onject-------");
	// System.out.println("Host name: " + svtt.getHostname());
	// System.out.println("Kernel: " + svtt.getKernel());
	// System.out.println("OSVersion: " + svtt.getOsversion());
	// System.out.println("Processor Info: " + svtt.getProcessor_info());
	// System.out.println("Uptime: " + svtt.getUptime());
	// System.out.println("Time On Sys: " + svtt.getTimeonsys());
	// System.out.println("Cpu Loadaverage: " + svtt.getCpu_loadaverage());
	// System.out.println("Mem Total: " + svtt.getMemtotal());
	// System.out.println("Mem Free: " + svtt.getMemfree());
	// System.out.println("Mem Used: " + svtt.getMemused());
	// System.out.println("Mem Cached: " + svtt.getMemcached());
	// System.out.println("Local Disk: " + svtt.getLocal_disk());
	//
	// return svtt;
	// }

	// @Override
	// public void run() {
	// try {
	// // Ngủ 1030 milli giây.
	// startMonitor(this, 1000);
	// } catch (InterruptedException e1) {
	// //
	// e1.printStackTrace();
	// }
	//
	// }
	//
	// // StartMonitor
	// public ServerStatus startMonitor(Server sv, int sleep) throws
	// InterruptedException, NullPointerException {
	// ServerStatus svtt = getServerStatus(sv);
	// System.out.println("-----Create Object-------");
	// System.out.println("Host name: " + svtt.getHostname());
	// System.out.println("Kernel: " + svtt.getKernel());
	// System.out.println("OSVersion: " + svtt.getOsversion());
	// System.out.println("Processor Info: " + svtt.getProcessor_info());
	// System.out.println("Uptime: " + svtt.getUptime());
	// System.out.println("Time On Sys: " + svtt.getTimeonsys());
	// System.out.println("Cpu Usage: " + svtt.getCpu_usage());
	//
	// System.out.println("Cpu Loadaverage: " + svtt.getCpu_loadaverage());
	// System.out.println("Mem Total: " + svtt.getMemtotal());
	// System.out.println("Mem Free: " + svtt.getMemfree());
	// System.out.println("Mem Used: " + svtt.getMemused());
	// System.out.println("Mem Cached: " + svtt.getMemcached());
	// System.out.println("Local Disk: " + svtt.getLocal_disk());
	//
	// Thread.sleep(sleep);
	// startMonitor(sv, sleep);
	// return svtt;
	// }
	//
	// // getServer Status
	// public ServerStatus getServerStatus(Server sv) throws
	// InterruptedException {
	// Session ss = sv.getSession(sv);
	//
	// try {
	//
	// HashMap<String, String> hm1 = new HashMap<String, String>();
	// String multi_cmd[] = { "hostname",
	// "cat /etc/lsb-release | grep 'DISTRIB_DESCRIPTION='", "uname -a",
	// "date", "cat /proc/cpuinfo | grep 'model name'", "cat /proc/uptime",
	// "cat /proc/meminfo | grep MemTotal ",
	// "free | grep Mem | awk '{print $3/$2 * 100.0}'",
	// "free | grep Mem | awk '{print $4/$2 * 100.0}'",
	// "cat /proc/meminfo | grep Cached ",
	// "top -b -n1 | grep 'Cpu(s)'|awk '{print $2$3}'", "cat /proc/loadavg",
	// "df -h | grep /dev/mapper/" };
	// String index_cmd[] = { "hostname", "osversion", "kernel", "timeonsys",
	// "processor_info", "uptime",
	// "memtotal", "memused", "memfree", "memcached", "cpu_usage",
	// "cpu_loadaverage", "local_disk" };
	//
	// String chuoilay = "";
	// // option -e giup nhan dang ki tu xuong dong
	// int j = 0;
	//
	// while (j < multi_cmd.length) {
	// String tong = "";
	//
	// Channel channel = ss.openChannel("exec");
	//
	// String cmd = multi_cmd[j];
	//
	// ((ChannelExec) channel).setCommand(cmd);
	//
	// ((ChannelExec) channel).setErrStream(System.err);
	// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// InputStream in = channel.getInputStream();
	//
	// channel.connect();
	// byte[] tmp = new byte[1024];
	// while (true) {
	// while (in.available() > 0) {
	// int i = in.read(tmp, 0, 1024);
	// if (i < 0)
	// break;
	// chuoilay = new String(tmp, 0, i).trim();
	// chuoilay = chuoilay.replaceAll("\\s+", " ");
	// chuoilay = chuoilay.replace(":", "");
	// chuoilay = chuoilay.replace("model name", "");
	// chuoilay = chuoilay.replace("DISTRIB_DESCRIPTION=", "");
	// chuoilay = chuoilay.replace("\"", "");
	// chuoilay = chuoilay.trim().replaceAll("/dev/mapper/\\w+--vg-root", "");
	// chuoilay = chuoilay.replace("MemTotal", "");
	// chuoilay = chuoilay.replace("MemFree", "");
	// chuoilay = chuoilay.replace("Cached", "");
	//
	// chuoilay = chuoilay.trim();
	// // chuoilay = chuoilay + "\n";
	//
	// // System.out.print(chuoilay);
	// tong = tong + chuoilay + "\n";
	// if (index_cmd[j].equals("uptime")) {
	// tong = tong.substring(0, tong.indexOf(" "));
	// hm1.put(index_cmd[j], convertStoH(Float.parseFloat(tong)));
	//
	// } else {
	// hm1.put(index_cmd[j], tong);
	// }
	// }
	// if (channel.isClosed()) {
	// // System.out.println("\nexit-status: "
	// // + channel.getExitStatus());
	// if (channel.getExitStatus() == 0) {
	// System.out.println("Loading...OK");
	// } else {
	//
	// System.out.println("Loading Failed!!!...");
	//
	// }
	// break;
	// }
	// try {
	// Thread.sleep(1000);
	// } catch (Exception ee) {
	// }
	// }
	// channel.disconnect();
	// j++;
	// }
	// // System.out.print(hm1);
	// ServerStatus svst = new ServerStatus(hm1.get("hostname"),
	// hm1.get("osversion"), hm1.get("kernel"),
	// hm1.get("timeonsys"), hm1.get("processor_info"), hm1.get("uptime"),
	// hm1.get("memtotal"),
	// hm1.get("memused"), hm1.get("memfree"), hm1.get("memcached"),
	// hm1.get("cpu_usage"),
	// hm1.get("cpu_loadaverage"), hm1.get("local_disk"));
	//
	// return svst;
	//
	// } catch (Exception e) {
	//
	// return null;
	// }
	//
	// }

	// Convert h to s
	public String convertStoH(float secs) {
		String tong = "";
		int hours = (int) secs / 3600, remainder = (int) secs % 3600, minutes = remainder / 60, seconds = remainder % 60;

		String disHour = (hours < 10 ? "0" : "") + hours, disMinu = (minutes < 10 ? "0" : "") + minutes, disSec = (seconds < 10 ? "0"
				: "")
				+ seconds;

		tong = tong + disHour + ":" + disMinu + ":" + disSec;
		return tong;
	}

	// Restart
	public boolean Restart(Server sv) {
		String cmd = "echo " + sv.getServerPassword() + " |sudo -S " + " reboot ";
		sendCMDToServer(sv, cmd);
		return true;
	}

	// Stop
	public boolean Stop(Server sv) {
		String cmd = "echo " + sv.getServerPassword() + " |sudo -S " + " stop ";
		sendCMDToServer(sv, cmd);
		return true;
	}

	// WakeOnSleep
	public boolean WakeUp(Server sv) {
		String cmd = "echo " + sv.getServerPassword() + " |sudo -S " + " start ";
		sendCMDToServer(sv, cmd);
		return true;
	}

	// Dung trong truong hop Start/Stop/Restart
	public boolean sendCMDToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
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
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// WakeOnSleep
	public boolean WakeUp1(Server sv) {
		String cmd = "echo " + sv.getServerPassword() + " |sudo -S " + " start ";
		sendCMDToServer(sv, cmd);
		return true;
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
		String mang[] = { "ssh", "apache2", "vsftpd", "isc-dhcp-server", "bind9", "squid3" };
		int i = 0;
		while (i < mang.length) {
			services = services + uploadToServer(sv, "service " + mang[i] + " status") + "\n";
			i++;
		}
		return services;
	}

	// Dung de load Config text ve
	public String uploadToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			String chuoilay = "";
			String tong = "";
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");

			((ChannelExec) channel).setCommand(cmd);
			((ChannelExec) channel).setErrStream(System.err);
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
					// System.out.println("exit-status: "	
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
			return tong;
		} catch (Exception e) {
			return null;
		}
	}

}
