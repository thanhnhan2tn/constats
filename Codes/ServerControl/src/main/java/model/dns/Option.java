package model.dns;

import java.util.List;

public class Option {
	String directory;
	Boolean recursion;
	Boolean multiple_cname;
	Boolean forward;
	// ------------
	String allow_transfer;
	String allow_notify;
	String allow_query;
	String allow_recursion;
	String forwarders;

	public Option() {
	}

	public Option(String directory, Boolean recursion, Boolean multiple_cname,
			Boolean forward, String allow_transfer, String allow_notify,
			String allow_query, String allow_recursion, String forwarders) {
		super();
		this.directory = directory;
		this.recursion = recursion;
		this.multiple_cname = multiple_cname;
		this.forward = forward;
		this.allow_transfer = allow_transfer;
		this.allow_notify = allow_notify;
		this.allow_query = allow_query;
		this.allow_recursion = allow_recursion;
		this.forwarders = forwarders;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public Boolean getRecursion() {
		return recursion;
	}

	public void setRecursion(Boolean recursion) {
		this.recursion = recursion;
	}

	public Boolean getMultiple_cname() {
		return multiple_cname;
	}

	public void setMultiple_cname(Boolean multiple_cname) {
		this.multiple_cname = multiple_cname;
	}

	public Boolean getForward() {
		return forward;
	}

	public void setForward(Boolean forward) {
		this.forward = forward;
	}

	public String getAllow_transfer() {
		return allow_transfer;
	}

	public void setAllow_transfer(String allow_transfer) {
		this.allow_transfer = allow_transfer;
	}

	public String getAllow_notify() {
		return allow_notify;
	}

	public void setAllow_notify(String allow_notify) {
		this.allow_notify = allow_notify;
	}

	public String getAllow_query() {
		return allow_query;
	}

	public void setAllow_query(String allow_query) {
		this.allow_query = allow_query;
	}

	public String getAllow_recursion() {
		return allow_recursion;
	}

	public void setAllow_recursion(String allow_recursion) {
		this.allow_recursion = allow_recursion;
	}

	public String getForwarders() {
		return forwarders;
	}

	public void setForwarders(String forwarders) {
		this.forwarders = forwarders;
	}

}
