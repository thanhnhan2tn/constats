package model.dns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class Bind9Config {
	// Phuc vu cho start/stop/restart and upload to Config to Server
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

	// Ham dau tien yeu cau ng dung bam vao nut nay khi khoi tao dich vu bind9
	public Boolean createLoggingFile(Server sv) {
		sendCommandToServer(sv, "echo " + sv.getServerPassword() + " |sudo -S "
				+ " mkdir /var/log/named");
		sendCommandToServer(sv, "echo " + sv.getServerPassword() + " |sudo -S "
				+ " touch /var/log/named/query.log");
		sendCommandToServer(sv, "echo " + sv.getServerPassword() + " |sudo -S "
				+ " chmod 666 /var/log/named/query.log");

		return true;
	}

	// Start
	public Boolean Start(Server sv) {
		// chen restart trong day
		Restart(sv);
		String command = "echo " + sv.getServerPassword() + " |sudo -S "
				+ " service bind9 start";
		String kq = uploadToServer(sv, command);
		// System.out.println(kq);
		if (kq.indexOf("Starting") != -1 && kq.indexOf("done") != -1) {
			return true;// start thanh cong
		} else {
			return false;
		}
	}

	// Stop
	public Boolean Stop(Server sv) {
		Restart(sv);
		String command = "echo " + sv.getServerPassword() + " |sudo -S "
				+ " service bind9 stop";
		String kq = uploadToServer(sv, command);
		// System.out.println(kq);
		if (kq.indexOf("Stopping") != -1 && kq.indexOf("done") != -1) {
			return true; // stop thanh cong
		} else {
			return false;
		}
	}

	// Restart
	// uploadToServer tra ve 1 thi van true do la dieu hien nhien
	public Boolean Restart(Server sv) {
		String command = "echo " + sv.getServerPassword() + " |sudo -S "
				+ " service bind9 restart";
		String kq = uploadToServer(sv, command);
		// System.out.println(kq);
		if (kq.indexOf("Starting") != -1 && kq.indexOf("done") != -1
				&& kq.indexOf("Stopping") != -1 && kq.indexOf("done", 48) != -1) {
			return true; // restart thanh cong khi start va stop deu thanh cong
		} else {
			return false;
		}
	}

	// getError
	public String getError(Server sv) {
		Restart(sv);
		String kq = uploadToServer(sv, "echo " + sv.getServerPassword()
				+ "| sudo -S " + " tail -10 /var/log/syslog | grep 'named'");

		return kq;
	}

	// getLog
	public String getLog(Server sv) {
		Restart(sv);
		String kq = uploadToServer(sv, "echo " + sv.getServerPassword()
				+ "| sudo -S " + " cat /var/log/named/query.log");

		return kq;
	}

	// check Install
	public Boolean checkInstall(Server sv) {
		String command = "echo " + sv.getServerPassword() + " |sudo -S "
				+ "dpkg --get-selections | grep 'bind9\\s' | awk '{print $2}'";
		String kq = uploadToServer(sv, command);
		if (kq.startsWith("deinstall") || kq.length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	// checkRunning
	public Boolean checkRunning(Server sv) {
		// installed roi moi check running dc
		if (checkInstall(sv) == true) {
			String command = "echo " + sv.getServerPassword() + " |sudo -S "
					+ " service bind9 status";
			String kq = uploadToServer(sv, command);
			if (kq.indexOf("not running") != -1 || kq.indexOf("stop") != -1
					|| kq.indexOf("waiting") != -1
					|| kq.indexOf("Stopping") != -1) {
				return false; // stopped
			} else {
				return true; // running -starting
			}
		} else {
			return false;
		}
	}

	// Install
	public Boolean Install(Server sv) {
		String command = "echo " + sv.getServerPassword() + " |sudo -S "
				+ " apt-get -y install bind9 ";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Remove Service
	public Boolean Remove(Server sv) {
		String command = "echo " + sv.getServerPassword() + " |sudo -S "
				+ " apt-get -y --purge remove bind9 ";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

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
				// line = line.replaceAll("\"", "");

				line = line.trim();

				// Doi chuoi sau ki tu "{" xuong dong sau do se doi ki tu "{"
				// xuong dong o chuanhoa2
				if (line.indexOf("{") != -1) {
					line = line.replace("{", "{\n");

				}

				// Cat bo line chua "#" dau dong
				if (line.indexOf("//") != -1 || line.indexOf("#") != -1) {
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
			// ham xu ly dau ";"
			if (line2.indexOf(" ;") != -1) {
				line2 = line2.replace(" ;", ";");

			}

			if (line2.indexOf("; ") != -1) {
				line2 = line2.replace("; ", ";");

			}

			if (line2.indexOf(" ; ") != -1) {
				line2 = line2.replace(" ; ", ";");

			}

			// Ham xoa tat ca
			if (line2.isEmpty()) {
				continue;
			}
			kq_lay = kq_lay + line2 + "\n";
		}
		str2.close();

		return kq_lay;

	}

	// Xoa tat ca dong trong Chuan hoa 4, tao khoang trang o moi zone
	// public String chuanhoaChuoi4(String chuoiCH) throws IOException {
	//
	// String chuoilay = chuoiCH;
	//
	// String line2 = "";
	// String kq_lay = "";
	// StringReader str2 = new StringReader(chuoilay);
	// BufferedReader br = new BufferedReader(str2);
	// int m = 0;
	// while ((line2 = br.readLine()) != null) {
	// line2 = line2.trim();
	// // Neu dong chua "zone" va dong phai > 1, nghia la tu zong thu 2 tro
	// // ve sau
	// if (line2.indexOf("zone") != -1 && m > 0) {
	// line2 = "\n" + line2;
	// }
	// kq_lay = kq_lay + line2 + "\n";
	// m++;
	// }
	// str2.close();
	//
	// return kq_lay;
	//
	// }

	// Xoa tat ca dong trong Chuan hoa 5, danh dau ki tu dac biet vao moi khoang
	// trang o moi zone, ho tro cho viec tao doi tuong
	// public String chuanhoaChuoi5(String chuoiCH) throws IOException {
	//
	// String chuoilay = chuoiCH;
	//
	// String line2 = "";
	// String kq_lay = "";
	// StringReader str2 = new StringReader(chuoilay);
	// BufferedReader br = new BufferedReader(str2);
	// while ((line2 = br.readLine()) != null) {
	// line2 = line2.trim();
	// // Danh dau ki tu dac biet vao nhung cho la khoang trang
	// if (line2.isEmpty()) {
	// line2 = line2 + "&&&";
	// }
	// kq_lay = kq_lay + line2 + "\n";
	// }
	// str2.close();
	// // Them ki tu dac biet vao khoang trang cuoi dong
	// return kq_lay + "&&&";
	//
	// }

	// loadConfigZone
	public String loadZoneToPlainText(Server sv) throws IOException {
		String kq = uploadToServer(sv, "cat /etc/bind/named.conf.local");
		kq = chuanhoaChuoi1(kq);
		kq = chuanhoaChuoi2(kq);
		kq = chuanhoaChuoi3(kq);
		// kq = chuanhoaChuoi4(kq);
		// kq = chuanhoaChuoi5(kq);

		return kq;
	}

	// load ACL to Plaintext + Chuan hoa
	public String loadACLToPlainText(Server sv) throws IOException {
		String kq = uploadToServer(sv, "cat /etc/bind/named.conf");
		kq = chuanhoaChuoi1(kq);
		kq = chuanhoaChuoi2(kq);
		kq = chuanhoaChuoi3(kq);
		// kq = chuanhoaChuoi4(kq);
		// kq = chuanhoaChuoi5(kq);

		return kq;
	}

	// Convert ACL Config to ACL Xml
	public String convertACLToXML(Server sv) throws IOException {

		StringReader str = new StringReader(loadACLToPlainText(sv));
		BufferedReader br = new BufferedReader(str);
		String line = "";
		String lay = "";
		while ((line = br.readLine()) != null) {

			if (line.indexOf("acl") != -1) {
				lay = lay + "<acl>" + "\n" + "<access_name>"
						+ line.substring(line.indexOf(" ")).trim()
						+ "</access_name>" + "\n";
			}
			// Do da indexOf (";") nen xem nhu ko lay dau ";"
			if (line.matches("\\d+.\\d+.\\d+.\\d+.")) {
				lay = lay + "<ip>"
						+ line.substring(0, line.indexOf(";")).trim() + "</ip>"
						+ "\n";

			}

			// if (line.matches("\\w+;")) {
			// lay = lay + "<ip>"
			// + line.substring(0, line.indexOf(";")).trim() + "</ip>"
			// + "\n";
			//
			// }
			if (line.indexOf("};") != -1) {
				lay = lay + "</acl>" + "\n\n";
			}

		}
		return lay;

	}

	// load Options to Plaintext + Chuan hoa
	public String loadOptionsToPlainText(Server sv) throws IOException {
		String kq = uploadToServer(sv, "cat /etc/bind/named.conf.options");
		kq = chuanhoaChuoi1(kq);
		kq = chuanhoaChuoi2(kq);
		kq = chuanhoaChuoi3(kq);
		// kq = chuanhoaChuoi4(kq);
		// kq = chuanhoaChuoi5(kq);

		return kq;
	}

	// convert Options to XML
	public String convertOptionsToXML(Server sv) throws IOException {
		String xmlText = "";// cong dan dan
		String lay = loadOptionsToPlainText(sv);

		// -----Lay doi tuong dac biet
		// In ra thu
		// Bat dau
		// tim tat ca cac doi tuong dac biet
		String regexALL = ".+\n\\{\n[-\\w+\\d+.;\n]+\n\\};";
		// tim chuoi la ip
		String iporacl = "[^forwarders allow\\-recursion allow\\-query allow\\-transfer allow\\-notify \\{\\}][-\\w+\\d+.\n;]+";
		// tim doi tuong forwarders
		String regexForwarders = "forwarders\n\\{\n[-\\w+\\d+.;\n]+\n\\};";
		// tim doi tuong allow query
		String regexAllowQuery = "allow-query\n\\{\n[-\\w+\\d+.;\n]+\n\\};";
		// tim doi tuong allow recursion
		String regexAllowRecursion = "allow-recursion\n\\{\n[-\\w+\\d+.;\n]+\n\\};";
		// tim doi tuong allow transfer
		String regexAllowTransfer = "allow-transfer\n\\{\n[-\\w+\\d+.;\n]+\n\\};";
		// tim doi tuong allow notify
		String regexAllowNotify = "allow-notify\n\\{\n[-\\w+\\d+.;\n]+\n\\};";

		Pattern pt = Pattern.compile(regexALL);
		Matcher matcher = pt.matcher(lay);
		while (matcher.find()) {
			// System.out.println("In ra---------- \n" + matcher.group());
			if (matcher.group().matches(regexForwarders)) {
				Pattern pt1 = Pattern.compile(iporacl);
				Matcher matcher1 = pt1.matcher(matcher.group());
				while (matcher1.find()) {

					xmlText = xmlText + "<forwarders>" + matcher1.group()
							+ "</forwarders>" + "\n\n";

				}
			}

			if (matcher.group().matches(regexAllowQuery)) {
				Pattern pt1 = Pattern.compile(iporacl);
				Matcher matcher1 = pt1.matcher(matcher.group());
				while (matcher1.find()) {

					xmlText = xmlText + "<allow_query>" + matcher1.group()
							+ "</allow_query>" + "\n\n";

				}
			}

			if (matcher.group().matches(regexAllowRecursion)) {
				// System.out.println(matcher.group());
				Pattern pt1 = Pattern.compile(iporacl);
				Matcher matcher1 = pt1.matcher(matcher.group());
				while (matcher1.find()) {

					xmlText = xmlText + "<allow_recursion>" + matcher1.group()
							+ "</allow_recursion>" + "\n\n";

				}
			}

			if (matcher.group().matches(regexAllowTransfer)) {
				// System.out.println(matcher.group());
				Pattern pt1 = Pattern.compile(iporacl);
				Matcher matcher1 = pt1.matcher(matcher.group());
				while (matcher1.find()) {

					xmlText = xmlText + "<allow_transfer>" + matcher1.group()
							+ "</allow_transfer>" + "\n\n";

				}
			}

			if (matcher.group().matches(regexAllowNotify)) {
				// System.out.println(matcher.group());
				Pattern pt1 = Pattern.compile(iporacl);
				Matcher matcher1 = pt1.matcher(matcher.group());
				while (matcher1.find()) {

					xmlText = xmlText + "<allow_notify>" + matcher1.group()
							+ "</allow_notify>" + "\n\n";

				}
			}
		}
		// Ket thuc mot doi tuong
		// --------------
		// Convert 1 para 1 value to XML
		// String option_text = loadOptionsToPlainText(sv);
		// System.out.println(option_text);
		StringReader str = new StringReader(lay);
		BufferedReader br = new BufferedReader(str);
		String line = "";
		String tong = "";
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.indexOf("directory") != -1) {
				tong = tong
						+ "<directory>"
						+ line.substring(line.indexOf(" ") + 1)
								.replace("\"", "").replace(";", "")
						+ "</directory>" + "\n";

			}

			if (line.indexOf("multiple-cnames") != -1) {
				if (line.substring(line.indexOf(" ") + 1).replace(";", "")
						.trim().equals("yes")) {
					tong = tong + "<multiple_cname>" + true
							+ "</multiple_cname>" + "\n";
				} else {
					tong = tong + "<multiple_cname>" + false
							+ "</multiple_cname>" + "\n";
				}
			}
			// luu y neu trung voi nhung gia tri khac khi dung indexOf, khi thuc
			// thi se ko hien ra ket qua
			if (line.startsWith("recursion")) {
				if (line.substring(line.indexOf(" ") + 1).replace(";", "")
						.trim().equals("yes")) {
					tong = tong + "<recursion>" + true + "</recursion>" + "\n";
				} else {
					tong = tong + "<recursion>" + false + "</recursion>" + "\n";

				}
			}
			// luu y khoang trang cua forward
			if (line.startsWith("forward ")) {
				if (line.substring(line.indexOf(" ") + 1).replace(";", "")
						.trim().equals("only")) {
					tong = tong + "<forward>" + true + "</forward>" + "\n";
				} else {
					tong = tong + "<forward>" + false + "</forward>" + "\n";

				}

			}

		}
		str.close();

		// ---

		return "<option>" + tong + "\n" + xmlText + "</option>";
	}

	// load path_file zone dung de get nhung SOA record tuong ung voi moi zone
	public List<String> loadPathFileZoneToPlainText(Server sv)
			throws IOException {
		String kq = uploadToServer(sv, "cat /etc/bind/named.conf.local");
		kq = chuanhoaChuoi1(kq);
		kq = chuanhoaChuoi2(kq);
		kq = chuanhoaChuoi3(kq);
		StringReader str = new StringReader(kq);
		BufferedReader br = new BufferedReader(str);
		String line = "";
		List<String> file_multi = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			// If file /var/log then continue;
			if (line.indexOf("file \"/var/log") != -1) {
				continue;
			}
			if (line.indexOf("file") != -1) {
				file_multi.add(line.substring(line.indexOf(" "))
						.replace("\"", "").trim());

			}
		}
		return file_multi;
	}

	// Chuan hoa SOA lan 1
	public String chuanhoaChuoiSOA1(String chuoiCH) {

		try {

			StringReader str = new StringReader(chuoiCH);
			BufferedReader bufferedReader = new BufferedReader(str);
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {

				line = line.trim();
				// Replace nhieu khoang trang ve mot khoang trang
				line = line.replaceAll("\\s+", " ");
				// Xoa IN trong tung record
				line = line.replaceAll("IN", "");
				// line = line.replaceAll("AAAA", "");

				line = line.trim();

				// Doi chuoi sau ki tu "{" xuong dong sau do se doi ki tu "{"
				// xuong dong o chuanhoa2
				if (line.indexOf("{") != -1) {
					line = line.replace("{", "{\n");

				}
				if (line.startsWith(";")) {
					continue;
				}

				if (line.indexOf("AAAA") != -1) {
					continue;
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

	// Chuan hoa SOA lan 2
	public String chuanhoaChuoiSOA2(String chuoiCH) throws IOException {

		String chuoilay = chuoiCH;

		// chuoilay = chuoilay.replaceAll(";", ";\n");
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

	// Xoa tat ca dong trong Chuan hoa SOA 3
	public String chuanhoaChuoiSOA3(String chuoiCH) throws IOException {

		String chuoilay = chuoiCH;

		String line2 = "";
		String kq_lay = "";
		StringReader str2 = new StringReader(chuoilay);
		BufferedReader br = new BufferedReader(str2);
		while ((line2 = br.readLine()) != null) {
			line2 = line2.replaceAll("\\s+", " ");
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

	// load SOA record
	public String loadSOAToPlainText(Server sv) throws IOException {
		System.out.println("loadPathFileZoneToPlainText(sv).....loading...");
		List<String> list_file = loadPathFileZoneToPlainText(sv);
		int i = 0;
		String kq = "";
		String tong = "";
		while (i < list_file.size()) {
			// Giup cho viec load pathFile ko bi loi
			kq = uploadToServer(sv, "cat " + list_file.get(i).replace(";", ""));
			// System.out.println(list_file.get(i).replace(";", ""));
			if (kq != null && !kq.equals("") && !kq.isEmpty()
					&& kq.indexOf("$TTL") != -1 && kq.indexOf("SOA") != -1) {
				kq = chuanhoaChuoiSOA1(kq);
				kq = chuanhoaChuoiSOA2(kq);
				kq = chuanhoaChuoiSOA3(kq);
				tong = tong + kq + "path:" + list_file.get(i).replace(";", "")
						+ "\n" + "&&&" + "\n";
			} else {
				System.out.println("Can't find SOA record at path:" + "\""
						+ list_file.get(i) + "\"" + "!!!");
			}
			i++;
		}

		return tong;
	}

	// convert SOA to Xml
	public String convertSOAToXML(Server sv) throws IOException {
		StringReader str = new StringReader(loadSOAToPlainText(sv));
		BufferedReader br = new BufferedReader(str);
		String line = "";
		String lay = "";
		// int k = 0;
		while ((line = br.readLine()) != null) {
			if (line.indexOf("$TTL") != -1) {
				// k++;
				lay = lay + "<soa>" + "\n" + "<ttl>"
						+ line.substring(line.indexOf(" ")).trim() + "</ttl>"
						+ "\n";
			}

			if (line.indexOf("SOA") != -1) {
				lay = lay
						+ "<domain_name>"
						+ line.substring(line.indexOf(" ", 4),
								line.indexOf(" ", 6)).trim() + "</domain_name>"
						+ "\n";

				lay = lay
						+ "<admin_domain>"
						+ line.substring(line.indexOf(" ", 6),
								line.lastIndexOf("(")).trim()
						+ "</admin_domain>" + "\n";

			}

			if (line.indexOf("Serial") != -1) {
				lay = lay + "<serial>"
						+ line.substring(0, line.indexOf(";")).trim()
						+ "</serial>" + "\n";

			}
			if (line.indexOf("Refresh") != -1) {
				lay = lay + "<refresh>"
						+ line.substring(0, line.indexOf(";")).trim()
						+ "</refresh>" + "\n";

			}

			if (line.indexOf("Retry") != -1) {
				lay = lay + "<retry>"
						+ line.substring(0, line.indexOf(";")).trim()
						+ "</retry>" + "\n";

			}

			if (line.indexOf("Expire") != -1) {
				lay = lay + "<expire>"
						+ line.substring(0, line.indexOf(";")).trim()
						+ "</expire>" + "\n";

			}

			if (line.indexOf("Cache TTL") != -1) {
				lay = lay + "<min_ttl>"
						+ line.substring(0, line.indexOf(")")).trim()
						+ "</min_ttl>" + "\n";

			}

			// Record NS
			if (line.indexOf("NS") != -1) {
				lay = lay + "<record>" + "\n";
				lay = lay + "<domain_name>"
						+ line.substring(0, line.indexOf(" ")).trim()
						+ "</domain_name>" + "\n";
				lay = lay + "<type_record>" + "NS" + "</type_record>" + "\n";
				lay = lay + "<name_server>"
						+ line.substring(line.indexOf("NS") + 2).trim()
						+ "</name_server>" + "\n";
				lay = lay + "</record>" + "\n";

			}
			// Record MX
			if (line.indexOf("MX") != -1) {
				lay = lay + "<record>" + "\n";
				lay = lay + "<domain_name>"
						+ line.substring(0, line.indexOf(" ")).trim()
						+ "</domain_name>" + "\n";
				lay = lay
						+ "<priority>"
						+ line.substring(line.indexOf(" ", line.indexOf("MX")),
								line.lastIndexOf(" ")).trim() + "</priority>"
						+ "\n";
				lay = lay + "<type_record>" + "MX" + "</type_record>" + "\n";
				lay = lay + "<name_server>"
						+ line.substring(line.lastIndexOf(" ")).trim()
						+ "</name_server>" + "\n";
				lay = lay + "</record>" + "\n";

			}

			// Record PTR
			if (line.indexOf("PTR") != -1) {
				lay = lay + "<record>" + "\n";
				lay = lay + "<domain_name>"
						+ line.substring(0, line.indexOf(" ")).trim()
						+ "</domain_name>" + "\n";
				lay = lay + "<type_record>" + "PTR" + "</type_record>" + "\n";
				lay = lay + "<name_server>"
						+ line.substring(line.indexOf("PTR") + 3).trim()
						+ "</name_server>" + "\n";
				lay = lay + "</record>" + "\n";

			}

			// Record CNAME
			if (line.indexOf("CNAME") != -1) {
				lay = lay + "<record>" + "\n";
				lay = lay + "<domain_name>"
						+ line.substring(0, line.indexOf(" ")).trim()
						+ "</domain_name>" + "\n";
				lay = lay + "<type_record>" + "CNAME" + "</type_record>" + "\n";
				lay = lay + "<name_server>"
						+ line.substring(line.indexOf("CNAME") + 5).trim()
						+ "</name_server>" + "\n";
				lay = lay + "</record>" + "\n";

			}
			// Phan biet voi SOA khi index, record A
			if (line.indexOf(" A ") != -1) {
				lay = lay + "<record>" + "\n";
				lay = lay + "<domain_name>"
						+ line.substring(0, line.indexOf(" ")).trim()
						+ "</domain_name>" + "\n";
				lay = lay + "<type_record>" + "A" + "</type_record>" + "\n";
				lay = lay + "<name_server>"
						+ line.substring(line.indexOf("A") + 1).trim()
						+ "</name_server>" + "\n";
				lay = lay + "</record>" + "\n";

			}
			if (line.indexOf("path:") != -1) {
				lay = lay + "<pathfile>"
						+ line.substring(line.indexOf(":") + 1) + "</pathfile>"
						+ "\n";
			}

			if (line.indexOf("&&&") != -1) {
				lay = lay + "</soa>" + "\n\n";
			}

		}
		return lay;
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

	public String convertZoneToXML(Server sv) throws IOException {
		String lay = loadZoneToPlainText(sv);
		// System.out.println(lay);
		// Da bo di nhan dang ";" sau moi zone
		String xmlText = "";
		String regexZoneBT = "zone .+\n\\{\ntype master;\nfile .+\n\\}";
		String regexZoneName = "zone .+";
		String regexZoneForwarders = "zone .+\n\\{\ntype forward;\nforwarders\n\\{\n[\\d+.;\n]+\n\\};\n\\}";
		String regexZoneSlave = "zone .+\n\\{\ntype slave;\nmasters\n\\{\n[\\d+.;\n]+\n\\};\nfile .+\n\\}";
		// Zone binh thuong
		Pattern pt = Pattern.compile(regexZoneBT);
		Matcher matcher = pt.matcher(lay);
		while (matcher.find()) {
			xmlText = xmlText + "<zone>" + "\n";

			Pattern pt2 = Pattern.compile(regexZoneName);
			Matcher matcher2 = pt2.matcher(matcher.group());
			while (matcher2.find()) {
				xmlText = xmlText
						+ "<zone_name>"
						+ matcher2.group().replace("zone", "")
								.replace("\"", "").trim() + "</zone_name>"
						+ "\n";

			}

			Pattern pt3 = Pattern.compile("type master");
			Matcher matcher3 = pt3.matcher(matcher.group());
			while (matcher3.find()) {
				xmlText = xmlText
						+ "<zone_type>"
						+ matcher3.group().replace(";", "").replace("type", "")
								.trim() + "</zone_type>" + "\n";

			}

			Pattern pt4 = Pattern.compile("file .+");
			Matcher matcher4 = pt4.matcher(matcher.group());
			while (matcher4.find()) {
				xmlText = xmlText
						+ "<zone_file>"
						+ matcher4.group().replace(";", "").replace("file", "")
								.replace("\"", "").trim() + "</zone_file>"
						+ "\n";

			}
			xmlText = xmlText + "</zone>" + "\n\n";

		}
		// zone forward
		Pattern pt5 = Pattern.compile(regexZoneForwarders);
		Matcher matcher5 = pt5.matcher(lay);
		while (matcher5.find()) {
			xmlText = xmlText + "<zone>" + "\n";

			Pattern pt2 = Pattern.compile(regexZoneName);
			Matcher matcher2 = pt2.matcher(matcher5.group());
			while (matcher2.find()) {
				xmlText = xmlText
						+ "<zone_name>"
						+ matcher2.group().replace("zone", "")
								.replace("\"", "").trim() + "</zone_name>"
						+ "\n";

			}

			Pattern pt3 = Pattern.compile("type forward");
			Matcher matcher3 = pt3.matcher(matcher5.group());
			while (matcher3.find()) {
				xmlText = xmlText
						+ "<zone_type>"
						+ matcher3.group().replace(";", "").replace("type", "")
								.trim() + "</zone_type>" + "\n";

			}

			Pattern pt4 = Pattern
					.compile("forwarders\n\\{\n[\\d+.;\n]+\n\\};\n\\};");
			Matcher matcher4 = pt4.matcher(matcher5.group());
			while (matcher4.find()) {
				xmlText = xmlText + "<forwarders>" + "\n";
				xmlText = xmlText
						+ matcher4.group().replace("{", "").replace("};", "")
								.replace("forwarders", "").replace(";", ";\n")
								.replaceAll("\\s+", " ") + "\n";
				xmlText = xmlText + "</forwarders>" + "\n";

			}
			xmlText = xmlText + "</zone>" + "\n\n";

		}
		// Slave zone
		Pattern pt6 = Pattern.compile(regexZoneSlave);
		Matcher matcher6 = pt6.matcher(lay);
		while (matcher6.find()) {
			// System.out.println(matcher6.group());
			xmlText = xmlText + "<zone>" + "\n";

			Pattern pt2 = Pattern.compile(regexZoneName);
			Matcher matcher2 = pt2.matcher(matcher6.group());
			while (matcher2.find()) {
				xmlText = xmlText
						+ "<zone_name>"
						+ matcher2.group().replace("zone", "")
								.replace("\"", "").trim() + "</zone_name>"
						+ "\n";

			}

			Pattern pt3 = Pattern.compile("type slave");
			Matcher matcher3 = pt3.matcher(matcher6.group());
			while (matcher3.find()) {
				xmlText = xmlText
						+ "<zone_type>"
						+ matcher3.group().replace(";", "").replace(";", "")
								.replace("type", "").trim() + "</zone_type>"
						+ "\n";

			}

			Pattern pt4 = Pattern.compile("masters\n\\{\n[\\d+.;\n]+\n\\};");
			Matcher matcher4 = pt4.matcher(matcher6.group());
			while (matcher4.find()) {
				xmlText = xmlText + "<masters>" + "\n";
				xmlText = xmlText
						+ matcher4.group().replace("{", "").replace("};", "")
								.replace("masters", "").replace(";", ";\n")
								.replaceAll("\\s+", " ") + "\n";
				xmlText = xmlText + "</masters>" + "\n";

			}

			Pattern pt10 = Pattern.compile("file .+");
			Matcher matcher10 = pt10.matcher(matcher6.group());
			while (matcher10.find()) {
				xmlText = xmlText
						+ "<zone_file>"
						+ matcher10.group().replace(";", "")
								.replace("file", "").replace("\"", "").trim()
						+ "</zone_file>" + "\n";

			}
			xmlText = xmlText + "</zone>" + "\n\n";

		}
		// ------
		return xmlText;
	}

	// get DNS XML - File Tong The
	public String convertConfigToDNSXml(Server sv) throws IOException {
		String xmlDNSConfig = "";
		xmlDNSConfig = xmlDNSConfig + convertZoneToXML(sv) + "\n"
				+ convertSOAToXML(sv) + "\n" + convertACLToXML(sv) + "\n"
				+ convertOptionsToXML(sv);
		return "<dns>" + xmlDNSConfig + "</dns>";
	}

	// convert XML to Object DNS, ham nay ko truyen tham so
	public Dns convertXMLToObjectDNS(Server sv) throws IOException {
		StringReader strRead = new StringReader(convertConfigToDNSXml(sv));

		try {
			// Khoi tao Context
			JAXBContext context = JAXBContext.newInstance(Dns.class);
			// Tao Unmarshaller tu Context
			Unmarshaller un = context.createUnmarshaller();
			// File xml phu thuoc vao doi tuong + duong duong path
			// Dns dns = (Dns) un.unmarshal(new File("E:\\bind.txt"));
			Dns dns = (Dns) un.unmarshal(strRead);
			// for (Zone zone : dns.getZone()) {
			// System.out.println(zone.getZone_file());
			//
			// }
			return dns;

		}

		catch (JAXBException e) {
			e.printStackTrace();
		} catch (NullPointerException nu) {
		}
		return null;
	}

	/**
	 * 
	 * @param sv
	 * @param zone
	 * @return
	 */
	// create ZONE, nhan tham so truyen vao zone, create SOA Default tu dong
	public Boolean createZone(Server sv, Zone zone) {
		String command = "";

		if (zone.getZone_name() != null && !zone.getZone_name().equals("")) {
			command = command + "zone " + "\\\"\"" + zone.getZone_name()
					+ "\\\"\"" + "\n";
		}
		command = command + "{" + "\n";

		if (zone.getZone_type() != null && !zone.getZone_type().equals("")) {
			command = command + "type " + zone.getZone_type() + ";" + "\n";
		}

		// Neu type zone = "forward" thi ko in zone file neu du thua du lieu tu
		// object
		if (zone.getZone_file() != null && !zone.getZone_file().equals("")
				&& !zone.getZone_type().equals("forward")) {
			command = command + "file " + "\\\"\"" + zone.getZone_file()
					+ "\\\"\"" + ";" + "\n";
		}

		if (zone.getForwarders() != null && !zone.getForwarders().equals("")) {
			command = command + "forwarders " + "\n" + "{" + "\n" + ""
					+ zone.getForwarders().trim() + "" + "\n" + "}" + ";"
					+ "\n";
		}

		if (zone.getMasters() != null && !zone.getMasters().equals("")) {
			command = command + "masters " + "\n" + "{" + "\n" + ""
					+ zone.getMasters().trim() + "" + "\n" + "}" + ";" + "\n";
		}
		command = command + "}" + ";" + "\n\n";

		command = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\"" + command + "\""
				+ "   >> /etc/bind/named.conf.local '";
		// System.out.println(command);
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			System.out.println("Created ZONE Success...OK");
		} else {
			System.out.println("Create ZONE Failed !!!");

		}

		createSOARecordFromFileZone(sv, zone);

		return boo;
	}

	/**
	 * 
	 * @param sv
	 * @param zoneFile
	 * @return
	 */
	// create SOA record from "file" in zone
	public Boolean createSOARecordFromFileZone(Server sv, Zone zone) {
		String command = "";
		// Tao list Record
		List<Record> list_record = new ArrayList<Record>();
		// Tao 2 Record mac dinh
		Record record1 = new Record("@", "NS", zone.getZone_name() + ".", null);
		Record record2 = new Record("@", "A", "127.0.0.1", null);
		// Add 2 record vao
		list_record.add(record1);
		list_record.add(record2);
		// -----------------
		// Tao doi tuong SOA mac dinh
		SOA soa = new SOA("604800", zone.getZone_name() + ".", "root."
				+ zone.getZone_name() + ".", 2, 604800, 86400, 2419200, 604800,
				list_record, zone.getZone_file());
		if (soa.getTtl() != null && !soa.getTtl().equals("")) {
			command = command + "\\$TTL " + soa.getTtl() + "\n";
		}

		if (soa.getDomain_name() != null && !soa.getDomain_name().equals("")
				&& soa.getAdmin_domain() != null
				&& !soa.getAdmin_domain().equals("")) {
			command = command + "@    IN    SOA      " + soa.getDomain_name()
					+ "     " + soa.getAdmin_domain() + "(" + "\n";
		}

		if (Integer.toString(soa.getSerial()) != null
				&& !Integer.toString(soa.getSerial()).equals("")) {
			command = command + "           " + soa.getSerial() + "; "
					+ "Serial" + "\n";
		}

		if (Integer.toString(soa.getRefresh()) != null
				&& !Integer.toString(soa.getRefresh()).equals("")) {
			command = command + "           " + soa.getRefresh() + "; "
					+ "Refresh" + "\n";
		}

		if (Integer.toString(soa.getRetry()) != null
				&& !Integer.toString(soa.getRetry()).equals("")) {
			command = command + "           " + soa.getRetry() + "; " + "Retry"
					+ "\n";
		}

		if (Integer.toString(soa.getExpire()) != null
				&& !Integer.toString(soa.getExpire()).equals("")) {
			command = command + "           " + soa.getExpire() + "; "
					+ "Expire " + "\n";
		}

		if (Integer.toString(soa.getMin_ttl()) != null
				&& !Integer.toString(soa.getMin_ttl()).equals("")) {
			command = command + "           " + soa.getMin_ttl() + ")      "
					+ "; " + "Negative Cache TTL " + "\n" + ";" + "\n";
		}

		for (Record record : soa.getRecord()) {
			if (record.getDomain_name() != null
					&& !record.getDomain_name().equals("")) {
				command = command + record.getDomain_name() + " " + "IN" + " ";

			}

			if (record.getType_record() != null
					&& !record.getType_record().equals("")) {
				command = command + record.getType_record() + " ";

			}

			if (record.getPriority() != null
					&& !record.getPriority().equals("")) {
				command = command + record.getPriority() + " ";

			}

			if (record.getName_server() != null
					&& !record.getName_server().equals("")) {
				command = command + record.getName_server() + "\n";

			}

		}
		command = command + "\n\n";
		// upload tung path SOA rieng tai day
		command = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\"" + command + "\""
				+ "   > " + soa.getPathfile() + "  '";
		// System.out.println("in di cu" + soa.getPathfile());

		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			System.out.println("Create SOA to " + "\"" + soa.getPathfile()
					+ "\"" + " Success...OK");
			return true;

		} else {
			System.out.println("Create SOA Failed !!!");
			return false;
		}

	}

	// Upload Zone to Server, yeu cau ";", o bind9 vi day la dich vu tach biet
	// nen cau hinh nen tra ve tung doi tuong ung vs tung path cau hinh
	// Sua/Xoa
	public Boolean uploadZoneToServer(Server sv, List<Zone> listZone,
			String zonename) {
		String command = "";
		for (Zone zone : listZone) {
			if (zone.getZone_name().equals(zonename)) {
				continue;
			}
			if (zone.getZone_name() != null && !zone.getZone_name().equals("")) {
				command = command + "zone " + "\\\"\"" + zone.getZone_name()
						+ "\\\"\"" + "\n";
			}
			command = command + "{" + "\n";

			if (zone.getZone_type() != null && !zone.getZone_type().equals("")) {
				command = command + "type " + zone.getZone_type() + ";" + "\n";
			}

			if (zone.getZone_file() != null && !zone.getZone_file().equals("")) {
				command = command + "file " + "\\\"\"" + zone.getZone_file()
						+ "\\\"\"" + ";" + "\n";
			}

			if (zone.getForwarders() != null
					&& !zone.getForwarders().equals("")) {
				command = command + "forwarders " + "\n" + "{" + "\n" + ""
						+ zone.getForwarders().trim() + "" + "\n" + "}" + ";"
						+ "\n";
			}

			if (zone.getMasters() != null && !zone.getMasters().equals("")) {
				command = command + "masters " + "\n" + "{" + "\n" + ""
						+ zone.getMasters().trim() + "" + "\n" + "}" + ";"
						+ "\n";
			}
			command = command + "}" + ";" + "\n\n";

		}

		String logging_config = "logging {\n" + "channel query_log {\n"
				+ "file " + "\\\"\"" + "/var/log/named/query.log" + "\\\"\""
				+ ";" + "severity dynamic;" + "\n" + "print-category yes;"
				+ "\n" + "print-severity yes;" + "\n" + "print-time yes;"
				+ "\n" + "};" + "category queries { query_log; };\n};";
		command = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\"" + command + "\n"
				+ logging_config + "\"" + "   > /etc/bind/named.conf.local '";
		// System.out.println(command);
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			System.out.println("Uploaded ZONE Success...OK");
			return true;
		} else {
			System.out.println("Upload ZONE Failed !!!");

			return false;
		}

	}

	// upload String Zone to Server
	public Boolean uploadStringZoneToServer(Server sv, String textZone) {

		// Thay the "\"" thanh .... de thuc thi co hieu luc, giup doan lenh nhan
		// biet duoc dau ".
		String tong = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\""
				+ textZone.replace("\"", "\\\"\"") + "\""
				+ "   > /etc/bind/named.conf.local '";

		System.out.println(".....Uploading to server.....");
		Boolean boo = sendCommandToServer(sv, tong);
		if (boo == true) {
			System.out.println("Uploaded String Zone ...OK");
			// return true;
		} else {
			System.out.println("Upload String Zone Failed!!!");

			// return false;
		}
		return boo;

	}

	// Create ACL
	public Boolean createACL(Server sv, Accesslist acl) {
		String command = "";

		if (acl.getAccess_name() != null && !acl.getAccess_name().equals("")) {
			command = command + "acl " + acl.getAccess_name() + "\n" + "{"
					+ "\n";

		}
		for (String ip : acl.getIp()) {
			if (ip != null && !ip.equals("")) {
				command = command + ip + ";" + "\n";

			}
		}
		command = command + "}" + ";";
		command = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\"" + command + "\n\n"
				+ "\"" + "   >> /etc/bind/named.conf '";
		// System.out.println(command);
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			System.out.println("Created ACL Success...OK");
			return true;
		} else {
			System.out.println("Create ACL Failed !!!");

			return false;
		}

	}

	/**
	 * 
	 * @param sv
	 * @param list_acl
	 * @return Boolean
	 */
	// Upload ACL to Server, yeu cau phai dat dau ";" / Xoa
	public Boolean uploadACLToServer(Server sv, List<Accesslist> list_acl,
			String aclRemove) {
		String command = "";
		for (Accesslist acl : list_acl) {
			if (acl.getAccess_name().equals(aclRemove)) {
				continue;
			}
			if (acl.getAccess_name() != null
					&& !acl.getAccess_name().equals("")) {
				command = command + "acl " + acl.getAccess_name() + "\n" + "{"
						+ "\n";

			}
			for (String ip : acl.getIp()) {
				if (ip != null && !ip.equals("")) {
					command = command + ip + ";" + "\n";

				}
			}
			command = command + "}" + ";" + "\n\n";
		}
		String includeConf = "include " + "\\\"\""
				+ "/etc/bind/named.conf.options" + "\\\"\"" + ";" + "\n"
				+ "include " + "\\\"\"" + "/etc/bind/named.conf.local"
				+ "\\\"\"" + ";" + "\n" + "include " + "\\\"\""
				+ "/etc/bind/named.conf.default-zones" + "\\\"\"" + ";" + "\n";
		command = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\"" + command + "\n\n"
				+ includeConf + "\"" + "   > /etc/bind/named.conf '";
		// System.out.println(command);
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			System.out.println("Uploaded ACL Success...OK");
			return true;
		} else {
			System.out.println("Upload ACL Failed !!!");

			return false;
		}

	}

	// upload String ACL to server
	public Boolean uploadStringACLToServer(Server sv, String textACL) {
		// Thay the "\"" thanh .... de thuc thi co hieu luc, giup doan lenh nhan
		// biet duoc dau ".
		String tong = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\""
				+ textACL.replace("\"", "\\\"\"") + "\""
				+ "   > /etc/bind/named.conf '";

		System.out.println(".....Uploading to server.....");
		Boolean boo = sendCommandToServer(sv, tong);
		if (boo == true) {
			System.out.println("Uploaded String ACL ...OK");
			// return true;
		} else {
			System.out.println("Upload String ACL Failed!!!");

			// return false;
		}
		return boo;

	}

	/**
	 * 
	 * @param sv
	 * @param option
	 * @return
	 */
	// Upload Options to Server
	public Boolean uploadOptionToServer(Server sv, Option option) {
		String command = "";
		// Phan chung 1 para 1 value
		if (option.getDirectory() != null && !option.getDirectory().equals("")) {
			command = command + "directory " + "\\\"\"" + option.getDirectory()
					+ "\\\"\"" + ";" + "\n";
		}

		if (option.getMultiple_cname() != null
				&& !option.getMultiple_cname().equals("")) {
			if (option.getMultiple_cname() == true) {
				command = command + "multiple-cnames " + "yes" + ";" + "\n";
			} else {
				command = command + "multiple-cnames " + "no" + ";" + "\n";

			}
		}

		if (option.getRecursion() != null && !option.getRecursion().equals("")) {
			if (option.getRecursion() == true) {
				command = command + "recursion " + "yes" + ";" + "\n";
			} else {
				command = command + "recursion " + "no" + ";" + "\n";

			}
		}

		if (option.getForward() != null && !option.getForward().equals("")) {
			if (option.getForward() == true) {
				command = command + "forward " + "only" + ";" + "\n";
			} else {
				command = command + "forward " + "first" + ";" + "\n";

			}
		}

		// Phan dac biet
		if (option.getForwarders() != null
				&& !option.getForwarders().equals("")) {
			command = command
					+ "forwarders "
					+ "{"
					+ "\n"
					+ ""
					+ option.getForwarders().replaceAll("\\s+", "")
							.replace(";", ";\n") + "" + "\n" + "}" + ";"
					+ "\n\n";
		}

		if (option.getAllow_recursion() != null
				&& !option.getAllow_recursion().equals("")) {
			command = command
					+ "allow-recursion "
					+ "{"
					+ "\n"
					+ ""
					+ option.getAllow_recursion().replaceAll("\\s+", "")
							.replace(";", ";\n") + "" + "\n" + "}" + ";"
					+ "\n\n";
		}

		if (option.getAllow_query() != null
				&& !option.getAllow_query().equals("")) {
			command = command
					+ "allow-query "
					+ "{"
					+ "\n"
					+ ""
					+ option.getAllow_query().replaceAll("\\s+", "")
							.replace(";", ";\n") + "" + "\n" + "}" + ";"
					+ "\n\n";
		}

		if (option.getAllow_transfer() != null
				&& !option.getAllow_transfer().equals("")) {
			command = command
					+ "allow-transfer "
					+ "{"
					+ "\n"
					+ ""
					+ option.getAllow_transfer().replaceAll("\\s+", "")
							.replace(";", ";\n") + "" + "\n" + "}" + ";"
					+ "\n\n";
		}

		if (option.getAllow_notify() != null
				&& !option.getAllow_notify().equals("")) {
			command = command
					+ "allow-notify "
					+ "{"
					+ "\n"
					+ ""
					+ option.getAllow_notify().replaceAll("\\s+", "")
							.replace(";", ";\n") + "" + "\n" + "}" + ";"
					+ "\n\n";
		}

		// --------
		// command = "echo -e > /etc/bind/named.conf.options " + "options { \n"
		// + command + "\n}" + ";";

		command = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\"" + "options { \n"
				+ command + "\n}" + ";" + "\""
				+ "   > /etc/bind/named.conf.options '";
		// System.out.println(command);
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			System.out.println("Uploaded OPTIONS Success...OK");
			return true;
		} else {
			System.out.println("Upload OPTIONS Failed !!!");

			return false;
		}

	}

	// Upload String Option to Server
	public Boolean uploadStringOptionToServer(Server sv, String textOption) {

		// Thay the "\"" thanh .... de thuc thi co hieu luc, giup doan lenh nhan
		// biet duoc dau ".
		String tong = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\""
				+ textOption.replace("\"", "\\\"\"") + "\""
				+ "   > /etc/bind/named.conf.options '";

		System.out.println(".....Uploading to server.....");
		Boolean boo = sendCommandToServer(sv, tong);
		if (boo == true) {
			System.out.println("Uploaded String OPTIONS ...OK");
			// return true;
		} else {
			System.out.println("Upload String OPTIONS Failed!!!");

			// return false;
		}
		return boo;

	}

	// Upload SOA to Server
	public Boolean uploadSOAToServer(Server sv, List<SOA> list_soa) {
		// Khong duoc dat return trong loop
		for (SOA soa : list_soa) {
			String command = "";

			if (soa.getTtl() != null && !soa.getTtl().equals("")) {
				command = command + "\\$TTL " + soa.getTtl() + "\n";
			}

			if (soa.getDomain_name() != null
					&& !soa.getDomain_name().equals("")
					&& soa.getAdmin_domain() != null
					&& !soa.getAdmin_domain().equals("")) {
				command = command + "@    IN    SOA      "
						+ soa.getDomain_name() + "     "
						+ soa.getAdmin_domain() + "(" + "\n";
			}

			if (Integer.toString(soa.getSerial()) != null
					&& !Integer.toString(soa.getSerial()).equals("")) {
				command = command + "           " + soa.getSerial() + "; "
						+ "Serial" + "\n";
			}

			if (Integer.toString(soa.getRefresh()) != null
					&& !Integer.toString(soa.getRefresh()).equals("")) {
				command = command + "           " + soa.getRefresh() + "; "
						+ "Refresh" + "\n";
			}

			if (Integer.toString(soa.getRetry()) != null
					&& !Integer.toString(soa.getRetry()).equals("")) {
				command = command + "           " + soa.getRetry() + "; "
						+ "Retry" + "\n";
			}

			if (Integer.toString(soa.getExpire()) != null
					&& !Integer.toString(soa.getExpire()).equals("")) {
				command = command + "           " + soa.getExpire() + "; "
						+ "Expire " + "\n";
			}

			if (Integer.toString(soa.getMin_ttl()) != null
					&& !Integer.toString(soa.getMin_ttl()).equals("")) {
				command = command + "           " + soa.getMin_ttl()
						+ ")      " + "; " + "Negative Cache TTL " + "\n" + ";"
						+ "\n";
			}

			for (Record record : soa.getRecord()) {
				if (record.getDomain_name() != null
						&& !record.getDomain_name().equals("")) {
					command = command + record.getDomain_name() + " " + "IN"
							+ " ";

				}

				if (record.getType_record() != null
						&& !record.getType_record().equals("")) {
					command = command + record.getType_record() + " ";

				}

				if (record.getPriority() != null
						&& !record.getPriority().equals("")) {
					command = command + record.getPriority() + " ";

				}

				if (record.getName_server() != null
						&& !record.getName_server().equals("")) {
					command = command + record.getName_server() + "\n";

				}

			}
			command = command + "\n\n";
			// upload tung path SOA rieng tai day
			// command = "echo -e > " + soa.getPathfile() + " " + command;
			// System.out.println("in di cu" + soa.getPathfile());
			command = "echo " + sv.getServerPassword()
					+ " | sudo -S bash -c ' echo -e " + "\"" + command + "\""
					+ "   > " + soa.getPathfile() + " '";
			Boolean boo = sendCommandToServer(sv, command);
			if (boo == true) {
				System.out.println("Uploaded SOA to " + "\""
						+ soa.getPathfile() + "\"" + " Success...OK");
				// khong duoc return true o day se gay ra van de brak vong lap
				// return true;
			} else {
				System.out.println("Upload SOA Failed !!!");
				// khong duoc return false o day se gay ra van de brak vong lap
				// return false;
			}

		}
		return null;

	}

	// upload String SOA to Server
	public Boolean uploadStringSOAToServer(Server sv, String text_soa, SOA soa) {

		// Thay the "\"" thanh .... de thuc thi co hieu luc, giup doan lenh nhan
		// biet duoc dau ".
		String tong = "echo " + sv.getServerPassword()
				+ " | sudo -S bash -c ' echo -e " + "\""
				+ text_soa.replace("\"", "\\\"\"") + "\"" + "   > "
				+ soa.getPathfile() + " '";

		System.out.println(".....Uploading to server.....");
		Boolean boo = sendCommandToServer(sv, tong);
		if (boo == true) {
			System.out.println("Uploaded String SOA ...OK");
			// return true;
		} else {
			System.out.println("Upload String SOA Failed!!!");

			// return false;
		}
		return boo;

	}

	public static void main(String[] args) throws IOException {

		Bind9Config bind_c = new Bind9Config();
		Server sv = new Server("192.168.0.116", 22, "mayb", "mayb", "mayb");
		// Nen khoi tao dns 1 lan va su dung nhieu lan
		//Dns dns = bind_c.convertXMLToObjectDNS(sv);
		// System.out.println(bind_c.checkRunning(sv));
		// System.out.println(bind_c.loadConfigZoneToPlainText(sv));
		// System.out.println(bind_c.convertZoneToXML(sv));
		// System.out.println(bind_c.loadFileZoneToPlainText(sv));
		// bind_c.loadSOAToPlainText(sv);
		// Loi soa do co zone nhung chua co file
		// System.out.print(bind_c.convertSOAToXML(sv));
		// System.out.println(bind_c.loadACLToPlainText(sv));
		// System.out.println(bind_c.convertACLToXML(sv));
		// System.out.println(bind_c.loadOptionsToPlainText(sv));
		// System.out.println(bind_c.convertOptionsToXML(sv));
		// System.out.println("------------------------------------\n"
		// + bind_c.convertConfigToDNSXml(sv));
		// bind_c.convertXMLToObjectDNS(sv);
		// ----------------------
//		bind_c.uploadZoneToServer(sv, dns.getZone(), null);
//		bind_c.uploadACLToServer(sv, dns.getAcl(), null);
//		bind_c.uploadOptionToServer(sv, dns.getOption());
//		bind_c.uploadSOAToServer(sv, dns.getSoa());
		// -----------------
		// bind_c.loadPathFileZoneToPlainText(sv);
		// Tao zone moi-------------
		// Zone newZone = new Zone("thienkimhoangcung.com", "master",
		// "/var/lib/bind/thienkimhoangcung.com.hosts", null, null);
		// bind_c.createZone(sv, newZone);
		// --------------------------------
		// Them option
		// Option option = new Option("/var/cache/bind", "yes", "yes", "only",
		// "192.168.0.104;10.0.0.5;172.16.108.25;", "10.0.0.56;",
		// "192.168.100.156;", "192.168.105.220;", "172.16.56.23;");
		//
		// bind_c.uploadOptionToServer(sv, option);
		// -------------------------------
		// Tao ACl
		// List<String> multi_list = new ArrayList<String>();
		// multi_list.add("192.168.0.104");
		// Accesslist acl = new Accesslist("group30", multi_list);
		// bind_c.createACL(sv, acl);
		// -----------------------
		// Xoa zone
		// bind_c.uploadZoneToServer(sv, dns.getZone(), "thienkim3.com");
		// // System.out.println(bind_c.loadSOAToPlainText(sv));
		// bind_c.uploadACLToServer(sv, dns.getAcl(), "group30");
		// bind_c.uploadStringZoneToServer(sv, bind_c.loadZoneToPlainText(sv));
		// bind_c.uploadStringACLToServer(sv, bind_c.loadACLToPlainText(sv));
		// System.out.println(bind_c.convertZoneToXML(sv));
		// bind_c.uploadStringOptionToServer(sv,
		// bind_c.loadOptionsToPlainText(sv));

		// bind_c.createLoggingFile(sv);
//		 System.out.println(bind_c.getLog(sv));
		 System.out.println(bind_c.getError(sv));

		/**
		 * Kich ban xem log: 1/Cai dat Bind9 2/createLoggingFile(Server sv)
		 * 3/Tao zone, tao SOA, chinh sua SOA 4/uploadZone 5/ghi log
		 */
	}
}
