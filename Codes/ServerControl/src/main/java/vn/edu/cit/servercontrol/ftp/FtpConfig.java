package vn.edu.cit.servercontrol.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class FtpConfig {

	// Upload cmd / file to server
	public boolean uploadToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
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
					System.out.print(new String(tmp, 0, i));
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
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Start
	public Boolean Start(Server sv) {
		String command = "sudo service vsftpd start";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Stop
	public Boolean Stop(Server sv) {
		String command = "sudo service vsftpd stop";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Restart
	public Boolean Restart(Server sv) {
		String command = "sudo service vsftpd restart";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {

			return false;
		}
	}

	// State
	public Boolean getState(Server sv) {
		String command = "sudo service vsftpd status";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Install
	public Boolean Install(Server sv) {
		String command = "sudo apt-get -y install vsftpd";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			System.out.println("Channel closed!!!");

			return true;
		} else {
			System.out.println("Channel can't close!!!");

			return false;
		}
	}

	// Remove Service
	public Boolean Remove(Server sv) {
		String command = "sudo apt-get -y --purge remove vsftpd";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			System.out.println("Channel closed!!!");

			return true;
		} else {
			System.out.println("Channel can't close!!!");

			return false;
		}
	}

	// Create folder for FTP Directory
	public Boolean createFolder(Server sv, String pathString) {
		String command = "mkdir " + pathString;
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Xoa null truoc khi upload to Config (co 2 cach, dung cach nay hay hon,
	// nhung de loi hon)
	public String XoaNull(String chuoi) throws IOException {
		StringReader strRead = new StringReader(chuoi);
		BufferedReader br = new BufferedReader(strRead);
		String kq = "";
		String line = "";
		while ((line = br.readLine()) != null) {
			if (line.indexOf("null") != -1 || line.endsWith(" ")) {
				line = "";
			} else {
				kq = kq + line + "\n";
			}
		}
		return kq;
	}

	// upload Config to Server
	public boolean uploadConfigToServer(Server sv, Ftp ftp) throws IOException {
		String kq = "";
		if (ftp.getListen() != null && !ftp.getListen().equals(null)) {
			kq = kq + "listen=" + ftp.getListen() + "'\n'";
		}

		if (ftp.getAnonymous_enable() != null
				&& !ftp.getAnonymous_enable().equals(null)) {
			kq = kq + "anonymous_enable=" + ftp.getAnonymous_enable() + "'\n'";
		}

		if (ftp.getLocal_enable() != null
				&& !ftp.getLocal_enable().equals(null)) {
			kq = kq + "local_enable=" + ftp.getLocal_enable() + "'\n'";
		}

		if (ftp.getWrite_enable() != null
				&& !ftp.getWrite_enable().equals(null)) {
			kq = kq + "write_enable=" + ftp.getWrite_enable() + "'\n'";
		}

		if (ftp.getAnon_upload_enable() != null
				&& !ftp.getAnon_upload_enable().equals(null)) {
			kq = kq + "anon_upload_enable=" + ftp.getAnon_upload_enable()
					+ "'\n'";
		}

		if (ftp.getAnon_mkdir_write_enable() != null
				&& !ftp.getAnon_mkdir_write_enable().equals(null)) {
			kq = kq + "anon_mkdir_write_enable="
					+ ftp.getAnon_mkdir_write_enable() + "'\n'";
		}

		if (ftp.getConnect_from_port_20() != null
				&& !ftp.getConnect_from_port_20().equals(null)) {
			kq = kq + "connect_from_port_20=" + ftp.getConnect_from_port_20()
					+ "'\n'";
		}

		if (ftp.getDeny_email_enable() != null
				&& !ftp.getDeny_email_enable().equals(null)) {
			kq = kq + "deny_email_enable=" + ftp.getDeny_email_enable()
					+ "'\n'";
		}

		if (ftp.getChroot_local_user() != null
				&& !ftp.getChroot_local_user().equals(null)) {
			kq = kq + "chroot_local_user=" + ftp.getChroot_local_user()
					+ "'\n'";
		}

		if (ftp.getChroot_list_enable() != null
				&& !ftp.getChroot_list_enable().equals(null)) {
			kq = kq + "chroot_list_enable=" + ftp.getChroot_list_enable()
					+ "'\n'";
		}

		if (ftp.getChroot_list_file() != null
				&& !ftp.getChroot_list_file().equals(null)) {
			kq = kq + "chroot_list_file=" + ftp.getChroot_list_file() + "'\n'";
		}

		kq = kq.trim();
		// Xoa line chua null, do da dung cach khac
		// kq = XoaNull(kq);
		String command = "echo -e >  /etc/vsftpd.conf " + kq;
		if (uploadToServer(sv, command) == true) {
			System.out.println("Chanel Closed!!!");
			return true;

		}

		else {
			System.out.println("Channel can't close!!!");
			return false;

		}
	}

	// load file config tu server thanh plaintext
	public String loadConfigToPlainText(Server sv) {

		Session ss = sv.getSession(sv);
		String chuoilay = "";
		String tong = "";

		try {

			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(" sudo cat /etc/vsftpd.conf");
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
					tong = tong + chuoilay;
					// System.out.print(chuoilay);

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

		} catch (Exception e) {
			return null;
		}
		return tong;

	}

	// Chuan hoa PlainText tra ve Chuoi
	public String ChuanHoaChuoi(Server sv) {
		try {

			StringReader str = new StringReader(loadConfigToPlainText(sv));
			BufferedReader bufferedReader = new BufferedReader(str);
			// StringBuffer stringBuffer = new StringBuffer();
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				// Cat bo line chua "#" dau dong
				if (line.indexOf("#") != -1) {
					line = "";
					line = line.trim();
					line = line.replaceAll("\\s+", null);
					// chuoilay = chuoilay + line;

				}
				// Chi lay nhung chuoi nao co dau = sau do thay the dau "=" ->
				// " "
				if (line.indexOf("=") != -1) {
					/*
					 * chuoilay = chuoilay + line.substring(0,
					 * line.indexOf("=")) + " " +
					 * line.substring(line.indexOf("=") + 1) + "\n";
					 */

					line = line.replaceAll("=", " ");
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

	// convert Chuoi da Chuan Hoa sang Object
	public Ftp convertTextToObject(Server sv) {

		HashMap<String, String> hm1 = new HashMap<String, String>();
		// Xu ly khoang trang quan trong
		String[] mang = ChuanHoaChuoi(sv).split("\\s+");
		System.out.println(Arrays.asList(mang));
		try {
			int i = 0;
			while (!mang[i].equals(null)) {
				// System.out.println("Vong lap thu " + i);

				if (mang[i].equals("listen")
						|| mang[i].equals("anonymous_enable")
						|| mang[i].equals("local_enable")
						|| mang[i].equals("write_enable")
						|| mang[i].equals("anon_upload_enable")
						|| mang[i].equals("anon_mkdir_write_enable")
						|| mang[i].equals("chroot_local_user")
						|| mang[i].equals("chroot_list_enable")
						|| mang[i].equals("chroot_list_file")
						|| mang[i].equals("connect_from_port_20")
						|| mang[i].equals("deny_email_enable")) {

					hm1.put(mang[i], mang[i + 1]);

				}

				i++;

			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		} catch (NullPointerException nu) {
		}

		Ftp ftp = new Ftp(hm1.get("listen"), hm1.get("anonymous_enable"),
				hm1.get("local_enable"), hm1.get("write_enable"),
				hm1.get("anon_upload_enable"),
				hm1.get("anon_mkdir_write_enable"),
				hm1.get("connect_from_port_20"), hm1.get("deny_email_enable"),
				hm1.get("chroot_local_user"), hm1.get("chroot_list_enable"),
				hm1.get("chroot_list_file"));
		return ftp;
	}

	public void inFTPObject(Server sv, Ftp ftp) throws IOException {
		System.out.println("--------In ra doi tuong FTP:---------------");
		System.out.println("listen " + ftp.getListen());
		System.out.println("anonymous_enable " + ftp.getAnonymous_enable());
		System.out.println("local_enable " + ftp.getLocal_enable());
		System.out.println("write_enable " + ftp.getWrite_enable());
		System.out.println("anon_upload_enable " + ftp.getAnon_upload_enable());
		System.out.println("anon_mkdir_write_enable "
				+ ftp.getAnon_mkdir_write_enable());
		System.out.println("connect_from_port_20 "
				+ ftp.getConnect_from_port_20());
		System.out.println("deny_email_enable " + ftp.getDeny_email_enable());
		System.out.println("chroot_local_user " + ftp.getChroot_local_user());
		System.out.println("chroot_list_enable " + ftp.getChroot_list_enable());
		System.out.println("chroot_list_file " + ftp.getChroot_list_file());
	}
//
//	public static void main(String[] args) throws IOException {
//
//		FtpConfig ftp_c = new FtpConfig();
//		Server sv = new Server(1, "192.168.0.105", 22, "mayb", "root", "root"); // ftp_c.Install(sv);
//		// In ra chuoi chuan hoa
//		System.out.println(ftp_c.ChuanHoaChuoi(sv));
//		// In ra FTP
//		ftp_c.inFTPObject(sv, ftp_c.convertTextToObject(sv));
//
//		System.out.println("--------Uploading.....to Server---------------");
//
//		ftp_c.uploadConfigToServer(sv, ftp_c.convertTextToObject(sv));
//		System.out.println("--------Restarting.....to Server---------------");
//
//		ftp_c.Restart(sv);
//
//	}
}
