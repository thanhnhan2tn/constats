package vn.edu.cit.servercontrol.dns;

import java.util.List;

public class option {
	String directory;
	String recursion;
	List<String> allow_transfer;
	List<String> allow_update_forwarding;
	List<String> allow_notify;
	List<String> allow_query;
	List<String> forwarders;
	String forward_only;

	public option() {
	}

	public option(String directory, String recursion,
			List<String> allow_transfer, List<String> allow_update_forwarding,
			List<String> allow_notify, List<String> allow_query,
			List<String> forwarders, String forward_only) {
		super();
		this.directory = directory;
		this.recursion = recursion;
		this.allow_transfer = allow_transfer;
		this.allow_update_forwarding = allow_update_forwarding;
		this.allow_notify = allow_notify;
		this.allow_query = allow_query;
		this.forwarders = forwarders;
		this.forward_only = forward_only;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getRecursion() {
		return recursion;
	}

	public void setRecursion(String recursion) {
		this.recursion = recursion;
	}

	public List<String> getAllow_transfer() {
		return allow_transfer;
	}

	public void setAllow_transfer(List<String> allow_transfer) {
		this.allow_transfer = allow_transfer;
	}

	public List<String> getAllow_update_forwarding() {
		return allow_update_forwarding;
	}

	public void setAllow_update_forwarding(List<String> allow_update_forwarding) {
		this.allow_update_forwarding = allow_update_forwarding;
	}

	public List<String> getAllow_notify() {
		return allow_notify;
	}

	public void setAllow_notify(List<String> allow_notify) {
		this.allow_notify = allow_notify;
	}

	public List<String> getAllow_query() {
		return allow_query;
	}

	public void setAllow_query(List<String> allow_query) {
		this.allow_query = allow_query;
	}

	public List<String> getForwarders() {
		return forwarders;
	}

	public void setForwarders(List<String> forwarders) {
		this.forwarders = forwarders;
	}

	public String getForward_only() {
		return forward_only;
	}

	public void setForward_only(String forward_only) {
		this.forward_only = forward_only;
	}

}
