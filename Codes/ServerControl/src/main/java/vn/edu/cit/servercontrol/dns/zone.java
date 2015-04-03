package vn.edu.cit.servercontrol.dns;

import java.util.List;

public class zone {
	String ten_zone;
	String type;
	String path_file;
	// SOA Structure
	String tenmien;
	String email;
	double serial_number;
	double refresh;
	double retry;
	double expire;
	double min_ttl;
	List <record> records;

	public zone() {
	}

	public zone(String ten_zone, String type, String path_file, String tenmien,
			String email, double serial_number, double refresh, double retry,
			double expire, double min_ttl, List <record> records) {
		super();
		this.ten_zone = ten_zone;
		this.type = type;
		this.path_file = path_file;
		this.tenmien = tenmien;
		this.email = email;
		this.serial_number = serial_number;
		this.refresh = refresh;
		this.retry = retry;
		this.expire = expire;
		this.min_ttl = min_ttl;
		this.records = records;
	}

	public String getTen_zone() {
		return ten_zone;
	}

	public void setTen_zone(String ten_zone) {
		this.ten_zone = ten_zone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath_file() {
		return path_file;
	}

	public void setPath_file(String path_file) {
		this.path_file = path_file;
	}

	public String getTenmien() {
		return tenmien;
	}

	public void setTenmien(String tenmien) {
		this.tenmien = tenmien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(double serial_number) {
		this.serial_number = serial_number;
	}

	public double getRefresh() {
		return refresh;
	}

	public void setRefresh(double refresh) {
		this.refresh = refresh;
	}

	public double getRetry() {
		return retry;
	}

	public void setRetry(double retry) {
		this.retry = retry;
	}

	public double getExpire() {
		return expire;
	}

	public void setExpire(double expire) {
		this.expire = expire;
	}

	public double getMin_ttl() {
		return min_ttl;
	}

	public void setMin_ttl(double min_ttl) {
		this.min_ttl = min_ttl;
	}

	public List<record> getRecords() {
		return records;
	}

	public void setRecords(List<record> records) {
		this.records = records;
	}

}
