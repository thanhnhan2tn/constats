import java.util.List;

public class Nic {
	String nic_id;
	String type;
	String address;
	String netmask;
	String gateway;
	String network;
	String broadcast;
	// Dung list co uu diem tot hon dung 1 mang String[]
	List<String> ip_tenmien;

	public Nic() {
		super();
	}

	public Nic(String nic_id, String type, String address, String netmask,
			String gateway, String network, String broadcast,
			List<String> ip_tenmien) {
		super();
		this.nic_id = nic_id;
		this.type = type;
		this.address = address;
		this.netmask = netmask;
		this.gateway = gateway;
		this.network = network;
		this.broadcast = broadcast;
		this.ip_tenmien = ip_tenmien;
	}

	public String getNic_id() {
		return nic_id;
	}

	public void setNic_id(String nic_id) {
		this.nic_id = nic_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getIp_tenmien() {
		return ip_tenmien;
	}

	public void setIp_tenmien(List<String> ip_tenmien) {
		this.ip_tenmien = ip_tenmien;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

}
