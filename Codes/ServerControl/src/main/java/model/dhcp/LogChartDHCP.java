package model.dhcp;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "logchartdhcp")
@XmlType(propOrder = { "eventdhcp" })
public class LogChartDHCP {
	List<EventDHCP> eventdhcp;

	public LogChartDHCP() {
		// TODO Auto-generated constructor stub
	}

	public LogChartDHCP(List<EventDHCP> eventdhcp) {
		super();
		this.eventdhcp = eventdhcp;
	}

	@XmlElement
	public List<EventDHCP> getEventdhcp() {
		return eventdhcp;
	}

	public void setEventdhcp(List<EventDHCP> eventdhcp) {
		this.eventdhcp = eventdhcp;
	}

}
