package vn.edu.cit.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author ThanhNhan
 *
 */
@Document(collection = "serverstatus")
public class ServerStatus {
	private Date time;
	private String cpu;
	private String ram;
	private String disk;
	private boolean up;
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
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public ServerStatus(Date time, String cpu, String ram, String disk, boolean up) {
		super();
		this.time = time;
		this.cpu = cpu;
		this.ram = ram;
		this.disk = disk;
		this.up = up;
	}
	
}