package model.dns;

import java.util.List;

public class Zone {
	String zone_name;
	String zone_type;
	String zone_file;
	// Danh cho zone forward luu tru ip
	String forwarders;
	// Danh cho zone slave luu tru ip
	String masters;

	public Zone() {
	}

	public Zone(String zone_name, String zone_type, String zone_file,
			String forwarders, String masters) {
		super();
		this.zone_name = zone_name;
		this.zone_type = zone_type;
		this.zone_file = zone_file;
		this.forwarders = forwarders;
		this.masters = masters;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public String getZone_type() {
		return zone_type;
	}

	public void setZone_type(String zone_type) {
		this.zone_type = zone_type;
	}

	public String getZone_file() {
		return zone_file;
	}

	public void setZone_file(String zone_file) {
		this.zone_file = zone_file;
	}

	public String getForwarders() {
		return forwarders;
	}

	public void setForwarders(String forwarders) {
		this.forwarders = forwarders;
	}

	public String getMasters() {
		return masters;
	}

	public void setMasters(String masters) {
		this.masters = masters;
	}

}