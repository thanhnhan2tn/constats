package vn.edu.cit.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author ThanhNhan
 *
 */
@Document(collection = "serverstatus")
public class ServerStatus {
	private Server server;
	private Date time;
	private String cpu;
	private String ram;
	private String disk;

	public ServerStatus(Server server, Date time, String cpu, String ram,
			String disk) {
		super();
		this.server = server;
		this.time = time;
		this.cpu = cpu;
		this.ram = ram;
		this.disk = disk;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
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
