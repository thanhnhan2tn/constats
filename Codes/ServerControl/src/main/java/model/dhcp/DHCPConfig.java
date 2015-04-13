package model.dhcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class DHCPConfig {
	// Phuc vu cho start/stop/restart
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

	// Start
	public Boolean Start(Server sv) {
		String command = "sudo service isc-dhcp-server start";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Stop
	public Boolean Stop(Server sv) {
		String command = "sudo service isc-dhcp-server stop";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Restart
	public Boolean Restart(Server sv) {
		String command = "sudo service isc-dhcp-server restart";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			return true;
		} else {

			return false;
		}
	}

	// State
	public Boolean getState(Server sv) {
		String command = "sudo service isc-dhcp-server status";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Install
	public Boolean Install(Server sv) {
		String command = "sudo apt-get -y install isc-dhcp-server";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {

			return true;
		} else {

			return false;
		}
	}

	// Remove Service
	public Boolean Remove(Server sv) {
		String command = "sudo apt-get -y --purge remove isc-dhcp-server";
		Boolean boo = sendCommandToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Upload cmd / file to server phuc vu cho viec loadConfigToPlainText va
	// uploadCOnfigToServer
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
					System.out.println("exit-status: " + channel.getExitStatus());
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

	// Xoa tat ca dong trong
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
				if (line.indexOf("#") != -1) {
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

	// Load Config to Plaintext

	public String loadConfigToPlainText(Server sv) throws IOException {
		String kq = uploadToServer(sv, "cat /etc/dhcp/dhcpd.conf");
		kq = chuanhoaChuoi1(kq);
		kq = chuanhoaChuoi2(kq);
		kq = chuanhoaChuoi3(kq);
		return kq;
	}

	// load config chung ngoai tru subnet ra
	public String loadConfigChungToPlainText(Server sv) throws IOException {
		String kq = uploadToServer(sv, "cat /etc/dhcp/dhcpd.conf");
		kq = chuanhoaChuoi1(kq);
		kq = chuanhoaChuoi2(kq);
		kq = chuanhoaChuoi3(kq);
		// regex dac biet
		String regex = "subnet [.\\d]+ netmask [.\\d]+\n\\{\n[\\w+;\n-.]+\n\\}";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher(kq);
		while (matcher.find()) {

			// System.out.println(matcher.group());
			kq = kq.replace(matcher.group(), "");
		}
		return kq;

	}

	// convert text to Object Chung
	public ConfigChung convertTextToConfigChung(Server sv) throws IOException {
		HashMap<String, String> hm1 = new HashMap<String, String>();
		// Chuoi da dc chuan hoa san
		String chuoi = loadConfigToPlainText(sv);

		// System.out.println("In ra Chuoi da chuan hoa: \n" + chuoi);
		StringReader str = new StringReader(chuoi);
		BufferedReader br = new BufferedReader(str);
		String line = "";

		while ((line = br.readLine()) != null) {
			if (line.indexOf("ddns-update-style") != -1 || line.indexOf("log-facility") != -1

			) {
				hm1.put(line.substring(0, line.indexOf(" ")).trim(), line.substring(line.indexOf(" ") + 1).trim());
			}
			if (line.indexOf("authoritative") != -1) {
				hm1.put("authoritative", ";");
			}

		}
		// ---------------
		// Chuoi da dc chuan hoa san
		String chuoi2 = loadConfigChungToPlainText(sv);

		// System.out.println("In ra Chuoi da chuan hoa: \n" + chuoi);
		StringReader str2 = new StringReader(chuoi2);
		BufferedReader br2 = new BufferedReader(str2);
		String line2 = "";

		while ((line2 = br2.readLine()) != null) {
			if (line2.indexOf("domain-name") != -1 || line2.indexOf("domain-name-servers") != -1
					|| line2.indexOf("default-lease-time") != -1 || line2.indexOf("max-lease-time") != -1) {
				hm1.put(line2.substring(0, line2.indexOf(" ")).trim(), line2.substring(line2.indexOf(" ") + 1).trim());
			}

		}
		ConfigChung cfg = new ConfigChung(hm1.get("ddns-update-style"), hm1.get("authoritative"),
				hm1.get("log-facility"), hm1.get("domain-name"), hm1.get("domain-name-servers"),
				hm1.get("default-lease-time"), hm1.get("max-lease-time"));

		return cfg;
	}

	// convert text to Object Subnet
	public List<Subnet> convertTextToListSubnet(Server sv) throws IOException {

		HashMap<String, String> hm1 = new HashMap<String, String>();
		List<Subnet> subnet_multi = new ArrayList<Subnet>();
		// Chuoi da dc chuan hoa san
		String chuoi = loadConfigToPlainText(sv);

		// System.out.println("In ra Chuoi da chuan hoa: \n" + chuoi);
		StringReader str = new StringReader(chuoi);
		BufferedReader br = new BufferedReader(str);
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				if (line.indexOf("range") != -1 || line.indexOf("routers") != -1
						|| line.indexOf("domain-name-servers") != -1 || line.indexOf("domain-name") != -1
						|| line.indexOf("broadcast-address") != -1 || line.indexOf("default-lease-time") != -1
						|| line.indexOf("max-lease-time") != -1

				) {
					// Lay luon dau ";"
					hm1.put(line.substring(0, line.indexOf(" ")).trim(), line.substring(line.indexOf(" ") + 1).trim());
				}

				if (line.indexOf("subnet") != -1) {
					hm1.put("subnet", line.substring(line.indexOf(" ") + 1, line.indexOf("netmask") - 1).trim());
				}

				if (line.indexOf("netmask") != -1) {
					hm1.put("netmask", line.substring(line.lastIndexOf(" ") + 1).trim());
				}

				if (line.indexOf("}") != -1) {
					Subnet sn = new Subnet(hm1.get("subnet"), hm1.get("netmask"), hm1.get("range"),
							hm1.get("domain-name-servers"), hm1.get("domain-name"), hm1.get("routers"),
							hm1.get("broadcast-address"), hm1.get("default-lease-time"), hm1.get("max-lease-time"));
					// tao them 1 dk if o day add cac sn khac rong la xong,
					// khong can su dung ham xoa Null Element trong List nua
					if (sn.getSubnet() != null && !sn.getSubnet().equals("")) {
						subnet_multi.add(sn);
					}
					hm1.put("subnet", null);
					hm1.put("netmask", null);
					hm1.put("range", null);
					hm1.put("domain-name-servers", null);
					hm1.put("domain-name", null);
					hm1.put("routers", null);
					hm1.put("broadcast-address", null);
					hm1.put("default-lease-time", null);
					hm1.put("max-lease-time", null);

				}

			}
			return subnet_multi;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public DHCP convertConfigToObjectDHCP(Server sv) throws IOException {
		DHCP dhcp = new DHCP(convertTextToConfigChung(sv), convertTextToListSubnet(sv), convertTextToListHost(sv));
		return dhcp;
	}

	// Upload Subnet Config to Server Them/Sua/Xoa, co the truyen vao 1 DHCP
	// hoac tung thanh phan con cua no
	public String uploadConfigToDHCPServer(Server sv, List<Subnet> list_sn, List<HostFixIP> list_host, ConfigChung cfg)
			throws IOException {

		// List<Subnet> list_sn = new ArrayList<Subnet>();
		// list_sn = convertTextToListSubnet(sv);
		// List<HostFixIP> list_host = new ArrayList<HostFixIP>();
		// list_host = convertTextToListHost(sv);
		// ConfigChung cfg = convertTextToConfigChung(sv);

		String config = "";
		String config2 = "";
		String config3 = "";

		for (Subnet sn : list_sn) {
			if (sn.getSubnet() != null && !sn.getSubnet().equals("")) {
				config = config + "subnet " + sn.getSubnet().trim();

			}
			if (sn.getNetmask() != null && !sn.getNetmask().equals("")) {

				config = config + " netmask " + sn.getNetmask().trim() + "'\n'";
			}

			config = config + "{" + "'\n'";
			if (sn.getRange() != null && !sn.getRange().equals("")) {

				config = config + "range " + "'" + sn.getRange().trim() + "'" + "'\n'";
			}
			if (sn.getRouter_gateway() != null && !sn.getRouter_gateway().equals("")) {

				config = config + "option routers " + "'" + sn.getRouter_gateway().trim() + "'" + "'\n'";
			}
			if (sn.getDomain_name_server() != null && !sn.getDomain_name_server().equals("")) {

				config = config + "option domain-name-servers " + "'" + sn.getDomain_name_server().trim() + "'"
						+ "'\n'";
			}
			if (sn.getDomain_name() != null && !sn.getDomain_name().equals("")) {

				config = config + "option domain-name " + "'" + sn.getDomain_name().trim() + "'" + "'\n'";
			}
			if (sn.getBroadcast_address() != null && !sn.getBroadcast_address().equals("")) {

				config = config + "option broadcast-address " + "'" + sn.getBroadcast_address().trim() + "'" + "'\n'";
			}
			if (sn.getDefault_lease_time() != null && !sn.getDefault_lease_time().equals("")) {

				config = config + "default-lease-time " + "'" + sn.getDefault_lease_time().trim() + "'" + "'\n'";
			}
			if (sn.getMax_lease_time() != null && !sn.getMax_lease_time().equals("")) {

				config = config + "max-lease-time " + "'" + sn.getMax_lease_time().trim() + "'" + "'\n'";
			}
			config = config + "}" + "'\n'";

		}

		for (HostFixIP host : list_host) {
			if (host.getHostname() != null && !host.getHostname().equals("")) {
				config2 = config2 + "host " + host.getHostname() + "'\n'";
			}
			config2 = config2 + "{" + "'\n'";
			if (host.getHardware_internet() != null && !host.getHardware_internet().equals("")) {
				config2 = config2 + "hardware ethernet " + "'" + host.getHardware_internet() + "'" + "'\n'";
			}

			if (host.getFilename() != null && !host.getFilename().equals("")) {
				config2 = config2 + "filename " + "'" + host.getFilename() + "'" + "'\n'";
			}

			if (host.getServername() != null && !host.getServername().equals("")) {
				config2 = config2 + "server-name " + "'" + host.getServername() + "'" + "'\n'";
			}

			if (host.getFixed_address() != null && !host.getFixed_address().equals("")) {
				config2 = config2 + "fixed-address " + "'" + host.getFixed_address() + "'" + "'\n'";
			}
			config2 = config2 + "}" + "'\n'";

		}
		if (cfg.getDns_update_style() != null && !cfg.getDns_update_style().equals("")) {
			config3 = config3 + "ddns-update-style " + "'" + cfg.getDns_update_style() + "'" + "'\n'";
		}

		if (cfg.getAuthorative() != null && !cfg.getAuthorative().equals("")) {
			config3 = config3 + "authoritative" + "'" + cfg.getAuthorative() + "'" + "'\n'";
		}

		if (cfg.getLog_facitily() != null && !cfg.getLog_facitily().equals("")) {
			config3 = config3 + "log-facility " + "'" + cfg.getLog_facitily() + "'" + "'\n'";
		}

		if (cfg.getDomain_name() != null && !cfg.getDomain_name().equals("")) {
			config3 = config3 + "option domain-name " + "'" + cfg.getDomain_name() + "'" + "'\n'";
		}

		if (cfg.getDomain_name_servers() != null && !cfg.getDomain_name_servers().equals("")) {
			config3 = config3 + "option domain-name-servers " + "'" + cfg.getDomain_name_servers() + "'" + "'\n'";
		}

		if (cfg.getDefault_lease_time() != null && !cfg.getDefault_lease_time().equals("")) {

			config3 = config3 + "default-lease-time " + "'" + cfg.getDefault_lease_time().trim() + "'" + "'\n'";
		}
		if (cfg.getMax_lease_time() != null && !cfg.getMax_lease_time().equals("")) {

			config3 = config3 + "max-lease-time " + "'" + cfg.getMax_lease_time().trim() + "'" + "'\n'";
		}

		String tong = "echo -e > /etc/dhcp/dhcpd.conf " + config3 + "'\n'" + config + "'\n'" + config2 + "'\n'";
		// System.out.println(config3 + config + config2);

		System.out.println(".....Uploading to server.....");
		uploadToServer(sv, tong);
		return config3 + config + config2;
	}

	// Xoa subnet, host
	// public String XoaSubnetorHost(Server sv, String subnet, String hostFixed)
	// throws IOException {
	//
	// List<Subnet> list_sn = new ArrayList<Subnet>();
	// list_sn = convertTextToListSubnet(sv);
	// List<HostFixIP> list_host = new ArrayList<HostFixIP>();
	// list_host = convertTextToListHost(sv);
	//
	// String config = "";
	// String config2 = "";
	// String config3 = "";
	//
	// for (Subnet sn : list_sn) {
	// if (sn.getSubnet().equals(subnet)) {
	// continue;
	// }
	// if (sn.getSubnet() != null && !sn.getSubnet().equals("")) {
	// config = config + "subnet " + sn.getSubnet().trim();
	//
	// }
	// if (sn.getNetmask() != null && !sn.getNetmask().equals("")) {
	//
	// config = config + " netmask " + sn.getNetmask().trim() + "'\n'";
	// }
	//
	// config = config + "{" + "'\n'";
	// if (sn.getRange() != null && !sn.getRange().equals("")) {
	//
	// config = config + "range " + "'" + sn.getRange().trim() + "'"
	// + "'\n'";
	// }
	// if (sn.getRouter_gateway() != null
	// && !sn.getRouter_gateway().equals("")) {
	//
	// config = config + "option routers " + "'"
	// + sn.getRouter_gateway().trim() + "'" + "'\n'";
	// }
	// if (sn.getDomain_name_server() != null
	// && !sn.getDomain_name_server().equals("")) {
	//
	// config = config + "option domain-name-servers " + "'"
	// + sn.getDomain_name_server().trim() + "'" + "'\n'";
	// }
	// if (sn.getDomain_name() != null && !sn.getDomain_name().equals("")) {
	//
	// config = config + "option domain-name " + "'"
	// + sn.getDomain_name().trim() + "'" + "'\n'";
	// }
	// if (sn.getBroadcast_address() != null
	// && !sn.getBroadcast_address().equals("")) {
	//
	// config = config + "option broadcast-address " + "'"
	// + sn.getBroadcast_address().trim() + "'" + "'\n'";
	// }
	// if (sn.getDefault_lease_time() != null
	// && !sn.getDefault_lease_time().equals("")) {
	//
	// config = config + "default-lease-time " + "'"
	// + sn.getDefault_lease_time().trim() + "'" + "'\n'";
	// }
	// if (sn.getMax_lease_time() != null
	// && !sn.getMax_lease_time().equals("")) {
	//
	// config = config + "max-lease-time " + "'"
	// + sn.getMax_lease_time().trim() + "'" + "'\n'";
	// }
	// config = config + "}" + "'\n'";
	//
	// }
	//
	// for (HostFixIP host : list_host) {
	// if (host.getHostname().equals(hostFixed)) {
	// continue;
	// }
	// if (host.getHostname() != null && !host.getHostname().equals("")) {
	// config2 = config2 + "host " + host.getHostname() + "'\n'";
	// }
	// config2 = config2 + "{" + "'\n'";
	// if (host.getHardware_internet() != null
	// && !host.getHardware_internet().equals("")) {
	// config2 = config2 + "hardware ethernet " + "'"
	// + host.getHardware_internet() + "'" + "'\n'";
	// }
	//
	// if (host.getFilename() != null && !host.getFilename().equals("")) {
	// config2 = config2 + "filename " + "'" + host.getFilename()
	// + "'" + "'\n'";
	// }
	//
	// if (host.getServername() != null
	// && !host.getServername().equals("")) {
	// config2 = config2 + "server-name " + "'" + host.getServername()
	// + "'" + "'\n'";
	// }
	//
	// if (host.getFixed_address() != null
	// && !host.getFixed_address().equals("")) {
	// config2 = config2 + "fixed-address " + "'"
	// + host.getFixed_address() + "'" + "'\n'";
	// }
	// config2 = config2 + "}" + "'\n'";
	//
	// }
	// ConfigChung cfg = convertTextToConfigChung(sv);
	// if (cfg.getDns_update_style() != null
	// && !cfg.getDns_update_style().equals("")) {
	// config3 = config3 + "ddns-update-style " + "'"
	// + cfg.getDns_update_style() + "'" + "'\n'";
	// }
	//
	// if (cfg.getAuthorative() != null && !cfg.getAuthorative().equals("")) {
	// config3 = config3 + "authoritative" + "'" + cfg.getAuthorative()
	// + "'" + "'\n'";
	// }
	//
	// if (cfg.getLog_facitily() != null && !cfg.getLog_facitily().equals("")) {
	// config3 = config3 + "log-facility " + "'" + cfg.getLog_facitily()
	// + "'" + "'\n'";
	// }
	//
	// String tong = "echo -e > /etc/dhcp/dhcpd.conf " + config3 + "'\n'"
	// + config + "'\n'" + config2 + "'\n'";
	// System.out.println(config3 + config + config2);
	//
	// System.out.println(".....Uploading to server.....");
	// uploadToServer(sv, tong);
	// return config3 + config + config2;
	// }

	// public List<Subnet> removeNullElementFromListSubnet(List<Subnet> sn) {
	//
	// for (Subnet subnet : new ArrayList<>(sn)) {
	// if (subnet.getSubnet() == null) {
	// sn.remove(subnet);
	// }
	// }
	// return sn;
	// }

	// public List<HostFixIP> removeNullElementFromListHost(
	// List<HostFixIP> host_list) {
	//
	// for (HostFixIP h : new ArrayList<>(host_list)) {
	// if (h.getHostname() == null) {
	// host_list.remove(h);
	// }
	// }
	// return host_list;
	// }

	// Ham in ra subnet return String
	public String inSubnet(Server sv) throws IOException {
		List<Subnet> list_sn = new ArrayList<Subnet>();
		list_sn = convertTextToListSubnet(sv);

		String inSubnet = "";

		for (Subnet sn : list_sn) {
			inSubnet = inSubnet + "subnet " + sn.getSubnet() + " netmask " + sn.getNetmask() + "\n{\n" + "range "
					+ sn.getRange() + "\n" + "option routers " + sn.getRouter_gateway() + "\n"
					+ "option domain-name-servers " + sn.getDomain_name_server() + "\n" + "option domain-name "
					+ sn.getDomain_name() + "\n" + "option broadcast-address " + sn.getBroadcast_address() + "\n"
					+ "default-lease-time " + sn.getDefault_lease_time() + "\n" + "max-lease-time "
					+ sn.getMax_lease_time() + "\n}" + "\n";

		}
		return removeNullCharater(inSubnet);

	}

	// Remove null character phuc vu cho ham in Subnet neu ko dung if-else
	public String removeNullCharater(String lay) throws IOException {

		String chuoilay = "";
		String line = "";
		StringReader str = new StringReader(lay);
		BufferedReader br = new BufferedReader(str);
		while ((line = br.readLine()) != null) {
			if (line.indexOf("null") != -1) {
				continue;
			}
			chuoilay = chuoilay + line + "\n";

		}
		return chuoilay;
	}

	public List<HostFixIP> convertTextToListHost(Server sv) throws IOException {

		HashMap<String, String> hm1 = new HashMap<String, String>();
		List<HostFixIP> host_multi = new ArrayList<HostFixIP>();
		// Chuoi da dc chuan hoa san
		String chuoi = loadConfigToPlainText(sv);

		// System.out.println("In ra Chuoi da chuan hoa: \n" + chuoi);
		StringReader str = new StringReader(chuoi);
		BufferedReader br = new BufferedReader(str);
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				if (line.indexOf("host") != -1 || line.indexOf("filename") != -1 || line.indexOf("server-name") != -1
						|| line.indexOf("fixed-address") != -1

				) {
					hm1.put(line.substring(0, line.indexOf(" ")).trim(), line.substring(line.indexOf(" ") + 1).trim());
				}

				if (line.indexOf("hardware ethernet") != -1) {

					hm1.put(line.substring(0, line.lastIndexOf(" ")).trim(), line.substring(line.lastIndexOf(" ") + 1)
							.trim());

				}

				if (line.indexOf("}") != -1) {
					HostFixIP host = new HostFixIP(hm1.get("host"), hm1.get("hardware ethernet"), hm1.get("filename"),
							hm1.get("server-name"), hm1.get("fixed-address"));

					// -------
					if (host.getHostname() != null && !host.getHostname().equals("")) {
						host_multi.add(host);
					}

					hm1.put("host", null);
					hm1.put("hardware ethernet", null);
					hm1.put("filename", null);
					hm1.put("server-name", null);
					hm1.put("fixed-address", null);

				}

			}
			return host_multi;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// --------in host
	public void inHost(Server sv) throws IOException {
		List<HostFixIP> multihost = convertTextToListHost(sv);
		for (HostFixIP h : multihost) {
			System.out.println("---------Create Host----------");
			if (h.getHostname() != null && !h.getHostname().equals("")) {
				System.out.println("host " + h.getHostname());
			}
			System.out.println("{");

			if (h.getHardware_internet() != null && !h.getHardware_internet().equals("")) {

				System.out.println("hardware ethernet " + h.getHardware_internet());
			}
			if (h.getFilename() != null && !h.getFilename().equals("")) {

				System.out.println("filename " + h.getFilename());
			}
			if (h.getServername() != null && !h.getServername().equals("")) {

				System.out.println("server-name " + h.getServername());
			}
			if (h.getFixed_address() != null && !h.getFixed_address().equals("")) {

				System.out.println("fixed-address " + h.getFixed_address());

			}
			System.out.println("}");

			System.out.println("---------------------");

		}
	}

	// Them vao 1 config
	public String inConfigChung(Server sv) throws IOException {
		ConfigChung config_c = convertTextToConfigChung(sv);

		String kq = "";
		kq = kq + "ddns-update-style " + config_c.getDns_update_style() + "\n" + "authoritative"
				+ config_c.getAuthorative() + "\n" + "log-facility " + config_c.getLog_facitily() + "\n"
				+ "domain-name " + config_c.getDomain_name() + "\n" + "domain-name-servers "
				+ config_c.getDomain_name_servers() + "\n" + "default-lease-time " + config_c.getDefault_lease_time()
				+ "\n" + "max-lease-time " + config_c.getMax_lease_time() + "\n";
		return removeNullCharater(kq);
	}

	// Them vao 1 subnet
	// public String addSubnet(Server sv, Subnet sn) {
	//
	// String config = "";
	// if (sn.getSubnet() != null && !sn.getSubnet().equals("")) {
	// config = config + "subnet " + sn.getSubnet().trim();
	//
	// }
	// if (sn.getNetmask() != null && !sn.getNetmask().equals("")) {
	//
	// config = config + " netmask " + sn.getNetmask().trim() + "'\n'";
	// }
	//
	// config = config + "{" + "'\n'";
	// if (sn.getRange() != null && !sn.getRange().equals("")) {
	//
	// config = config + "range " + "'" + sn.getRange().trim() + ";" + "'"
	// + "'\n'";
	// }
	// if (sn.getRouter_gateway() != null
	// && !sn.getRouter_gateway().equals("")) {
	//
	// config = config + "option routers " + "'"
	// + sn.getRouter_gateway().trim() + ";" + "'" + "'\n'";
	// }
	// if (sn.getDomain_name_server() != null
	// && !sn.getDomain_name_server().equals("")) {
	//
	// config = config + "option domain-name-servers " + "'"
	// + sn.getDomain_name_server().trim() + ";" + "'" + "'\n'";
	// }
	// if (sn.getDomain_name() != null && !sn.getDomain_name().equals("")) {
	//
	// config = config + "option domain-name " + "'" + "\""
	// + sn.getDomain_name().trim() + "\"" + ";" + "'" + "'\n'";
	// }
	// if (sn.getBroadcast_address() != null
	// && !sn.getBroadcast_address().equals("")) {
	//
	// config = config + "option broadcast-address " + "'"
	// + sn.getBroadcast_address().trim() + ";" + "'" + "'\n'";
	// }
	// if (sn.getDefault_lease_time() != null
	// && !sn.getDefault_lease_time().equals("")) {
	//
	// config = config + "default-lease-time " + "'"
	// + sn.getDefault_lease_time().trim() + ";" + "'" + "'\n'";
	// }
	// if (sn.getMax_lease_time() != null
	// && !sn.getMax_lease_time().equals("")) {
	//
	// config = config + "max-lease-time " + "'"
	// + sn.getMax_lease_time().trim() + ";" + "'" + "'\n'";
	// }
	// config = config + "}" + "'\n'";
	// config = "echo >> /etc/dhcp/dhcpd.conf " + config;
	// uploadToServer(sv, config);
	// return config;
	// }

	// Add Host fixed IP
	// public String addHost(Server sv, HostFixIP host) {
	// String config2 = "";
	// if (host.getHostname() != null && !host.getHostname().equals("")) {
	// config2 = config2 + "host " + host.getHostname() + "'\n'";
	// }
	// config2 = config2 + "{" + "'\n'";
	// if (host.getHardware_internet() != null
	// && !host.getHardware_internet().equals("")) {
	// config2 = config2 + "hardware ethernet " + "'"
	// + host.getHardware_internet() + ";" + "'" + "'\n'";
	// }
	// // Luu y nhung ky tu dac biet se dan den viec ko chay ham, in ko ra,
	// // hoac in loi
	// if (host.getFilename() != null && !host.getFilename().equals("")) {
	// config2 = config2 + "filename " + "'" + "\"" + host.getFilename()
	// + "\"" + ";" + "'" + "'\n'";
	// }
	//
	// if (host.getServername() != null && !host.getServername().equals("")) {
	// config2 = config2 + "server-name " + "'" + "\""
	// + host.getServername() + "\"" + ";" + "'" + "'\n'";
	// }
	//
	// if (host.getFixed_address() != null
	// && !host.getFixed_address().equals("")) {
	// config2 = config2 + "fixed-address " + "'"
	// + host.getFixed_address() + ";" + "'" + "'\n'";
	// }
	// config2 = config2 + "}" + "'\n'";
	// config2 = "echo >> /etc/dhcp/dhcpd.conf " + config2;
	// uploadToServer(sv, config2);
	// return config2;
	//
	// }

	// Convert mot so Object to XML

	// Convert mot so XML to Object

}
