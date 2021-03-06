package model.server;

public class ServerStatus {
	String hostname;
	String osversion;
	String kernel;
	String timeonsys;
	String processor_info;
	String uptime;
	String memtotal;
	String memused;
	String memfree;
	String memcached;
	String cpu_usage;
	String cpu_loadaverage;
	String local_disk;

	public ServerStatus() {
	}

	public ServerStatus(String hostname, String osversion, String kernel, String timeonsys, String processor_info,
			String uptime, String memtotal, String memused, String memfree, String memcached, String cpu_usage,
			String cpu_loadaverage, String local_disk) {
		super();
		this.hostname = hostname;
		this.osversion = osversion;
		this.kernel = kernel;
		this.timeonsys = timeonsys;
		this.processor_info = processor_info;
		this.uptime = uptime;
		this.memtotal = memtotal;
		this.memused = memused;
		this.memfree = memfree;
		this.memcached = memcached;
		this.cpu_usage = cpu_usage;
		this.cpu_loadaverage = cpu_loadaverage;
		this.local_disk = local_disk;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getOsversion() {
		return osversion;
	}

	public void setOsversion(String osversion) {
		this.osversion = osversion;
	}

	public String getKernel() {
		return kernel;
	}

	public void setKernel(String kernel) {
		this.kernel = kernel;
	}

	public String getTimeonsys() {
		return timeonsys;
	}

	public void setTimeonsys(String timeonsys) {
		this.timeonsys = timeonsys;
	}

	public String getProcessor_info() {
		return processor_info;
	}

	public void setProcessor_info(String processor_info) {
		this.processor_info = processor_info;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getMemtotal() {
		return memtotal;
	}

	public void setMemtotal(String memtotal) {
		this.memtotal = memtotal;
	}

	public String getMemused() {
		return memused;
	}

	public void setMemused(String memused) {
		this.memused = memused;
	}

	public String getMemfree() {
		return memfree;
	}

	public void setMemfree(String memfree) {
		this.memfree = memfree;
	}

	public String getMemcached() {
		return memcached;
	}

	public void setMemcached(String memcached) {
		this.memcached = memcached;
	}

	public String getCpu_usage() {
		return cpu_usage;
	}

	public void setCpu_usage(String cpu_usage) {
		this.cpu_usage = cpu_usage;
	}

	public String getCpu_loadaverage() {
		return cpu_loadaverage;
	}

	public void setCpu_loadaverage(String cpu_loadaverage) {
		this.cpu_loadaverage = cpu_loadaverage;
	}

	public String getLocal_disk() {
		return local_disk;
	}

	public void setLocal_disk(String local_disk) {
		this.local_disk = local_disk;
	}

}
