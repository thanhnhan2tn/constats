package vn.edu.cit.servercontrol.nic;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nic")
@XmlType(propOrder = { "eth", "dns_nameservers" })
public class Nic {
	List<Eth> eth;
	List<String> dns_nameservers;

	public Nic() {
	}

	public Nic(List<Eth> eth, List<String> dns_nameservers) {
		super();
		this.eth = eth;
		this.dns_nameservers = dns_nameservers;
	}

	@XmlElement
	public List<Eth> getEth() {
		return eth;
	}

	public void setEth(List<Eth> eth) {
		this.eth = eth;
	}

	@XmlElement
	public List<String> getDns_nameservers() {
		return dns_nameservers;
	}

	public void setDns_nameservers(List<String> dns_nameservers) {
		this.dns_nameservers = dns_nameservers;
	}

}
