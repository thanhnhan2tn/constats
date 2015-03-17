package vn.edu.cit.servercontrol;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;

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

	public static boolean changeNic(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(" echo " + " -e " + cmd + " > "
					+ "/home/maya/hello3.txt");
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

}
