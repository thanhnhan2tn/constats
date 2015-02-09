package vn.edu.cit.servercontrol;

import java.io.InputStream;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class Power {

	public static boolean Shutdown(Server sv) {
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

	public static boolean Restart(Server sv) {
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

	public static void main(String[] args) {
		Server sv = new Server("192.168.0.101", 22, "root", "root");
		Power pw = new Power();
		Restart(sv);
	}

	public static boolean changeNic(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			Channel channel = ss.openChannel("exec");
	((ChannelExec) channel).setCommand("echo "  + cmd +  " > " 
					+ "/home/maya/hello.txt");
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

}
