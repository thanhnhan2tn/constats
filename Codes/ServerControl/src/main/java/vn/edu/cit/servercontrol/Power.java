package vn.edu.cit.servercontrol;

import java.io.InputStream;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

/**
 * Class Power - Dieu khien Nguon cua server
 * 
 * @author ThanhNhan
 *
 */
public class Power {
	/**
	 * Shutdown Function - sent Signal shutdown to Server
	 * 
	 * @param sv
	 * @return
	 */
	public static boolean Shutdown(Server sv) {
		Session ss = sv.getSession(sv);
		try {
			// Khoi tao kenh
			Channel channel = ss.openChannel("exec");
			// Set cau lenh
			((ChannelExec) channel).setCommand("sudo shutdown -P 0");
			// Khoi tao input Stream
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			// Ket noi
			channel.connect();
			// Khoi tao bien tam
			byte[] tmp = new byte[2048];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, tmp.length);
					if (i < 0)
						break;
					// System.out.print(new String(tmp, 0, i));
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

	/**
	 * Restart Function - Send Reboot signal to Server
	 * 
	 * @param sv
	 * @return
	 */
	public static boolean Restart(Server sv) {
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
}
