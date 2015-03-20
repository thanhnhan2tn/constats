package model.dns;


public class record {
	// maya. IN NS maya.
	// maya. IN A 192.168.0.109
	String domain_name;
	String type_record; // A or NS or CNAME or PTR
	String nameserver;

	public record() {
	}

	public record(String domain_name, String type_record, String nameserver) {
		super();
		this.domain_name = domain_name;
		this.type_record = type_record;
		this.nameserver = nameserver;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public String getType_record() {
		return type_record;
	}

	public void setType_record(String type_record) {
		this.type_record = type_record;
	}

	public String getNameserver() {
		return nameserver;
	}

	public void setNameserver(String nameserver) {
		this.nameserver = nameserver;
	}

}
