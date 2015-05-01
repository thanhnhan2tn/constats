package model.dns;

import java.util.List;

public class SOA {
	// SOA Structure
	String ttl;
	String domain_name;
	String admin_domain;
	int serial;
	int refresh;
	int retry;
	int expire;
	int min_ttl;
	List<Record> record;
	String pathfile;

	public SOA() {
		// TODO Auto-generated constructor stub
	}

	public SOA(String ttl, String domain_name, String admin_domain, int serial,
			int refresh, int retry, int expire, int min_ttl,
			List<Record> record, String pathfile) {
		super();
		this.ttl = ttl;
		this.domain_name = domain_name;
		this.admin_domain = admin_domain;
		this.serial = serial;
		this.refresh = refresh;
		this.retry = retry;
		this.expire = expire;
		this.min_ttl = min_ttl;
		this.record = record;
		this.pathfile = pathfile;
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

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public int getRefresh() {
		return refresh;
	}

	public void setRefresh(int refresh) {
		this.refresh = refresh;
	}

	public int getRetry() {
		return retry;
	}

	public void setRetry(int retry) {
		this.retry = retry;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public int getMin_ttl() {
		return min_ttl;
	}

	public void setMin_ttl(int min_ttl) {
		this.min_ttl = min_ttl;
	}

	public List<Record> getRecord() {
		return record;
	}

	public void setRecord(List<Record> record) {
		this.record = record;
	}

	public String getPathfile() {
		return pathfile;
	}

	public void setPathfile(String pathfile) {
		this.pathfile = pathfile;
	}

}
