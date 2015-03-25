package vn.edu.cit.servercontrol.nic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import vn.edu.cit.model.Server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class NicConfig {

	// Upload cmd / file to server
	public boolean uploadToServer(Server sv, String cmd) {
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
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Start
	public Boolean Start(Server sv) {
		String command = "sudo /etc/init.d/networking start";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Stop
	public Boolean Stop(Server sv) {
		String command = "sudo /etc/init.d/networking stop";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Restart
	public Boolean Restart(Server sv) {
		String command = "sudo /etc/init.d/networking restart";
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Ifdown Eth
	public Boolean DownCard(Server sv, String iface) {
		String command = "sudo ifdown " + iface;
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// ifup Eth
	public Boolean UpCard(Server sv, String iface) {
		String command = "sudo ifup " + iface;
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// Ifdown and Ifup
	public Boolean RestartCard(Server sv, String iface) {
		String command = "sudo ifdown && ifup " + iface;
		Boolean boo = uploadToServer(sv, command);
		if (boo == true) {
			return true;
		} else {
			return false;
		}
	}

	// upload Config to Server
	public boolean uploadConfigToServer(Server sv, Nic n) throws IOException {
		String config = "";
		for (Eth eth : n.getEth()) {

				System.out.println("a:"+ eth.getAddress());
				System.out.println("b:"+eth.getBroadcast());
			


			config = config + "auto " + eth.getIface() + "'\n'" + "iface "
					+ eth.getIface() + " " + "inet " + eth.getInet() + "'\n'"
					+ "address " + eth.getAddress() + "'\n'" + "netmask "
					+ eth.getNetmask() + "'\n'" + "gateway " + eth.getGateway()
					+ "'\n'" + "network " + eth.getNetwork() + "'\n'"
					+ "broadcast " + eth.getBroadcast() + "'\n'" + "'\n'";

		}
		for (String dns : n.getDns_nameservers()) {
			config = config + "dns-nameservers " + dns + "'\n'";
		}
		// thuc hien xoa dong chua ki tu "null"
		config = XoaNull(config);
		config = "sudo echo -e > /home/mayb/nic.txt " + config;
		if (uploadToServer(sv, config) == true) {
			System.out.println("Upload Success!!");
			return true;
		} else {
			System.out.println("Uploaded Failed!!");
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
			System.out.println("Xoa null");
			line = line.trim();
			if (line.endsWith(" ")){
				line = "";
			}
			if (line.indexOf("null") != -1) {
				line = "";
			} else {
				kq = kq + line + "\n";
			}
		}
		return kq;
	}

	// load file config tu server thanh plaintext
	public String loadConfigToPlainText(Server sv) {

		Session ss = sv.getSession(sv);
		String chuoilay = "";

		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(" cat /etc/network/interfaces");
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

	// Chuan hoa PlainText tra ve Chuoi
	public String ChuanHoaChuoi(Server sv) {
		try {

			StringReader str = new StringReader(loadConfigToPlainText(sv));
			BufferedReader bufferedReader = new BufferedReader(str);
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();

				// Cat bo line chua "#" dau dong
				if (line.indexOf("#") != -1) {
					line = "";
					line = line.trim();
					line = line.replaceAll("\\s+", null);
					chuoilay = chuoilay + line;

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

	// convert Chuoi da Chuan Hoa sang XML String
	public String convertTextToXMl(Server sv) {

		HashMap<String, String> hm1 = new HashMap<String, String>();

		String[] mang = ChuanHoaChuoi(sv).split("\\s+");
		// System.out.println(Arrays.asList(mang));
		String lay = "";
		String lay_dns = "";
		try {
			int i = 0;
			while (!mang[i].equals(null)) {
				// System.out.println("Vong lap thu " + i);

				if (mang[i].equals("iface") || mang[i].equals("address")
						|| mang[i].equals("inet") || mang[i].equals("netmask")
						|| mang[i].equals("gateway")
						|| mang[i].equals("network")
						|| mang[i].equals("broadcast")) {

					hm1.put(mang[i], mang[i + 1]);

					if (mang[i].equals("iface") && i != 2) {
						lay = lay + "\n</eth>\n<eth>\n" + "<" + mang[i] + ">"
								+ mang[i + 1] + "</" + mang[i] + ">" + "\n";
					}

					else {
						lay = lay + "<" + mang[i] + ">" + mang[i + 1] + "</"
								+ mang[i] + ">" + "\n";
					}

				}

				if (mang[i].equals("dns-nameservers")) {
					lay_dns = lay_dns + "<dns_nameservers>" + mang[i + 1]
							+ "</dns_nameservers>" + "\n";
				}

				i++;

			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		} catch (NullPointerException nu) {
		}
		return "<nic>" + "\n" + "<eth>\n" + lay + "\n" + "</eth>\n" + lay_dns
				+ "</nic>";// String
	}

	// convert XML to Object
	public Nic convertXMLToObject(Server sv) throws IOException {
		StringReader strRead = new StringReader(convertTextToXMl(sv));

		try {
			// Khoi tao Context
			JAXBContext context = JAXBContext.newInstance(Nic.class);
			// Tao Unmarshaller tu Context
			Unmarshaller un = context.createUnmarshaller();
			// File xml phu thuoc vao doi tuong + duong duong path
			Nic nic = (Nic) un.unmarshal(strRead);

			return nic;

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (NullPointerException nu) {
		}
		return null;
	}

	public Eth getEthFromAdd(String index, Server sv) throws IOException,
			IndexOutOfBoundsException {
		Nic nic = convertXMLToObject(sv);
		System.out.println("------Khoi tao doi tuong, in ra man hinh-------");
		for (Eth eth : nic.getEth()) {
			if (eth.getAddress().equals(index)) {

				System.out.println("iface : " + eth.getIface());
				System.out.println("inet" + eth.getInet());
				System.out.println("address:" + eth.getAddress());
				System.out.println("netmask:" + eth.getNetmask());
				System.out.println("gateway:" + eth.getGateway());
				System.out.println("network:" + eth.getNetwork());
				System.out.println("broadcast:" + eth.getBroadcast());

				System.out.println("---------------");

				return eth;

			}

		}
		return null;
	}

	public static void main(String[] args) throws IOException {

//		NicConfig nic_c = new NicConfig();
//		Server sv = new Server(1, "192.168.1.149", 22, "mayb", "root", "root");
//		// Server sv = new Server(1, "", 22, "mayb", "root", "root");
//
//		// System.out.println(nic_c.convertTextToXMl(sv));
//
//		Nic n = nic_c.convertXMLToObject(sv);
//		System.out.println("----------Create Object---------");
//
//		for (Eth eth : n.getEth()) {
//			System.out.println("auto  " + eth.getIface());
//			System.out.println("iface  " + eth.getIface());
//			System.out.println("inet " + eth.getInet());
//			System.out.println("address " + eth.getAddress());
//			System.out.println("netmask " + eth.getNetmask());
//			System.out.println("gateway " + eth.getGateway());
//			System.out.println("network " + eth.getNetwork());
//			System.out.println("broadcast " + eth.getBroadcast());
//			System.out.println("-----------------");
//
//		}
//		System.out.println("Dns-nameservers " + n.getDns_nameservers());
//
//		 nic_c.uploadConfigToServer(sv, n);

	}
}
