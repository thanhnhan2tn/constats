package vn.edu.cit.servercontrol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
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
			((ChannelExec) channel).setCommand("ifconfig");
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

	public boolean uploadToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(" sudo echo " + " -e " + cmd
					+ " > " + "/home/mayb/hello.txt");
			// ((ChannelExec) channel).setCommand(cmd);
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

	public String loadConfigToString(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		String chuoilay = "";
		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			// ((ChannelExec) channel).setCommand(" echo " + " -e " + cmd +
			// " > "
			// + "/home/maya/hello3.txt");
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
					FileOutputStream f = new FileOutputStream(new File(
							"E:\\tuine.txt"));
					f.write(chuoilay.getBytes(), 0, chuoilay.length());
					System.out.print(chuoilay);
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
			return chuoilay;

		} catch (Exception e) {
			return null;
		}

	}

	/*
	 * public String StoreConfig(Server sv, String cmd) throws IOException {
	 * String text = loadConfigToString(sv, cmd); FileOutputStream f = new
	 * FileOutputStream(new File("E:\\tuine.txt")); f.write(text.getBytes(), 0,
	 * text.length()); return null; }
	 */

	public static void main(String[] args) throws IOException {

		ServerConfig svc = new ServerConfig();
		Server sv = new Server(1, "192.168.1.109", 22, "mayb", "root", "root");
		// svc.uploadToServer(sv, "heello minh '\n'");
		// System.out.println("Chuoi da lay dc la:"
		// + svc.loadConfigToString(sv, ""));
		// svc.StoreConfig(sv, "cat /etc/network/interfaces");
	}
}
