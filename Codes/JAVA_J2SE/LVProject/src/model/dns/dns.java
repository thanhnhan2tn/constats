package model.dns;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "dns")
@XmlType(propOrder = { "zone", "option", "acl" })
public class Dns {
	List<Zone> zone;
	Option option; // option la cua chung
	List<Accesslist> acl;

	public Dns() {
		// TODO Auto-generated constructor stub
	}

	public Dns(List<Zone> zone, Option option, List<Accesslist> acl) {
		super();
		this.zone = zone;
		this.option = option;
		this.acl = acl;
	}

	@XmlElement
	public List<Zone> getZone() {
		return zone;
	}

	public void setZone(List<Zone> zone) {
		this.zone = zone;
	}

	@XmlElement
	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	@XmlElement
	public List<Accesslist> getAcl() {
		return acl;
	}

	public void setAcl(List<Accesslist> acl) {
		this.acl = acl;
	}

}
