package vn.edu.cit.servercontrol.nic;

public class Eth {
	String iface;
	String inet;
	String address;
	String netmask;
	String gateway;
	String network;
	String broadcast;
	String dns_nameservers;

	// Dung list co uu diem tot hon dung 1 mang String[]

	public Eth() {
		super();
	}

	public Eth(String iface, String inet, String address, String netmask,
			String gateway, String network, String broadcast,
			String dns_nameservers) {
		super();
		this.iface = iface;
		this.inet = inet;
		this.address = address;
		this.netmask = netmask;
		this.gateway = gateway;
		this.network = network;
		this.broadcast = broadcast;
		this.dns_nameservers = dns_nameservers;
	}

	public String getIface() {
		return iface;
	}

	public void setIface(String iface) {
		this.iface = iface;
	}

	public String getInet() {
		return inet;
	}

	public void setInet(String inet) {
		this.inet = inet;
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

	public String getDns_nameservers() {
		return dns_nameservers;
	}

	public void setDns_nameservers(String dns_nameservers) {
		this.dns_nameservers = dns_nameservers;
	}

	

	

}
