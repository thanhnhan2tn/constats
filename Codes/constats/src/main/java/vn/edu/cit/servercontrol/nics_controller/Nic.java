package vn.edu.cit.servercontrol.nics_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nic")
@XmlType(propOrder = { "id", "type", "address", "netmask", "gateway",
		"network", "broadcast", "ip_tenmien" })
public class Nic {
	String id;
	String type;
	String address;
	String netmask;
	String gateway;
	String network;
	String broadcast;
	String[] ip_tenmien;

	public Nic(String id, String type, String address, String netmask,
			String gateway, String network, String broadcast,
			String[] ip_tenmien) {
		super();
		this.id = id;
		this.type = type;
		this.address = address;
		this.netmask = netmask;
		this.gateway = gateway;
		this.network = network;
		this.broadcast = broadcast;
		this.ip_tenmien = ip_tenmien;
	}

	public Nic() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Nhung phan tu thuoc con neu la Attribute can phai khai bao Anotation ro
	// rang
	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	@XmlElement
	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	@XmlElement
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@XmlElement
	public String getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}

	@XmlElement
	public String[] getIp_tenmien() {
		return this.ip_tenmien;
	}

	public void setIp_tenmien(String[] ip_tenmien) {
		this.ip_tenmien = ip_tenmien;
	}

	// Convert Xml to Nics Root
	public static Nics Nics_convert(String url) throws FileNotFoundException {
		try {
			JAXBContext jaxb = JAXBContext.newInstance(Nics.class);
			Unmarshaller un = jaxb.createUnmarshaller();
			Nics nics = (Nics) un.unmarshal(new File(url));

			return nics;

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	// get Text tu xml - Luu y ko nen de "\n" neu muon chuyen qua Ubuntu server
	public String getTextConfig(Nics nics) {
		String kq = "";
		for (Nic nic : nics.getNic()) {
			String chuoi = "iface " + nic.id + " inet " + nic.type 
					+ " address " + nic.address + " netmask " + nic.netmask
					+ " gateway " + nic.gateway + " network " + nic.network
					+ " broadcast " + nic.broadcast;
			try {
				for (int i = 0; i <= nic.ip_tenmien[i].length(); i++) {
					chuoi = chuoi + nic.ip_tenmien[i];
				}
			} catch (ArrayIndexOutOfBoundsException ar) {

			}
			kq = kq + chuoi;
		}

		return kq;

	}

	public static void uploadToServer(String url) throws FileNotFoundException {
		String goi;
		Nic nic = new Nic();
		Nics ns = Nic.Nics_convert(url);
		goi = nic.getTextConfig(ns);
		System.out.print(goi);
		// Set su kien o day

	}

	public void Nics_To_XML() throws NullPointerException, IOException {
		DocFile();
	}

	// Ghi tung dong chua giai quyet dc.
	public static void GhiFile(Nics nics) throws IOException {
		Nic nic = new Nic();
		FileOutputStream f = new FileOutputStream("E:/Nic_Config3.doc");
		PrintWriter pw = new PrintWriter(f);
		String file = nic.getTextConfig(nics);
		pw.println(file);
		pw.print("\n");
		pw.flush();
		pw.close();

	}

	// Doc file
	public static void DocFile() throws NullPointerException, IOException {

		// Doc file va in ra
		FileInputStream f = new FileInputStream(new File("E:/Nic_Config.txt"));
		int i = 0;
		while (i != -1) {

			i = f.read();
			if (i != -1) {
				System.out.print((char) i);

			}
		}

	}

	public static void main(String[] args) throws IOException,
			ClassCastException {
		Nics nics = Nics_convert("E:/XML_File/NIC.xml");
		Nic nic = new Nic();
		// uploadToServer("E:/XML_File/NIC.xml");
		// GhiFile(nics);
		// Nics ns = Nic.Nics_convert("E:/XML_File/NIC.xml");
		String ketqua = nic.getTextConfig(nics);
		System.out.print(ketqua);
		// ns.getTextConfig();
		// System.out.print(n.getTextConfig());
		// Doc file
		// DocFile();

	}
}
