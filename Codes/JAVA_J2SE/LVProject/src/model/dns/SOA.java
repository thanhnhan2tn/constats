package model.dns;

import java.util.List;

public class SOA {
	// SOA Structure
	String ttl;
	String domain_name;
	String admin_domain;
	double serial_number;
	double refresh;
	double retry;
	double expire;
	double min_ttl;
	List<Record> record;

	public SOA() {
		// TODO Auto-generated constructor stub
	}

	public String getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public String getAdmin_domain() {
		return admin_domain;
	}

	public void setAdmin_domain(String admin_domain) {
		this.admin_domain = admin_domain;
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

	public List<Record> getRecord() {
		return record;
	}

	public void setRecord(List<Record> record) {
		this.record = record;
	}

}
