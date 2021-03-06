package model.dhcp;

import java.util.List;

public class Subnet {
	String subnet;
	String netmask;
	String range;
	String domain_name_server;
	String domain_name;
	String router_gateway;
	String broadcast_address;
	String default_lease_time;
	String max_lease_time;

	public Subnet() {
	}

	public Subnet(String subnet, String netmask, String range,
			String domain_name_server, String domain_name,
			String router_gateway, String broadcast_address,
			String default_lease_time, String max_lease_time) {
		super();
		this.subnet = subnet;
		this.netmask = netmask;
		this.range = range;
		this.domain_name_server = domain_name_server;
		this.domain_name = domain_name;
		this.router_gateway = router_gateway;
		this.broadcast_address = broadcast_address;
		this.default_lease_time = default_lease_time;
		this.max_lease_time = max_lease_time;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getDomain_name_server() {
		return domain_name_server;
	}

	public void setDomain_name_server(String domain_name_server) {
		this.domain_name_server = domain_name_server;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public String getRouter_gateway() {
		return router_gateway;
	}

	public void setRouter_gateway(String router_gateway) {
		this.router_gateway = router_gateway;
	}

	public String getBroadcast_address() {
		return broadcast_address;
	}

	public void setBroadcast_address(String broadcast_address) {
		this.broadcast_address = broadcast_address;
	}

	public String getDefault_lease_time() {
		return default_lease_time;
	}

	public void setDefault_lease_time(String default_lease_time) {
		this.default_lease_time = default_lease_time;
	}

	public String getMax_lease_time() {
		return max_lease_time;
	}

	public void setMax_lease_time(String max_lease_time) {
		this.max_lease_time = max_lease_time;
	}

}
