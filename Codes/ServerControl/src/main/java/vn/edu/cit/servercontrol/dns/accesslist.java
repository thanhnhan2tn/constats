package vn.edu.cit.servercontrol.dns;

import java.util.List;

public class accesslist {
	String access_name;
	List<String> ip;

	public accesslist() {
	}

	public accesslist(String access_name, List<String> ip) {
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
