package vn.edu.cit.servercontrol.nic;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nic")
@XmlType(propOrder = { "eth" })
public class Nic {
	List<Eth> eth;

	public Nic() {
	}

	public Nic(List<Eth> eth) {
		super();
		this.eth = eth;
	}

	@XmlElement
	public List<Eth> getEth() {
		return eth;
	}

	public void setEth(List<Eth> eth) {
		this.eth = eth;
	}

}
