package model.dhcp;

public class HostFixIP {
	String hostname;
	String hardware_internet;
	String fixed_address;

	public HostFixIP() {
		// TODO Auto-generated constructor stub
	}

	public HostFixIP(String hostname, String hardware_internet,
			String fixed_address) {
		super();
		this.hostname = hostname;
		this.hardware_internet = hardware_internet;
		this.fixed_address = fixed_address;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getHardware_internet() {
		return hardware_internet;
	}

	public void setHardware_internet(String hardware_internet) {
		this.hardware_internet = hardware_internet;
	}

	public String getFixed_address() {
		return fixed_address;
	}

	public void setFixed_address(String fixed_address) {
		this.fixed_address = fixed_address;
	}

}
