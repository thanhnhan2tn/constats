package vn.edu.cit.servercontrol.nic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

	public Boolean Start() {
		String command = "sudo /etc/init.d/network start";
		Boolean boo;
		// Goi ham get Session
		// Gui chuoi qua server
		/*
		 * if (//Gui chuoi thanh cong){ return true; } else { return false; }
		 */
		return null;
	}

	public Boolean Stop() {
		return true;
	}

	public Boolean Restart() {
		return true;
	}

	public Boolean Install() {
		return true;
	}

	public Boolean Remove() {
		return true;
	}

	// upload Config to Server
	public boolean uploadConfigToServer() {

		return true;
	}

	// load file config tu server luu vao local
	public String loadConfigToLocal(Server sv) {

		Session ss = sv.getSession(sv);
		String chuoilay = "";
		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(" cat /etc/network/interfaces");
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
							"src\\nic_config.txt"));
					f.write(chuoilay.getBytes(), 0, chuoilay.length());
					// f.write("\n".getBytes());
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

	// load file config tu server luu vao local
	public String loadConfigToString2(Server sv) {

		Session ss = sv.getSession(sv);
		String chuoilay = "";
		try {
			// option -e giup nhan dang ki tu xuong dong
			Channel channel = ss.openChannel("exec");
			((ChannelExec) channel).setCommand(" cat /etc/network/interfaces");
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
					// FileOutputStream f = new FileOutputStream(new File(
					// "src\\nic_config.txt"));
					// f.write(chuoilay.getBytes(), 0, chuoilay.length());
					// // f.write("\n".getBytes());
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

	// Loaf file - lay chuoi
	public String loadConfigToString() {
		try {

			File file = new File("src\\nic_config.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();

				while (line.indexOf("#") != -1) {
					line = "";
					line = line.trim();
					line = line.replaceAll("\\s+", null);
					chuoilay = chuoilay + line;

				}
				chuoilay = chuoilay + line + "\n";

			}
			fileReader.close();

			return chuoilay;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	public String convertTextToXMl(Server sv) {

		HashMap<String, String> hm1 = new HashMap<String, String>();

		String[] mang = loadConfigToString2(sv).split("\\s+");
		System.out.println(mang);
		String lay = "";
		try {
			int i = 0;
			while (!mang[i].equals(null)) {
				// System.out.println("Vong lap thu " + i);
				System.out.println(mang[i]);
				if (mang[i].equals("iface") || mang[i].equals("address")
						|| mang[i].equals("inet") || mang[i].equals("netmask")
						|| mang[i].equals("gateway")
						|| mang[i].equals("network")
						|| mang[i].equals("broadcast")) {

					hm1.put(mang[i], mang[i + 1]);
					if (mang[i].equals("iface") && i != 0
							&& i != mang.length - 1) {
						lay = lay + "\n</eth>\n<eth>\n" + "<" + mang[i] + ">"
								+ mang[i + 1] + "</" + mang[i] + ">" + "\n";
					} else {
						lay = lay + "<" + mang[i] + ">" + mang[i + 1] + "</"
								+ mang[i] + ">" + "\n";
					}

				}

				if (mang[i].equals("dns-nameservers")) {
					lay = lay + "<dns_nameservers>" + mang[i + 1]
							+ "</dns_nameservers>" + "\n";
				}

				i++;

			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		} catch (NullPointerException nu) {
		}
		return "<nic>" + "\n" + "<eth>\n" + lay + "\n" + "</eth>\n" + "</nic>";
	}

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

	public Eth getEthFromAdd(String index, Server sv) throws IOException {
		Nic nic = convertXMLToObject(sv);
		System.out.println("------Khoi tao doi tuong, in ra man hinh-------");
		for (Eth eth : nic.getEth()) {
			if (eth.getAddress().equals(index)) {

				System.out.println(eth.getIface());
				System.out.println(eth.getInet());
				System.out.println(eth.getAddress());
				System.out.println(eth.getNetmask());
				System.out.println(eth.getGateway());
				System.out.println(eth.getNetwork());
				System.out.println(eth.getBroadcast());
				System.out.println(eth.getDns_nameservers());

				System.out.println("---------------");

				return eth;

			}

		}
		return null;
	}

	public static void main(String[] args) throws IOException {

		// // Eth eth1 = getEthFromAdd("192.168.0.102");
		// // System.out.println("In ra : " + eth1.getAddress());
		// NicConfig nic_c = new NicConfig();
		// Server sv = new Server(1, "192.168.1.109", 22, "mayb", "root",
		// "root");
		//
		// nic_c.loadConfigToLocal(sv);
		//
		// // System.out.println(nic_c.loadConfigToString());
		// System.out.println(nic_c.convertTextToXMl());
		// Nic n = nic_c.convertXMLToObject();
		// for (Eth eth : n.getEth()) {
		// System.out.println(eth.getIface());
		// System.out.println(eth.getInet());
		// System.out.println(eth.getAddress());
		// System.out.println(eth.getNetmask());
		// System.out.println(eth.getGateway());
		// System.out.println(eth.getNetwork());
		// System.out.println(eth.getBroadcast());
		// System.out.println(eth.getDns_nameservers());
		// System.out.println("-----------------");
		//
		// }

		// Eth eth1 = nic_c.getEthFromAdd("192.168.0.102");

		// Eth eth1 = getEthFromAdd("172.16.0.140");
		// Eth eth2 = getEthFromAdd("192.168.0.102");

	}
}
