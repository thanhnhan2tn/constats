public class ServerInfo {

	String cpuUsage;
	String memTotal;
	String memUsage;
	String memFree;
	String totalLocalDisk;
	String usedLocalDisk;
	String freeLocalDisk;

	public ServerInfo() {
		// TODO Auto-generated constructor stub
	}

	public ServerInfo(String cpuUsage, String memTotal, String memUsage,
			String memFree, String totalLocalDisk, String usedLocalDisk,
			String freeLocalDisk) {
		super();
		this.cpuUsage = cpuUsage;
		this.memTotal = memTotal;
		this.memUsage = memUsage;
		this.memFree = memFree;
		this.totalLocalDisk = totalLocalDisk;
		this.usedLocalDisk = usedLocalDisk;
		this.freeLocalDisk = freeLocalDisk;
	}

	public String getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(String cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public String getMemTotal() {
		return memTotal;
	}

	public void setMemTotal(String memTotal) {
		this.memTotal = memTotal;
	}

	public String getMemUsage() {
		return memUsage;
	}

	public void setMemUsage(String memUsage) {
		this.memUsage = memUsage;
	}

	public String getMemFree() {
		return memFree;
	}

	public void setMemFree(String memFree) {
		this.memFree = memFree;
	}

	public String getTotalLocalDisk() {
		return totalLocalDisk;
	}

	public void setTotalLocalDisk(String totalLocalDisk) {
		this.totalLocalDisk = totalLocalDisk;
	}

	public String getUsedLocalDisk() {
		return usedLocalDisk;
	}

	public void setUsedLocalDisk(String usedLocalDisk) {
		this.usedLocalDisk = usedLocalDisk;
	}

	public String getFreeLocalDisk() {
		return freeLocalDisk;
	}

	public void setFreeLocalDisk(String freeLocalDisk) {
		this.freeLocalDisk = freeLocalDisk;
	}

}
