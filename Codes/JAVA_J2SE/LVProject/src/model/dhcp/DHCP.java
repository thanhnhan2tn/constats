package model.dhcp;

import java.util.List;

public class DHCP {
	int default_lease_time;
	int max_lease_time;
	String authorative;
	String log_facitily;
	List<Subnet> Subnets;
	List<HostFixIP> hosts;

	public DHCP() {
		// TODO Auto-generated constructor stub
	}

	public DHCP(int default_lease_time, int max_lease_time, String authorative,
			String log_facitily, List<Subnet> subnets, List<HostFixIP> hosts) {
		super();
		this.default_lease_time = default_lease_time;
		this.max_lease_time = max_lease_time;
		this.authorative = authorative;
		this.log_facitily = log_facitily;
		Subnets = subnets;
		this.hosts = hosts;
	}

	public int getDefault_lease_time() {
		return default_lease_time;
	}

	public void setDefault_lease_time(int default_lease_time) {
		this.default_lease_time = default_lease_time;
	}

	public int getMax_lease_time() {
		return max_lease_time;
	}

	public void setMax_lease_time(int max_lease_time) {
		this.max_lease_time = max_lease_time;
	}

	public String getAuthorative() {
		return authorative;
	}

	public void setAuthorative(String authorative) {
		this.authorative = authorative;
	}

	public String getLog_facitily() {
		return log_facitily;
	}

	public void setLog_facitily(String log_facitily) {
		this.log_facitily = log_facitily;
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
