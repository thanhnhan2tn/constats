package model.ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;

import javax.activation.FileDataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.nic.Nic;
import model.server.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class FtpConfig {

	// Upload cmd / file to server
	public boolean sendCommandToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			// option -e giup nhan dang ki tu xuong dong
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
			if (channel.getExitStatus() == 0) {

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// Start
	public Boolean Start(Server sv) {
		String command = "sudo service vsftpd start";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Stop
	public Boolean Stop(Server sv) {
		String command = "sudo service vsftpd stop";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Restart
	public Boolean Restart(Server sv) {
		String command = "sudo service vsftpd restart";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			return true;
		} else {

			return false;
		}
	}

	// State
	public Boolean getState(Server sv) {
		String command = "sudo service vsftpd status";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Install
	public Boolean Install(Server sv) {
		String command = "sudo apt-get -y install vsftpd";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Remove Service
	public Boolean Remove(Server sv) {
		String command = "sudo apt-get -y --purge remove vsftpd";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Create folder for FTP Directory
	public Boolean createFolder(Server sv, String pathString) {
		String command = "mkdir " + pathString;
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Xoa null truoc khi upload to Config (co 2 cach, dung cach nay hay hon,
	// nhung de loi hon)
	// public String XoaNull(String chuoi) throws IOException {
	// StringReader strRead = new StringReader(chuoi);
	// BufferedReader br = new BufferedReader(strRead);
	// String kq = "";
	// String line = "";
	// while ((line = br.readLine()) != null) {
	// if (line.indexOf("null") != -1 || line.endsWith(" ")) {
	// line = "";
	// } else {
	// kq = kq + line + "\n";
	// }
	// }
	// return kq;
	// }

	// upload Config to Server
	public void uploadConfigToServer(Server sv, Ftp ftp) throws IOException {
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
		if (sendCommandToServer(sv, command) == true) {
			System.out.println("Uploaded Success");

		}

		else {
			System.out.println("Upload Failed!!!");

		}
	}

	// upload Config to Server 2 - Save theo String truyen vao - GUI PlainText
	public void uploadStringConfigToServer(Server sv, String configText)
			throws IOException {
		String config = configText;
		config = "sudo echo -e > /etc/vsftpd.conf " + config;
		if (sendCommandToServer(sv, config) == true) {
			System.out.println("Uploaded Success....!!!");
		} else {
			System.out.println("Upload Failed....!!!");

		}

	}

	// load file config tu server thanh plaintext
	public String loadConfigToChuanHoaChuoi(Server sv) {

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
		return ChuanHoaChuoi(tong);

	}

	// Chuan hoa PlainText tra ve Chuoi
	public String ChuanHoaChuoi(String plaintext) {
		try {

			StringReader str = new StringReader(plaintext);
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

				}
				// Chi lay nhung chuoi nao co dau = sau do thay the dau "=" ->
				// " "
				if (line.indexOf("=") != -1) {

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
		String[] mang = loadConfigToChuanHoaChuoi(sv).split("\\s+");
		// System.out.println(Arrays.asList(mang));
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

	public void inFTPObject(Ftp ftp) throws IOException {
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

	// Convert Object to XML
	public String convertObjectToXML(Ftp ftp) {

		String kq = "";
		if (ftp.getListen() != null && !ftp.getListen().equals(null)) {
			kq = kq + "<listen>" + ftp.getListen() + "</listen>" + "\n";
		}

		if (ftp.getAnonymous_enable() != null
				&& !ftp.getAnonymous_enable().equals(null)) {
			kq = kq + "<anonymous_enable>" + ftp.getAnonymous_enable()
					+ "</anonymous_enable>" + "\n";
		}

		if (ftp.getLocal_enable() != null
				&& !ftp.getLocal_enable().equals(null)) {
			kq = kq + "<local_enable>" + ftp.getLocal_enable()
					+ "</local_enable>" + "\n";
		}

		if (ftp.getWrite_enable() != null
				&& !ftp.getWrite_enable().equals(null)) {
			kq = kq + "<write_enable>" + ftp.getWrite_enable()
					+ "</write_enable>" + "\n";
		}

		if (ftp.getAnon_upload_enable() != null
				&& !ftp.getAnon_upload_enable().equals(null)) {
			kq = kq + "<anon_upload_enable>" + ftp.getAnon_upload_enable()
					+ "</anon_upload_enable>" + "\n";
		}

		if (ftp.getAnon_mkdir_write_enable() != null
				&& !ftp.getAnon_mkdir_write_enable().equals(null)) {
			kq = kq + "<anon_mkdir_write_enable>"
					+ ftp.getAnon_mkdir_write_enable()
					+ "</anon_mkdir_write_enable>" + "\n";
		}

		if (ftp.getConnect_from_port_20() != null
				&& !ftp.getConnect_from_port_20().equals(null)) {
			kq = kq + "<connect_from_port_20>" + ftp.getConnect_from_port_20()
					+ "</connect_from_port_20>" + "\n";
		}

		if (ftp.getDeny_email_enable() != null
				&& !ftp.getDeny_email_enable().equals(null)) {
			kq = kq + "<deny_email_enable>" + ftp.getDeny_email_enable()
					+ "</deny_email_enable>" + "\n";
		}

		if (ftp.getChroot_local_user() != null
				&& !ftp.getChroot_local_user().equals(null)) {
			kq = kq + "<chroot_local_user>" + ftp.getChroot_local_user()
					+ "</chroot_local_user>" + "\n";
		}

		if (ftp.getChroot_list_enable() != null
				&& !ftp.getChroot_list_enable().equals(null)) {
			kq = kq + "<chroot_list_enable>" + ftp.getChroot_list_enable()
					+ "</chroot_list_enable>" + "\n";
		}

		if (ftp.getChroot_list_file() != null
				&& !ftp.getChroot_list_file().equals(null)) {
			kq = kq + "<chroot_list_file>" + ftp.getChroot_list_file()
					+ "</chroot_list_file>" + "\n";
		}
		return "<ftp>" + "\n" + kq + "</ftp>";

	}

	// Convert XML to Object
	public Ftp convertXMLToObject(String xmlString)
			throws FileNotFoundException {

		StringReader strRead = new StringReader(xmlString);
		// FileReader fr = new FileReader(new File("E:\\tuine.txt"));
		try {
			// Khoi tao Context
			JAXBContext context = JAXBContext.newInstance(Ftp.class);
			// Tao Unmarshaller tu Context
			Unmarshaller un = context.createUnmarshaller();
			// File xml phu thuoc vao doi tuong + duong duong path
			Ftp ftp = (Ftp) un.unmarshal(strRead);
			// System.out.println(ftp.getListen());
			return ftp;

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (NullPointerException nu) {
		}
		return null;

	}

	public static void main(String[] args) throws IOException {

		FtpConfig ftp_c = new FtpConfig();
		Server sv = new Server(1, "192.168.0.104", 22, "mayb", "root", "root"); // ftp_c.Install(sv);
		// In ra chuoi chuan hoa
		// System.out.println(ftp_c.ChuanHoaChuoi(sv));
		// In ra FTP
		ftp_c.inFTPObject(ftp_c.convertTextToObject(sv));

		System.out.println("--------Uploading.....to Server---------------");

		ftp_c.uploadConfigToServer(sv, ftp_c.convertTextToObject(sv));
		System.out.println("--------Restarting.....to Server---------------");

		ftp_c.Restart(sv);

		System.out.println(ftp_c.convertObjectToXML(ftp_c
				.convertTextToObject(sv)));

		// Ftp ftp = ftp_c.convertXMLToObject(ftp_c.convertObjectToXML(ftp_c
		// .convertTextToObject(sv)));
		// System.out.println(ftp.getAnonymous_enable());
	}
}
