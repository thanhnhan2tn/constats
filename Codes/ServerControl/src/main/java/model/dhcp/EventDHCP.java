package model.dhcp;

public class EventDHCP {
	String lease;
	String start;
	String end;
	String hardware_ethernet;

	public EventDHCP() {
		// TODO Auto-generated constructor stub
	}

	public EventDHCP(String lease, String start, String end,
			String hardware_ethernet) {
		super();
		this.lease = lease;
		this.start = start;
		this.end = end;
		this.hardware_ethernet = hardware_ethernet;
	}

	public String getLease() {
		return lease;
	}

	public void setLease(String lease) {
		this.lease = lease;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getHardware_ethernet() {
		return hardware_ethernet;
	}

	public void setHardware_ethernet(String hardware_ethernet) {
		this.hardware_ethernet = hardware_ethernet;
	}

}
