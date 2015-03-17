public class Nic {
	String address;
	String netmask;
	String gateway;
	
	
	public Nic() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Nic(String address, String netmask, String gateway) {
		super();
		this.address = address;
		this.netmask = netmask;
		this.gateway = gateway;
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
