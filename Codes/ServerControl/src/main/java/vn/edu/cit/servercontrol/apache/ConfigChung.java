package vn.edu.cit.servercontrol.apache;

public class ConfigChung {
	String port;// Xy ly rieng ben port.conf
	String time_out;// time
	String keepAlive;// on/off
	String maxKeepAliveRequest; // number
	String keepAliveTimeout;// time 5s
	String pathErrorLog;
	String logLevel;// warn

	public ConfigChung() {
		// TODO Auto-generated constructor stub
	}

	public ConfigChung(String port, String time_out, String keepAlive,
			String maxKeepAliveRequest, String keepAliveTimeout,
			String pathErrorLog, String logLevel) {
		super();
		this.port = port;
		this.time_out = time_out;
		this.keepAlive = keepAlive;
		this.maxKeepAliveRequest = maxKeepAliveRequest;
		this.keepAliveTimeout = keepAliveTimeout;
		this.pathErrorLog = pathErrorLog;
		this.logLevel = logLevel;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getTime_out() {
		return time_out;
	}

	public void setTime_out(String time_out) {
		this.time_out = time_out;
	}

	public String getKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(String keepAlive) {
		this.keepAlive = keepAlive;
	}

	public String getMaxKeepAliveRequest() {
		return maxKeepAliveRequest;
	}

	public void setMaxKeepAliveRequest(String maxKeepAliveRequest) {
		this.maxKeepAliveRequest = maxKeepAliveRequest;
	}

	public String getKeepAliveTimeout() {
		return keepAliveTimeout;
	}

	public void setKeepAliveTimeout(String keepAliveTimeout) {
		this.keepAliveTimeout = keepAliveTimeout;
	}

	public String getPathErrorLog() {
		return pathErrorLog;
	}

	public void setPathErrorLog(String pathErrorLog) {
		this.pathErrorLog = pathErrorLog;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

}
