package model.dns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;

import model.server.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class Bind9Config {

	// Chuan hoa lan 1
	public String chuanhoaChuoi1(String chuoiCH) {

		try {

			StringReader str = new StringReader(chuoiCH);
			BufferedReader bufferedReader = new BufferedReader(str);
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {

				line = line.trim();
				// Replace nhieu khoang trang ve mot khoang trang
				line = line.replaceAll("\\s+", " ");
				// Xoa option
				line = line.replaceAll("option", "");
				line = line.trim();

				// Doi chuoi sau ki tu "{" xuong dong sau do se doi ki tu "{"
				// xuong dong o chuanhoa2
				if (line.indexOf("{") != -1) {
					line = line.replace("{", "{\n");

				}

				// Cat bo line chua "#" dau dong
				if (line.indexOf("//") != -1) {
					line = "";
				} else {
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

	// Chuan hoa lan 2
	public String chuanhoaChuoi2(String chuoiCH) throws IOException {

		String chuoilay = chuoiCH;

		chuoilay = chuoilay.replaceAll(";", ";\n");
		String line2 = "";
		String kq_lay = "";
		StringReader str2 = new StringReader(chuoilay);
		BufferedReader br = new BufferedReader(str2);
		while ((line2 = br.readLine()) != null) {
			line2 = line2.trim();
			if (line2.endsWith("{")) {
				line2 = line2.replace("{", "\n{");
			}

			kq_lay = kq_lay + line2 + "\n";
		}
		str2.close();

		return kq_lay;

	}

	// Xoa tat ca dong trong Chuan hoa 3
	public String chuanhoaChuoi3(String chuoiCH) throws IOException {

		String chuoilay = chuoiCH;

		String line2 = "";
		String kq_lay = "";
		StringReader str2 = new StringReader(chuoilay);
		BufferedReader br = new BufferedReader(str2);
		while ((line2 = br.readLine()) != null) {
			line2 = line2.trim();
			// Ham xoa tat ca
			if (line2.isEmpty()) {
				continue;
			}
			kq_lay = kq_lay + line2 + "\n";
		}
		str2.close();

		return kq_lay;

	}

	// loadConfigZone
	public String loadConfigZoneToPlainText(Server sv) throws IOException {
		String kq = uploadToServer(sv, "cat /etc/bind/named.conf.local");
		kq = chuanhoaChuoi1(kq);
		kq = chuanhoaChuoi2(kq);
		kq = chuanhoaChuoi3(kq);
		return kq;
	}

	// Upload cmd / file to server phuc vu cho viec loadConfigToPlainText
	public String uploadToServer(Server sv, String cmd) {
		Session ss = sv.getSession(sv);
		try {
			String chuoilay = "";
			String tong = "";
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
					chuoilay = new String(tmp, 0, i);
					// System.out.print(chuoilay);
					tong = tong + chuoilay;

				}
				if (channel.isClosed()) {
					System.out.println("exit-status: "
							+ channel.getExitStatus());
					if (channel.getExitStatus() == 0) {
						System.out.println("***Process Success...OK");
					} else {
						System.out.println("***Process Failed...!!!");

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

	public String convertConfigZoneToXML(Server sv) throws IOException {
		StringReader str = new StringReader(loadConfigZoneToPlainText(sv));
		BufferedReader br = new BufferedReader(str);
		String line = "";
		String lay = "";
		while ((line = br.readLine()) != null) {
			if (line.indexOf("zone") != -1) {
				lay = lay
						+ "<zone>"
						+ "\n"
						+ "<name_zone>"
						+ line.substring(line.indexOf(" ")).replace("\"", "")
								.trim() + "</name_zone>" + "\n";
			}

			if (line.indexOf("type") != -1) {
				lay = lay + "<type_zone>"
						+ line.substring(line.indexOf(" ")).trim()
						+ "</type_zone>" + "\n";
				;
			}

			if (line.indexOf("file") != -1) {
				lay = lay + "<path_file>"
						+ line.substring(line.indexOf(" ")).trim()
						+ "</path_file>" + "\n" + "</zone>" + "\n";
				;
			}
		}
		return lay;
	}

	public static void main(String[] args) throws IOException {

		Bind9Config bind_c = new Bind9Config();
		Server sv = new Server(1, "192.168.0.104", 22, "mayb", "root", "root");

		System.out.println(bind_c.loadConfigZoneToPlainText(sv));
		System.out.println(bind_c.convertConfigZoneToXML(sv));

	}

}
