package vn.edu.cit.servercontrol.apache;

public class Directory {
	String pathFile;// pathString
	String options; // String
	String allowOverride; // none
	String requireAll;// granted/denied
	String order;// allow,deny
	String deny; // from all
	String allow;// from all

	public Directory() {
		// TODO Auto-generated constructor stub
	}

	public Directory(String pathFile, String options, String allowOverride,
			String requireAll, String order, String deny, String allow) {
		super();
		this.pathFile = pathFile;
		this.options = options;
		this.allowOverride = allowOverride;
		this.requireAll = requireAll;
		this.order = order;
		this.deny = deny;
		this.allow = allow;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getAllowOverride() {
		return allowOverride;
	}

	public void setAllowOverride(String allowOverride) {
		this.allowOverride = allowOverride;
	}

	public String getRequireAll() {
		return requireAll;
	}

	public void setRequireAll(String requireAll) {
		this.requireAll = requireAll;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

}
