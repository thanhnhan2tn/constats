package model.dns;

public class Record {
	// maya. IN NS maya.
	// maya. IN A 192.168.0.109
	String domain_name;
	String type_record; // A or NS or CNAME or PTR
	String name_server;// Name of server quan ly domain_name

	public Record() {
	}

	public Record(String domain_name, String type_record, String name_server) {
		super();
		this.domain_name = domain_name;
		this.type_record = type_record;
		this.name_server = name_server;
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

	public String getName_server() {
		return name_server;
	}

	public void setName_server(String name_server) {
		this.name_server = name_server;
	}

}