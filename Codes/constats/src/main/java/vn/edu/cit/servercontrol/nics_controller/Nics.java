package vn.edu.cit.servercontrol.nics_controller;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nics")
@XmlType(propOrder = { "nic" })
public class Nics {
	List<Nic> nic;

	public Nics(List<Nic> nic) {
		super();
		this.nic = nic;
	}

	public Nics() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlElement
	public List<Nic> getNic() {
		return nic;
	}

	public void setNic(List<Nic> nic) {
		this.nic = nic;
	}

}
