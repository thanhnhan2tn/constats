package vn.edu.cit.model;

import java.util.Date;

public class ServerStatus {
	private int serverStatusId;
	private int serverId;
	private Date time;
	private String cpu;
	private String ram;
	private String disk;
	
	public int getServerStatusId() {
		return serverStatusId;
	}
	public void setServerStatusId(int serverStatusId) {
		this.serverStatusId = serverStatusId;
	}
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getDisk() {
		return disk;
	}
	public void setDisk(String disk) {
		this.disk = disk;
	}
	
}
