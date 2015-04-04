package vn.edu.cit.servercontrol.dhcp;

import java.util.List;

public class DHCP {
	ConfigChung configchung;
	List<Subnet> Subnets;
	List<HostFixIP> hosts;

	public DHCP() {
	}

	public DHCP(ConfigChung configchung, List<Subnet> subnets,
			List<HostFixIP> hosts) {
		super();
		this.configchung = configchung;
		Subnets = subnets;
		this.hosts = hosts;
	}

	public ConfigChung getConfigchung() {
		return configchung;
	}

	public void setConfigchung(ConfigChung configchung) {
		this.configchung = configchung;
	}

	public List<Subnet> getSubnets() {
		return Subnets;
	}

	public void setSubnets(List<Subnet> subnets) {
		Subnets = subnets;
	}

	public List<HostFixIP> getHosts() {
		return hosts;
	}

	public void setHosts(List<HostFixIP> hosts) {
		this.hosts = hosts;
	}

}
