package vn.edu.cit.servercontrol.dhcp;

public class ConfigChung {
	String dns_update_style;
	String authorative;
	String log_facitily;

	public ConfigChung() {
		// TODO Auto-generated constructor stub
	}

	public ConfigChung(String dns_update_style, String authorative,
			String log_facitily) {
		super();
		this.dns_update_style = dns_update_style;
		this.authorative = authorative;
		this.log_facitily = log_facitily;
	}

	public String getDns_update_style() {
		return dns_update_style;
	}

	public void setDns_update_style(String dns_update_style) {
		this.dns_update_style = dns_update_style;
	}

	public String getAuthorative() {
		return authorative;
	}

	public void setAuthorative(String authorative) {
		this.authorative = authorative;
	}

	public String getLog_facitily() {
		return log_facitily;
	}

	public void setLog_facitily(String log_facitily) {
		this.log_facitily = log_facitily;
	}

}
