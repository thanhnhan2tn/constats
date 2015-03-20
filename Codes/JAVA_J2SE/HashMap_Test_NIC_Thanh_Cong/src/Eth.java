import java.util.List;

public class Eth {
	String name;
	String type;
	String address;
	String netmask;
	String gateway;
	String network;
	String broadcast;

	public Eth() {
		super();
	}

	public Eth(String name, String type, String address, String netmask,
			String gateway, String network, String broadcast) {
		super();
		this.name = name;
		this.type = type;
		this.address = address;
		this.netmask = netmask;
		this.gateway = gateway;
		this.network = network;
		this.broadcast = broadcast;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
