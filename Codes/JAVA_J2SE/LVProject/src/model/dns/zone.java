package model.dns;

import java.util.List;

public class Zone {
	String name_zone;
	String type_zone;
	String path_file;
	SOA soa;

	public Zone() {
	}

	public Zone(String name_zone, String type_zone, String path_file, SOA soa) {
		super();
		this.name_zone = name_zone;
		this.type_zone = type_zone;
		this.path_file = path_file;
		this.soa = soa;
	}

	public String getName_zone() {
		return name_zone;
	}

	public void setName_zone(String name_zone) {
		this.name_zone = name_zone;
	}

	public String getType_zone() {
		return type_zone;
	}

	public void setType_zone(String type_zone) {
		this.type_zone = type_zone;
	}

	public String getPath_file() {
		return path_file;
	}

	public void setPath_file(String path_file) {
		this.path_file = path_file;
	}

	public SOA getSoa() {
		return soa;
	}

	public void setSoa(SOA soa) {
		this.soa = soa;
	}

}