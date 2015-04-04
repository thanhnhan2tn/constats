package model.dns;

import java.util.List;

public class Accesslist {
	String access_name;
	List<String> ip;

	public Accesslist() {
	}

	public Accesslist(String access_name, List<String> ip) {
		super();
		this.access_name = access_name;
		this.ip = ip;
	}

	public String getAccess_name() {
		return access_name;
	}

	public void setAccess_name(String access_name) {
		this.access_name = access_name;
	}

	public List<String> getIp() {
		return ip;
	}

	public void setIp(List<String> ip) {
		this.ip = ip;
	}

}
