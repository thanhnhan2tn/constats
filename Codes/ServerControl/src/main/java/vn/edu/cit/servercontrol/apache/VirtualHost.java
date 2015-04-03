package vn.edu.cit.servercontrol.apache;

//(1-n) Vitual Host
public class VirtualHost {
	String vitualhost;
	String servername;
	String serveradmin;
	String documentRoot;
	String alias;
	String errorLog;
	String customLog;

	public VirtualHost() {
		// TODO Auto-generated constructor stub
	}

	public VirtualHost(String vitualhost, String servername, String serveradmin,
			String documentRoot, String alias, String errorLog, String customLog) {
		super();
		this.vitualhost = vitualhost;
		this.servername = servername;
		this.serveradmin = serveradmin;
		this.documentRoot = documentRoot;
		this.alias = alias;
		this.errorLog = errorLog;
		this.customLog = customLog;
	}

	public String getVitualhost() {
		return vitualhost;
	}

	public void setVitualhost(String vitualhost) {
		this.vitualhost = vitualhost;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getServeradmin() {
		return serveradmin;
	}

	public void setServeradmin(String serveradmin) {
		this.serveradmin = serveradmin;
	}

	public String getDocumentRoot() {
		return documentRoot;
	}

	public void setDocumentRoot(String documentRoot) {
		this.documentRoot = documentRoot;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getErrorLog() {
		return errorLog;
	}

	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	public String getCustomLog() {
		return customLog;
	}

	public void setCustomLog(String customLog) {
		this.customLog = customLog;
	}

}
